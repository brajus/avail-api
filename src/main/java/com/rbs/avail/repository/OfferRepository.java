package com.rbs.avail.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rbs.avail.model.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, String> {
	
	@Query( "SELECT p FROM Offer p WHERE p.saleStartDate <= :arrivalDate AND  p.saleEndDate >= :departureDate ORDER BY p.discount ASC")
	List<Offer> getOffers(@Param ("arrivalDate") Date arrivalDate, @Param ("departureDate") Date departureDate);
	//
	
//	@Query(
//			  value = "SELECT * FROM USERS u WHERE u.status = 1", 
//			  nativeQuery = true)
//	
//	@Query(value = "SELECT * FROM PACKAGE p WHERE  p.saleStartDate <= ?1 and p.saleEndDate >= ?2 ", nativeQuery = true)
//	List<Offer> getOffers( Date arrivalDate,  Date departureDate);
	//pkgCode pkgNAME saleStartDate saleEndDate discount
}
