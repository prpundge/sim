package com.sim.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sim.entity.Sale;
import com.sim.repo.SaleRepository;

@RestController
public class SaleController {

	@Autowired
	SaleRepository saleRepo;

	@GetMapping("/getAllSale")
	public List<Sale> getAllSale() {
		return saleRepo.findAll();

	}

	@GetMapping("/getSale")
	public List<Sale> getSale(@RequestParam("from") String from, @RequestParam("to") String to) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

		java.util.Date fromin = formatter.parse(from);
		Date toin =  formatter.parse(to);
		System.out.println("##############" + fromin);
		return saleRepo.findAllByLastUpdatedOnBetween(fromin, toin);

	}

	@PostMapping("/addSale")
	public Sale addSale(@RequestBody Sale saleinput) {
		return saleRepo.save(saleinput);

	}

}
