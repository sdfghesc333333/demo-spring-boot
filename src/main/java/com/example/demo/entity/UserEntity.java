package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_USER")
public class UserEntity {
	@Id
	@Column(name = "S_ID")
	private String id;
	
	@Column(name = "S_EMAIL")
	private String email;
	
	@Column(name = "D_CREATE")
	private Date created;
	
	@Column(name = "S_AVATAR")
	private String avatar;
	
	@Column(name = "S_PASSWORD")
	private String password;
	
	@Column(name = "D_UPDATE")
	private Date updated;
	
	@Column(name = "S_PHONE")
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

	public UserEntity(String id, String email, Date created, String avatar, String password, Date updated,
			String phone) {
		this.id = id;
		this.email = email;
		this.created = created;
		this.avatar = avatar;
		this.password = password;
		this.updated = updated;
		this.phone = phone;
	}
	
	public UserEntity() {
		
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", email=" + email + ", created=" + created + ", avatar=" + avatar
				+ ", password=" + password + ", updated=" + updated + ", phone=" + phone + ", getId()=" + getId()
				+ ", getEmail()=" + getEmail() + ", getCreated()=" + getCreated() + ", getAvatar()=" + getAvatar()
				+ ", getPassword()=" + getPassword() + ", getUpdated()=" + getUpdated() + ", getPhone()=" + getPhone()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
