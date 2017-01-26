package com.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Employee {
	@Id
	@GenericGenerator(name = "a", strategy = "increment")
	@GeneratedValue(generator = "a")
	private Integer id;
	@OneToMany(mappedBy = "employee")
	@Cascade(value = CascadeType.ALL)
	private List<ServeInfo> serveInfo;

	@OneToMany(mappedBy = "employee")
	private List<Order> order;
	@OneToMany(mappedBy = "employee")
	private List<ServeApply> serveApplyList;
	@OneToOne
	private User user;
	@OneToOne(mappedBy = "employee")
	@Cascade(value = CascadeType.ALL)
	private EmpInfo empInfo;

	public Employee() {

	}

	public EmpInfo getEmpInfo() {
		return empInfo;
	}

	public void setEmpInfo(EmpInfo empInfo) {
		this.empInfo = empInfo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public List<ServeApply> getServeApplyList() {
		return serveApplyList;
	}

	public void setServeApplyList(List<ServeApply> serveApplyList) {
		this.serveApplyList = serveApplyList;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<ServeInfo> getServeInfo() {
		return serveInfo;
	}

	public void setServeInfo(List<ServeInfo> serveInfo) {
		this.serveInfo = serveInfo;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

}
