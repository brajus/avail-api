package com.rbs.avail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rbs.avail.dto.ResortOfferRequestDTO;
import com.rbs.avail.dto.ResortOfferResponseDTO;
import com.rbs.avail.service.OfferService;

@RestController
@RequestMapping("/avail-api")
public class ResortOfferController {
	
	@Autowired
	private OfferService offerService;

	@PostMapping("/wide-search")
	public ResponseEntity<List<ResortOfferResponseDTO>>	getOffers(@RequestBody ResortOfferRequestDTO requestDTO){
		List<ResortOfferResponseDTO> response = offerService.getAllOffers(requestDTO);
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("/pkgcode")
	public ResponseEntity<List<ResortOfferResponseDTO>>	getOffersByPkgCode(@RequestBody ResortOfferRequestDTO requestDTO){
		List<ResortOfferResponseDTO> response = offerService.getOffersByPkgCode(requestDTO);
		return ResponseEntity.ok().body(response);
	}

}
