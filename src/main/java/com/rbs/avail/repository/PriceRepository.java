package com.rbs.avail.repository;



import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rbs.avail.model.PaxPrice;
import com.rbs.avail.model.PriceCompositID;

@Repository
public interface PriceRepository extends JpaRepository<PaxPrice, PriceCompositID> {
	
	@Cacheable(cacheNames="paxPrices")
	List<PaxPrice> findAll();
}
