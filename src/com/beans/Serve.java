package com.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "serve")
public class Serve {
	@Id
	@GenericGenerator(name = "a", strategy = "increment")
	@GeneratedValue(generator = "a")
	private int id;
	private String name;
	private String description;
	@OneToMany(mappedBy = "serve")
	@Cascade(value = CascadeType.ALL)
	private List<ServeInfo> serveInfo;
	@OneToMany(mappedBy = "serve")
	@Cascade(value = CascadeType.ALL)
	private List<Order> orderList;
	@OneToMany(mappedBy = "serve")
	private List<ServeApply> serveApplyList;

	public List<ServeApply> getServeApplyList() {
		return serveApplyList;
	}

	public void setServeApplyList(List<ServeApply> serveApplyList) {
		this.serveApplyList = serveApplyList;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public List<ServeInfo> getServeInfo() {
		return serveInfo;
	}

	public void setServeInfo(List<ServeInfo> serveInfo) {
		this.serveInfo = serveInfo;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
