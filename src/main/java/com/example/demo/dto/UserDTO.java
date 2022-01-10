package com.example.demo.dto;

import java.util.Date;

import javax.persistence.Column;

public class UserDTO {
	private String id;
	private String email;
	private Date created;
	private String avatar;
	private String password;
	private Date updated;
	private String phone;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", email=" + email + ", created=" + created + ", avatar=" + avatar + ", password="
				+ password + ", updated=" + updated + ", phone=" + phone + "]";
	}
	public UserDTO(String id, String email, Date created, String avatar, String password, Date updated, String phone) {
		this.id = id;
		this.email = email;
		this.created = created;
		this.avatar = avatar;
		this.password = password;
		this.updated = updated;
		this.phone = phone;
	}
	
	
}
