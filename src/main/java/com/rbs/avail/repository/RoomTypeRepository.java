package com.rbs.avail.repository;

import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rbs.avail.model.RoomType;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, String>{
	
	@Cacheable(cacheNames="roomTypes")
	Optional<RoomType> findById(String roomCode);
}
