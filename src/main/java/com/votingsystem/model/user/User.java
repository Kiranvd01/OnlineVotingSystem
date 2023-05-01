package com.votingsystem.model.user;

public class User {
	private int id;
	private String name;
	private String address;
	private long contact;
	private int age;
	private long adharNo;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, String address, long contact, int age, long adharNo) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.age = age;
		this.adharNo = adharNo;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + ", contact=" + contact + ", age=" + age
				+ ", adharNo=" + adharNo + "]";
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(long adharNo) {
		this.adharNo = adharNo;
	}
}
