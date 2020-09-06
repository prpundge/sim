package com.sim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sim.entity.Stock;
import com.sim.repo.StockRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class StockController {

	@Autowired
	StockRepository StockRepo;

	@PostMapping("/addStock")
	public Stock addStock(@RequestBody Stock input) {

		return StockRepo.save(input);

	}
	
	@GetMapping("/getStock")
	public List<Stock> getStock() {

		return StockRepo.findAll();

	}

}
