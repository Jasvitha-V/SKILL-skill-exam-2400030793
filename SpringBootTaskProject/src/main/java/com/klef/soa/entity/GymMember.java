package com.klef.soa.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "gymmember_table")
public class GymMember
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gid")
	private Long gymMemberId;
	@Column(name = "gname", length = 100, nullable = false)
	private String name;
	@Column(name = "gtype", length = 50, nullable = false)
	private String type;
	@Column(name = "gstatus", nullable = false)
	private boolean status;
	@Column(name = "glocation", length = 100, nullable = false)
	private String location;
	@CreationTimestamp
	private LocalDateTime createdAt;
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	public Long getGymMemberId() {
		return gymMemberId;
	}

	public void setGymMemberId(Long gymMemberId) {
		this.gymMemberId = gymMemberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "GymMember [gymMemberId=" + gymMemberId + ", name=" + name + ", type=" + type + ", status=" + status
				+ ", location=" + location + "]";
	}
}