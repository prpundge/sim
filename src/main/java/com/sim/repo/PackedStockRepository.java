package com.sim.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sim.entity.PackedStock;

@Repository
public interface PackedStockRepository extends JpaRepository<PackedStock, Integer> {

}
