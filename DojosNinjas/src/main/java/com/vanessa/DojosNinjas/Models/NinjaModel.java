package com.vanessa.DojosNinjas.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

//Start
@Entity
@Table(name = "ninja")
public class NinjaModel {

	public static NinjaModel newNinja;

	// MY SQL Table Stuffs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 1, message = "Must have a First Name")
	private String firstName;
	@NotNull
	@Size(min = 1, message = "Must have a Last Name")
	private String lastName;
	@NotNull
	@Positive(message = "Age must be above 0")
	private Integer age;
	
//	Relationships
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="dojo_id") 
	private DojoModel Dojo;

	// This will not allow the createdAt column to be updated after creation
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
//	Constructors
	public NinjaModel() {
	}

	public NinjaModel(String firstName, String lastName, Integer age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	// other getters and setters removed for brevity
//	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
//	Getters and Setters

	public static NinjaModel getNewNinja() {
		return newNinja;
	}

	public static void setNewNinja(NinjaModel newNinja) {
		NinjaModel.newNinja = newNinja;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public DojoModel getDojo() {
		return Dojo;
	}

	public void setDojo(DojoModel dojo) {
		Dojo = dojo;
	}
}
