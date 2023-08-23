package com.skcet.day6.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class gardenmodel {

	@Id
	private int plantid;
	private String plantname;
	private String planttype;
	private int price;
	private int rating;
	
	public int getPlantid() {
		return plantid;
	}
	public void setPlantid(int plantid) {
		this.plantid = plantid;
	}
	public String getPlantname() {
		return plantname;
	}
	public void setPlantname(String plantname) {
		this.plantname = plantname;
	}
	public String getPlanttype() {
		return planttype;
	}
	public void setPlanttype(String planttype) {
		this.planttype = planttype;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
}
