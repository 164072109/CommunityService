package com.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "serveInfo")
public class ServeInfo {
	@Id
	@GenericGenerator(name = "a", strategy = "increment")
	@GeneratedValue(generator = "a")
	private int id;
	@OneToOne(fetch = FetchType.LAZY)
	private Employee employee;
	@ManyToOne(fetch = FetchType.LAZY)
	private Serve serve;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Serve getServe() {
		return serve;
	}
	public void setServe(Serve serve) {
		this.serve = serve;
	}


}
