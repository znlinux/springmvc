package com.zn.springmvc.entities;

public class Adress {
	private String province;
	private String city;
	
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Adress [province=" + province + ", city=" + city + "]";
	}

	
}
