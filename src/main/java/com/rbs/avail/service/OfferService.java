package com.rbs.avail.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rbs.avail.dto.ResortOfferRequestDTO;
import com.rbs.avail.dto.ResortOfferResponseDTO;
import com.rbs.avail.helper.AvailServiceHelper;
import com.rbs.avail.model.Offer;
import com.rbs.avail.repository.OfferRepository;

@Service
public class OfferService {

	@Autowired
	private OfferRepository offerRepository;
	
	@Autowired
	private AvailServiceHelper availServiceHelper;

	public List<ResortOfferResponseDTO> getAllOffers(ResortOfferRequestDTO request) {
		List<Offer> packages = offerRepository.getOffers(request.getArrivalDate(), request.getDepartureDate());
		return availServiceHelper.getValidOffers(packages, request);
	}

	public List<ResortOfferResponseDTO> getOffersByPkgCode(ResortOfferRequestDTO request) {
		Optional<Offer> pkg = offerRepository.findById(request.getPkgCode());
		List<Offer> packages = new ArrayList<Offer>();
		if (pkg.isPresent()) {
			packages.add(pkg.get());
		}
		return availServiceHelper.getValidOffers(packages, request);
	}
}
