package com.votingsystem.model.candidate;

public class Candidate {
	private int id;
	private String name;
	private String address;
	private int age;
	private long contact;
	private long adharNo;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public long getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(long adharNo) {
		this.adharNo = adharNo;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", address=" + address + ", age=" + age + ", contact="
				+ contact + ", adharNo=" + adharNo + "]";
	}

	public Candidate(int id, String name, String address, int age, long contact, long adharNo) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.age = age;
		this.contact = contact;
		this.adharNo = adharNo;
	}

	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}

}
