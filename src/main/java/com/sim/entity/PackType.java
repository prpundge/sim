package com.sim.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the pack_type database table.
 * 
 */
@Entity
@Table(name="pack_type")
@NamedQuery(name="PackType.findAll", query="SELECT p FROM PackType p")
public class PackType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pack_type_id")
	private int packTypeId;

	@Column(name="created_on")
	private Timestamp createdOn;

	@Column(name="last_updated_on")
	private Timestamp lastUpdatedOn;

	@Column(name="pack_capacity")
	private int packCapacity;

	@Lob
	@Column(name="pack_type_desc")
	private String packTypeDesc;

	@Column(name="pack_type_name")
	private String packTypeName;

	//bi-directional many-to-one association to PackedStock
	@OneToMany(mappedBy="packType")
	private List<PackedStock> packedStocks;

	public PackType() {
	}

	public int getPackTypeId() {
		return this.packTypeId;
	}

	public void setPackTypeId(int packTypeId) {
		this.packTypeId = packTypeId;
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

	public int getPackCapacity() {
		return this.packCapacity;
	}

	public void setPackCapacity(int packCapacity) {
		this.packCapacity = packCapacity;
	}

	public String getPackTypeDesc() {
		return this.packTypeDesc;
	}

	public void setPackTypeDesc(String packTypeDesc) {
		this.packTypeDesc = packTypeDesc;
	}

	public String getPackTypeName() {
		return this.packTypeName;
	}

	public void setPackTypeName(String packTypeName) {
		this.packTypeName = packTypeName;
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
		packedStock.setPackType(this);

		return packedStock;
	}

	public PackedStock removePackedStock(PackedStock packedStock) {
		getPackedStocks().remove(packedStock);
		packedStock.setPackType(null);

		return packedStock;
	}

}