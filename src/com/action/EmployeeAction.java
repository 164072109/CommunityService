package com.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.beans.EmpInfo;
import com.beans.Employee;
import com.beans.Order;
import com.beans.Serve;
import com.beans.ServeApply;
import com.beans.ServeInfo;
import com.beans.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.EmployeeService;
import com.service.OrderService;
import com.service.ServeApplyService;
import com.service.ServeService;
import com.service.UserService;

@SuppressWarnings("serial")
public class EmployeeAction extends ActionSupport {
	@Resource
	private ServeService serveService;
	@Resource
	private EmployeeService employeeService;
	@Resource
	private ServeApplyService serveApplyService;
	@Resource
	private OrderService orderService;
	@Resource
	private UserService userService;

	public String serveApply() {
		List<Serve> serveList = serveService.findAll();
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("currentUser");
		user = userService.checkUser(user);
		Employee emp = user.getEmp();
		List<ServeInfo> serveInfoList = emp.getServeInfo();
		for (ServeInfo serveInfo : serveInfoList) {
			serveList.remove(serveInfo.getServe());
		}
		List<ServeApply> saList = emp.getServeApplyList();
		for (ServeApply serveApply : saList) {
			serveList.remove(serveApply.getServe());
		}
		ServletActionContext.getRequest().setAttribute("serveList", serveList);
		return "serveApply";
	}

	public String serveApply2() {
		ServeApply sa = new ServeApply();
		int serveId = Integer.parseInt(ServletActionContext.getRequest().getParameter("serveId"));
		sa.setServe(serveService.getById(serveId));
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("currentUser");
		Employee emp = user.getEmp();
		sa.setEmployee(emp);
		serveApplyService.add(sa);
		return "serveApply2";
	}

	public String showComment() {
		int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
		Order order = orderService.getById(id);
		ServletActionContext.getRequest().setAttribute("order", order);
		ServletActionContext.getRequest().setAttribute("flag", 2);
		return "showComment";
	}

	public String showInfo() {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("currentUser");
		Employee emp = user.getEmp();
		System.out.println(emp.getEmpInfo() == null);
		return "showInfo";
	}

	public String submitPinfo() {
		String str1 = ServletActionContext.getRequest().getParameter("str1");
		String str2 = ServletActionContext.getRequest().getParameter("str2");
		String str3 = ServletActionContext.getRequest().getParameter("str3");
		EmpInfo ei;
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("currentUser");
		Employee emp = user.getEmp();
		if (emp.getEmpInfo() != null) {
			ei = emp.getEmpInfo();
		} else {
			ei = new EmpInfo();
			ei.setEmployee(emp);
		}
		ei.setStr1(str1);
		ei.setStr2(str2);
		ei.setStr3(str3);
		emp.setEmpInfo(ei);
		employeeService.addOrUpdate(emp);
		return "submitPinfo";
	}
}
