package com.carInfo.carShowroom.Entity;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "role")
@IdClass(RoleId.class)
public class Role {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Member member;

    @Id
    @Column(name = "role")
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


}

