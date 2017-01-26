package com.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
public class User {
	@Id
	@GenericGenerator(name = "a", strategy = "increment")
	@GeneratedValue(generator = "a")
	private Integer id;

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	private String loginId;
	private String passwd;
	private String name;
	private String phone;
	private String address;
	private String sex;
	@Column(length = 100000)
	private byte[] img;
	@Type(type = "date")
	private Date birthdate;
	private String email;
	private String age;
	@OneToOne(mappedBy = "user")
	@Cascade(value = CascadeType.ALL)
	private Admin admin;
	@OneToOne(mappedBy = "user")
	@Cascade(value = CascadeType.ALL)
	private Employee emp;
	@OneToMany(mappedBy = "user")
	private List<Order> order;

	public Integer getId() {
		return id;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "userName:" + loginId + " passwd:" + passwd + " name:" + name + " phone:" + phone + " email:" + email
				+ " address:" + address + " age:" + age + " birthdate:" + birthdate + " sex:" + sex;
	}

}
