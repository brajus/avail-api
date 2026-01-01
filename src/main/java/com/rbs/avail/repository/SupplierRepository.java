package com.rbs.avail.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rbs.avail.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, String> {

	@Cacheable(cacheNames="suppliers")
	Optional<Supplier> findById(String supplierCode);
	
	@Cacheable(cacheNames="suppliers")
	List<Supplier> findAll();
}
