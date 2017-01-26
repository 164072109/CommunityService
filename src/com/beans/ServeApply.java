package com.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class ServeApply {
	@Id
	@GenericGenerator(name = "a", strategy = "increment")
	@GeneratedValue(generator = "a")
	private int id;
	@ManyToOne(fetch = FetchType.LAZY)
	private Serve serve;
	@ManyToOne(fetch = FetchType.LAZY)
	private Employee employee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Serve getServe() {
		return serve;
	}

	public void setServe(Serve serve) {
		this.serve = serve;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
