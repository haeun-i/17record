package com.example.demo.domain;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class User {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(name = "user_logid", nullable = false, unique = true)
	private String userLogid;

	@Column(name = "user_pw", nullable = false, unique = true)
	private String userPw;

	@Column(name = "user_name", nullable = false, unique = true)
	private String userName;

	@Column(name = "user_phone", nullable = false, unique = true)
	private String userPhone;

	@Column(name = "user_address", nullable = false, unique = true)
	private String userAddress;

	@Column(name = "user_role", nullable = false)
	private String userRole;

	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Review> reviews = new ArrayList<>();

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserLogid() {
		return userLogid;
	}

	public void setUserLogid(String userLogid) {
		this.userLogid = userLogid;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	
}