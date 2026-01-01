package com.rbs.avail.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rbs.avail.model.Occupancy;

@Repository
public interface OccupancyRepository extends JpaRepository<Occupancy, String>{
	
	@Cacheable(cacheNames="roomOccupancies")
	List<Occupancy> findAll();
}
