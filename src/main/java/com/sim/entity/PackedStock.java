package com.sim.entity;

import java.io.Serializable;
import java.sql.Timestamp;
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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the packed_stock database table.
 * 
 */
@Entity
@Table(name = "packed_stock")
@NamedQuery(name = "PackedStock.findAll", query = "SELECT p FROM PackedStock p")
public class PackedStock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "packed_stock_id")
	private int packedStockId;

	@Column(name = "created_on")
	private Timestamp createdOn;

	@Column(name = "last_updated_on")
	private Timestamp lastUpdatedOn;

	@Column(name = "packed_price_per")
	private String packedPricePer;

	@Column(name = "packed_litre")
	private Integer packedLitre;

	@Column(name = "packed_quantity")
	private Integer packedQuantity;

	// bi-directional many-to-one association to PackType
	@ManyToOne
	@JoinColumn(name = "pack_type_id")
	private PackType packType;

	// bi-directional many-to-one association to Stock
	@ManyToOne
	@JoinColumn(name = "stock_id")
	private Stock stock;

	// bi-directional many-to-one association to Sale
	@OneToMany(mappedBy = "packedStock")
	private List<Sale> sales;

	public PackedStock() {
	}

	public int getPackedStockId() {
		return this.packedStockId;
	}

	public void setPackedStockId(int packedStockId) {
		this.packedStockId = packedStockId;
	}

	public Timestamp getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Timestamp getLastUpdatedOn() {
		return this.lastUpdatedOn;
	}

	public void setLastUpdatedOn(Timestamp lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	public String getPackedPricePer() {
		return this.packedPricePer;
	}

	public void setPackedPricePer(String packedPricePer) {
		this.packedPricePer = packedPricePer;
	}

	public Integer getPackedLitre() {
		return packedLitre;
	}

	public void setPackedLitre(Integer packedLitre) {
		this.packedLitre = packedLitre;
	}

	public Integer getPackedQuantity() {
		return packedQuantity;
	}

	public void setPackedQuantity(Integer packedQuantity) {
		this.packedQuantity = packedQuantity;
	}

	public PackType getPackType() {
		return this.packType;
	}

	public void setPackType(PackType packType) {
		this.packType = packType;
	}

	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	@JsonIgnore
	public List<Sale> getSales() {
		return this.sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

	public Sale addSale(Sale sale) {
		getSales().add(sale);
		sale.setPackedStock(this);

		return sale;
	}

	public Sale removeSale(Sale sale) {
		getSales().remove(sale);
		sale.setPackedStock(null);

		return sale;
	}

}