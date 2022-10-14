package com.vanessa.DojosNinjas.Models;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

//Start
@Entity
@Table(name = "dojo")
public class DojoModel {
	public static DojoModel newdojo;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 1, message="Must have a name")
	private String name;
	
//	Relationships
	@OneToMany(mappedBy = "Dojo", fetch = FetchType.LAZY)
	private List<NinjaModel> Ninja;
	
	// This will not allow the createdAt column to be updated after creation
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
//	constructor
	
	public DojoModel() {
		
	}
	
	public DojoModel(String name) {
		this.name = name;
	}
	
	
	// other getters and setters removed for brevity
		@PrePersist
		protected void onCreate() {
			this.createdAt = new Date();
		}

		@PreUpdate
		protected void onUpdate() {
			this.updatedAt = new Date();
		}
// Getter and Setters
		public static DojoModel getNewdojo() {
			return newdojo;
		}

		public static void setNewdojo(DojoModel newdojo) {
			DojoModel.newdojo = newdojo;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
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

		public List<NinjaModel> getNinja() {
			return Ninja;
		}

		public void setNinja(List<NinjaModel> ninja) {
			Ninja = ninja;
		}
		
		
}
