package com.krry.entity;

public class User {
	
	private int id;
	private String name;
	private String password;
	private String originWord;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOriginWord() {
		return originWord;
	}
	public void setOriginWord(String originWord) {
		this.originWord = originWord;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password
				+ ", originWord=" + originWord + "]";
	}
	
}
