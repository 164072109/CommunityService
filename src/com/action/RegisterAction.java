package com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.beans.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.FieldExpressionValidator;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.service.EmployeeService;
import com.service.UserService;

@SuppressWarnings("serial")
public class RegisterAction extends ActionSupport {

	private String loginId;
	private String passwd;
	private String passwd2;
	private String name;
	private String sex;
	private int age;
	private String email;
	private String address;
	private String type;
	private String phone;
	private Date birthdate;
	private File pic;

	@Resource
	private UserService userService;
	@Resource
	private EmployeeService employeeService;

	@RequiredStringValidator(message = "用户名不能为空")
	@RegexFieldValidator(regex = "\\w{6,12}", message = "用户名由6到12位字母数字下划线组成")
	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	@RequiredStringValidator(message = "密码不能为空")
	@RegexFieldValidator(regex = "\\w{6,12}", message = "密码由6到12位字母数字下划线组成")
	public String getPasswd() {
		return passwd;
	}

	public File getPic() {
		return pic;
	}

	public void setPic(File pic) {
		this.pic = pic;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@FieldExpressionValidator(expression = "passwd2==passwd", message = "两次密码不一致")
	public String getPasswd2() {
		return passwd2;
	}

	public void setPasswd2(String passwd2) {
		this.passwd2 = passwd2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@IntRangeFieldValidator(max = "120", min = "0", message = "年龄为1到120之间")
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@EmailValidator(message = "邮箱格式不正确")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@RegexFieldValidator(regex = "\\d{8,12}", message = "手机由8到12位数字组成")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String execute() throws Exception {
		if (userService.checkLoginId(loginId) == null) {
			User user = new User();
			user.setLoginId(loginId);
			user.setPasswd(passwd);
			user.setName(name);
			user.setAge(age + "");
			user.setEmail(email);
			user.setPhone(phone);
			user.setAddress(address);
			user.setSex(sex);
			user.setBirthdate(birthdate);
			if (pic != null && pic.exists()) {
				FileInputStream fis = new FileInputStream(pic);
				byte[] b = new byte[fis.available()];
				fis.read(b);
				fis.close();
				user.setImg(b);
			}
			userService.addOrUpdate(user);
		} else {
			this.addFieldError("loginId", "用户已存在");
			return "input";
		}
		return SUCCESS;
	}

	@SkipValidation
	public String submitEdit() {
		int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
		User user = userService.getById(id);
		user.setName(name);
		user.setEmail(email);
		user.setPhone(phone);
		user.setAge(age + "");
		user.setSex(sex);
		user.setBirthdate(birthdate);
		user.setAddress(address);
		userService.addOrUpdate(user);
		System.out.println(user.toString());
		return "submitEdit";
	}

	@SkipValidation
	public String updateInfo() throws IOException {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("currentUser");
		if (pic != null && pic.exists()) {
			FileInputStream fis = new FileInputStream(pic);
			byte[] b = new byte[fis.available()];
			fis.read(b);
			fis.close();
			user.setImg(b);
		}
		user.setName(name);
		user.setSex(sex);
		user.setBirthdate(birthdate);
		user.setAge(age + "");
		user.setPhone(phone);
		user.setEmail(email);
		user.setAddress(address);
		userService.addOrUpdate(user);
		ServletActionContext.getRequest().getSession().setAttribute("currentUser", user);
		return "updateInfo";
	}
}
