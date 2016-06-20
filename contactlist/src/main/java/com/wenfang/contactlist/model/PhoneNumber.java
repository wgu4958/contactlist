package com.wenfang.contactlist.model;

public class PhoneNumber {
	String type;
	String number;
	boolean primary;
	
	public PhoneNumber(String type, String number, boolean primary) {
		this.type = type;
		this.number = number;
		this.primary = primary;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public boolean isPrimary() {
		return primary;
	}
	public void setPrimary(boolean primary) {
		this.primary = primary;
	}
}
