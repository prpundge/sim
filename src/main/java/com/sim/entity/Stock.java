package com.sim.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the stock database table.
 * 
 */
@Entity
@NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s")
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stock_id")
	private int stockId;

	@Column(name = "created_on" ,insertable=false)
	private Date createdOn;

	@Column(name = "last_updated_on" ,insertable=false)
	private Date lastUpdatedOn;

	@Column(name = "stock_in_date")
	private Date stockInDate;

	@Column(name = "stock_price")
	private int stockPrice;

	@Column(name = "stock_quantity_kg")
	private int stockQuantityKg;

	@Column(name = "stock_quantity_litre")
	private int stockQuantityLitre;

	// bi-directional many-to-one association to PackedStock
	@OneToMany(mappedBy = "stock")
	private List<PackedStock> packedStocks;

	// bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	public Stock() {
	}

	public int getStockId() {
		return this.stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getLastUpdatedOn() {
		return this.lastUpdatedOn;
	}

	public void setLastUpdatedOn(Date lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	public Date getStockInDate() {
		return this.stockInDate;
	}

	public void setStockInDate(Date stockInDate) {
		this.stockInDate = stockInDate;
	}

	public int getStockPrice() {
		return this.stockPrice;
	}

	public void setStockPrice(int stockPrice) {
		this.stockPrice = stockPrice;
	}

	public int getStockQuantityKg() {
		return this.stockQuantityKg;
	}

	public void setStockQuantityKg(int stockQuantityKg) {
		this.stockQuantityKg = stockQuantityKg;
	}

	public int getStockQuantityLitre() {
		return this.stockQuantityLitre;
	}

	public void setStockQuantityLitre(int stockQuantityLitre) {
		this.stockQuantityLitre = stockQuantityLitre;
	}

	@JsonIgnore
	public List<PackedStock> getPackedStocks() {
		return this.packedStocks;
	}

	public void setPackedStocks(List<PackedStock> packedStocks) {
		this.packedStocks = packedStocks;
	}

	public PackedStock addPackedStock(PackedStock packedStock) {
		getPackedStocks().add(packedStock);
		packedStock.setStock(this);

		return packedStock;
	}

	public PackedStock removePackedStock(PackedStock packedStock) {
		getPackedStocks().remove(packedStock);
		packedStock.setStock(null);

		return packedStock;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}