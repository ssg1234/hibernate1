package com.hexa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Chasis {

	@Id
	private int chasisId;
	private String chasisType;
	
	@ManyToOne
	@JoinColumn(name="cid", referencedColumnName="car_id",unique=true)
	private Car car;
	
	
	public int getChasisId() {
		return chasisId;
	}
	public void setChasisId(int chasisId) {
		this.chasisId = chasisId;
	}
	public String getChasisType() {
		return chasisType;
	}
	public void setChasisType(String chasisType) {
		this.chasisType = chasisType;
	}
	
	
	
}
