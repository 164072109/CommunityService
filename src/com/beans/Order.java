package com.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "order_")
public class Order {
	@Id
	@GenericGenerator(name = "a", strategy = "increment")
	@GeneratedValue(generator = "a")
	private Integer id;
	@ManyToOne(fetch = FetchType.LAZY)
	private Employee employee;
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	private String state;
	private String message;
	@ManyToOne(fetch = FetchType.LAZY)
	private Serve serve;
	@OneToOne(mappedBy = "order")
	@Cascade(value = CascadeType.ALL)
	private Comment comment;

	private Date startTime;
	private Date finishTime;

	public Comment getComment() {
		return comment;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public String getMessage() {
		return message;
	}

	public Serve getServe() {
		return serve;
	}

	public void setServe(Serve serve) {
		this.serve = serve;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
