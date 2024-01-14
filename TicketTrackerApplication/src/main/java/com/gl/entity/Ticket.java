package com.gl.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tickets")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Temporal(TemporalType.DATE)
	private Date dateCreatedOn;

	public Ticket() {

	}

	public Ticket(int id, String title, String description, Date dateCreatedOn) {

		this.id = id;
		this.title = title;
		this.description = description;
		this.dateCreatedOn = dateCreatedOn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateCreatedOn() {
		return dateCreatedOn;
	}

	public void setDateCreatedOn(Date dateCreatedOn) {
		this.dateCreatedOn = dateCreatedOn;
	}

}
