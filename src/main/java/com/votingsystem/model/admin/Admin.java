package com.votingsystem.model.admin;

public class Admin {
	private int id;
	private String name;
	private long contact;
	private String address;
	private int age;
	private long adhar;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getAdhar() {
		return adhar;
	}

	public void setAdhar(long adhar) {
		this.adhar = adhar;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", contact=" + contact + ", address=" + address + ", age=" + age
				+ ", adhar=" + adhar + "]";
	}

	public Admin(int id, String name, long contact, String address, int age, long adhar) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.address = address;
		this.age = age;
		this.adhar = adhar;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

}
