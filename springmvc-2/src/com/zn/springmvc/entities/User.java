package com.zn.springmvc.entities;


public class User {
	private Integer id;
	private String username;
	private String password;
	
	private String email;
	private String tel;
	private Adress address;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Adress getAddress() {
		return address;
	}
	public void setAddress(Adress address) {
		this.address = address;
	}
	
	

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", tel="
				+ tel + "]";
	}
	
	
	
	public User(String username, String password, String email, String tel) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.tel = tel;
	}
	
	public User(Integer id, String username, String password, String email, String tel) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.tel = tel;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	
}
