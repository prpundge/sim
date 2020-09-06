package com.sim.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the sale database table.
 * 
 */
@Entity
@NamedQuery(name = "Sale.findAll", query = "SELECT s FROM Sale s")
public class Sale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sale_id")
	private int saleId;

	@Column(name = "created_on",insertable=false)
	private Date createdOn;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "last_updated_on",insertable=false)
	private Date lastUpdatedOn;

	private int price;

	private int quanity;

	// bi-directional many-to-one association to PackedStock
	@ManyToOne
	@JoinColumn(name = "packed_stock_id")
	private PackedStock packedStock;

	public Sale() {
	}

	public int getSaleId() {
		return this.saleId;
	}

	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getLastUpdatedOn() {
		return this.lastUpdatedOn;
	}

	public void setLastUpdatedOn(Date lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuanity() {
		return this.quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

	public PackedStock getPackedStock() {
		return this.packedStock;
	}

	public void setPackedStock(PackedStock packedStock) {
		this.packedStock = packedStock;
	}

}