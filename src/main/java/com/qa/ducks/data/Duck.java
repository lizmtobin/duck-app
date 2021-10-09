package com.qa.ducks.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Duck {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private String colour;

	public Duck() {
		super();
	}

	public Duck(Integer id, String name, String colour) {
		super();
		this.id = id;
		this.name = name;
		this.colour = colour;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return "Duck [id=" + id + ", name=" + name + ", colour=" + colour + "]";
	}

}
