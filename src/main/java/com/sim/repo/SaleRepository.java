package com.sim.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sim.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, Integer> {

	List<Sale> findAllByLastUpdatedOnBetween(Date start, Date end);

}
