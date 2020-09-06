package com.sim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sim.entity.PackedStock;
import com.sim.repo.PackedStockRepository;

@RestController
public class PackStockController {

	@Autowired
	PackedStockRepository PackedStockRepo;

	@GetMapping("/getPackStock")
	public List<PackedStock> getPackedStock() {
		return PackedStockRepo.findAll();

	}

	@PostMapping("/addPackStock")
	public PackedStock getPackedStock(@RequestBody PackedStock packedStock) {
		System.out.println("################" + packedStock.toString());
		return PackedStockRepo.save(packedStock);

	}
}
