package com.rbs.avail.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.rbs.avail.dto.ResortOfferRequestDTO;
import com.rbs.avail.dto.ResortOfferResponseDTO;
import com.rbs.avail.model.Occupancy;
import com.rbs.avail.model.Offer;
import com.rbs.avail.model.PaxPrice;
import com.rbs.avail.model.RoomType;
import com.rbs.avail.model.Supplier;
import com.rbs.avail.repository.OccupancyRepository;
import com.rbs.avail.repository.PriceRepository;
import com.rbs.avail.repository.RoomTypeRepository;
import com.rbs.avail.repository.SupplierRepository;

@Component
public class AvailServiceHelper {

	private static final Logger logger = LoggerFactory.getLogger(AvailServiceHelper.class);

	@Autowired
	private PriceRepository priceRepository;

	@Autowired
	private SupplierRepository supplierRepository;

	@Autowired
	private RoomTypeRepository roomTypeRepository;

	@Autowired
	private OccupancyRepository occupancyRepository;

	@Autowired
	private RedisTemplate redisTemplate;
	public static final String HASH_KEY = "prices";

	public List<ResortOfferResponseDTO> getValidOffers(List<Offer> offers, ResortOfferRequestDTO request) {
		List<PaxPrice> prices = redisTemplate.opsForHash().values(HASH_KEY);
		if(!(prices.size()>0)) {
			prices = priceRepository.findAll();
			for(PaxPrice p:prices){
				logger.info("PaxPrice ->"+p.getPriceCompositID());
			}
			prices.forEach(p-> redisTemplate.opsForHash().put(HASH_KEY,p.getPriceCompositID(),p));
		}
		List<PaxPrice> filteredPrices = new ArrayList<PaxPrice>();
		List<Occupancy> occupancies = occupancyRepository.findAll();

		for (Occupancy oc : occupancies) {

			String[] occ = oc.getOccupancy().split(",");
			String aAccupancy = occ[0];
			int aAC = Character.getNumericValue(aAccupancy.charAt(0));
			String cAccupancy = occ[1];
			int cAC = Character.getNumericValue(cAccupancy.charAt(0));
			String iAccupancy = occ[2];
			int iAC = Character.getNumericValue(iAccupancy.charAt(0));

			// int paxCount = request.getAdultCount() + request.getChildCount() +
			// request.getInfantCount();

			if (request.getAdultCount() <= aAC && request.getChildCount() <= cAC && request.getInfantCount() <= iAC) {
				for (PaxPrice p : prices) {
					if (p.getPriceCompositID().getRoomCode().equals(oc.getRoom_code()))
						filteredPrices.add(p);
					continue;
				}
			}
		}
		logger.info("Filterd Prices count: " + filteredPrices.size());
		List<ResortOfferResponseDTO> offerResults = new ArrayList<ResortOfferResponseDTO>();

		for (Offer offer : offers) {

			for (PaxPrice price : filteredPrices) {

				ResortOfferResponseDTO response = new ResortOfferResponseDTO();

				response.setPkgCode(offer.getPkgCode());
				response.setDiscount(offer.getDiscount());
				response.setLengthOfStay(request.getLengthOfStay());

				Optional<Supplier> sup = supplierRepository.findById(price.getPriceCompositID().getResortCode());
				if (sup.isPresent()) {
					Supplier sp = sup.get();
					response.setResortName(sp.getSupplierName());
				}
				Optional<RoomType> room = roomTypeRepository.findById(price.getPriceCompositID().getRoomCode());

				if (room.isPresent()) {
					RoomType rt = room.get();
					response.setRoomType(rt.getRoomType());
				}

				float totalPrice = price.getAdultPrice() + price.getChildPrice() + price.getInfantPrice();

				logger.info("Resort Code: " + price.getPriceCompositID().getResortCode() + "--> room code: "
						+ price.getPriceCompositID().getRoomCode() + "-->total Price:" + totalPrice);

				if (offer.getDiscount() != null & "" != offer.getDiscount()) {
					int discountPercentage = Integer.parseInt(offer.getDiscount());
					float discountAmout = 0;
					if (discountPercentage > 0)
						discountAmout = totalPrice * Integer.parseInt(offer.getDiscount()) / 100;
					totalPrice = totalPrice - discountAmout;

					logger.info("discountPrice: " + discountAmout);
				}
				if (request.getLengthOfStay() > 1) {

					totalPrice = totalPrice * request.getLengthOfStay();
				}
				response.setTotalPrice(totalPrice);
				offerResults.add(response);
			}
		}
		return offerResults.stream().sorted().collect(Collectors.toList());
	}

}
