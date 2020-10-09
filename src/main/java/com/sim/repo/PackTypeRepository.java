package com.sim.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sim.entity.PackType;

@Repository
public interface PackTypeRepository extends JpaRepository<PackType, Integer> {

	public PackType findPackTypeBypackTypeId(Integer input);
}
