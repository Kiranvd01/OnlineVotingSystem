package com.votingsystem.model.result;

public class Result {
	private int id;
	private String name;
	private int vote;
	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Result(int id, String name, int vote) {
		super();
		this.id = id;
		this.name = name;
		this.vote = vote;
	}
	@Override
	public String toString() {
		return "Result [id=" + id + ", name=" + name + ", vote=" + vote + "]";
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
	public int getVote() {
		return vote;
	}
	public void setVote(int vote) {
		this.vote = vote;
	}
}
