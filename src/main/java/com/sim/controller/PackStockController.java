package com.sim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sim.entity.PackType;
import com.sim.entity.PackedStock;
import com.sim.entity.Stock;
import com.sim.repo.PackTypeRepository;
import com.sim.repo.PackedStockRepository;
import com.sim.repo.StockRepository;

@RestController
public class PackStockController {

	@Autowired
	PackedStockRepository PackedStockRepo;

	@Autowired
	StockRepository stockRepo;

	@Autowired
	PackTypeRepository packTypeRepo;

	@GetMapping("/getPackStock")
	public List<PackedStock> getPackedStock() {
		return PackedStockRepo.findAll();

	}

	@PostMapping("/addPackStock")
	public PackedStock getPackedStock(@RequestBody PackedStock packedStock) {
		System.out.println("################" + packedStock.toString());
		Stock stock = stockRepo.findStockBystockId(packedStock.getStock().getStockId());
		PackType packtype = packTypeRepo.findPackTypeBypackTypeId(packedStock.getPackType().getPackTypeId());
		Integer packedoil = packtype.getPackCapacity() * packedStock.getPackedQuantity();
		stock.setStockQuantityKg(stock.getStockQuantityKg() - packedoil);
		stock.setStockQuantityLitre(stock.getStockQuantityKg() - packedoil);
		packedStock.setStock(stock);
		stockRepo.save(stock);
		return PackedStockRepo.save(packedStock);

	}
}
