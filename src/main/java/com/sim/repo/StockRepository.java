package com.sim.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sim.entity.Stock;

@Repository
public interface StockRepository  extends JpaRepository<Stock, Integer>{

	public Stock findStockBystockId(Integer input);
}
