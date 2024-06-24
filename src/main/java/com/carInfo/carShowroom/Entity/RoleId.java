package com.carInfo.carShowroom.Entity;

import java.io.Serializable;

public class RoleId implements Serializable {

	public RoleId() {
		super();
	}
	private Member member;
    private String role;
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

    // Default constructor, getters, setters, equals, and hashCode methods
}