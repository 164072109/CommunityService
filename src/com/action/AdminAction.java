package com.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.beans.Admin;
import com.beans.Employee;
import com.beans.Order;
import com.beans.Serve;
import com.beans.ServeApply;
import com.beans.ServeInfo;
import com.beans.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.AdminService;
import com.service.EmployeeService;
import com.service.OrderService;
import com.service.ServeApplyService;
import com.service.ServeInfoService;
import com.service.ServeService;
import com.service.UserService;
import com.util.Page;
import com.util.PageUtil;

@SuppressWarnings("serial")
public class AdminAction extends ActionSupport {
	@Resource
	private ServeApplyService serveApplyService;
	@Resource
	private ServeService serveService;
	@Resource
	private ServeInfoService serveInfoService;
	@Resource
	private OrderService orderService;
	@Resource
	private UserService userService;
	@Resource
	private AdminService adminService;
	@Resource
	private EmployeeService employeeService;

	public String serveApply() {
		List<ServeApply> saList = serveApplyService.findAll();
		ServletActionContext.getRequest().setAttribute("saList", saList);
		return "serveApply";
	}

	public String serveApply2() {
		int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
		ServeApply sa = serveApplyService.getById(id);
		int flag = Integer.parseInt(ServletActionContext.getRequest().getParameter("flag"));
		if (flag == 1) {
			ServeInfo serveInfo = new ServeInfo();
			serveInfo.setEmployee(sa.getEmployee());
			serveInfo.setServe(sa.getServe());
			serveInfoService.add(serveInfo);
		}
		serveApplyService.delete(sa);
		return "serveApply2";
	}

	public String delete() {
		int orderId = Integer.parseInt(ServletActionContext.getRequest().getParameter("orderId"));
		orderService.deleteById(orderId);
		return "delete";
	}

	public String deletes() {
		String s[] = ServletActionContext.getRequest().getParameterValues("select");
		if (s != null && s.length != 0) {
			for (int i = 0; i < s.length; i++) {
				orderService.deleteById(Integer.parseInt(s[i]));
			}
		}

		return "deletes";
	}

	public String showUser() {
		int currentPage = 1;
		String sp = ServletActionContext.getRequest().getParameter("cp");
		if (sp != null && !"".equals(sp)) {
			currentPage = Integer.parseInt(sp);
		}
		System.out.println("currentPage=" + currentPage);
		int totalNum = Integer
				.parseInt(userService.findByConditions("select count(*) from User", null, null).get(0).toString());
		int everyPageNum = 10;
		Page page = PageUtil.createPage(currentPage, everyPageNum, totalNum);
		List<User> userList = userService.findByPage(page);
		ServletActionContext.getRequest().setAttribute("userList", userList);
		ServletActionContext.getRequest().setAttribute("page", page);
		return "showUser";
	}

	public String editUser() {
		int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("userId"));
		User user = userService.getById(id);
		ServletActionContext.getRequest().setAttribute("user", user);
		return "editUser";
	}

	public String deleteUser() {
		int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("userId"));
		userService.delete(userService.getById(id));
		return showUser();
	}

	public String changeRole() {
		String role = ServletActionContext.getRequest().getParameter("role");
		int userId = Integer.parseInt(ServletActionContext.getRequest().getParameter("userId"));
		User user = userService.getById(userId);
		if (role.equals("1")) {
			Admin ad = new Admin();
			ad.setUser(user);
			adminService.add(ad);
		} else if (role.equals("2")) {
			Employee emp = new Employee();
			emp.setUser(user);
			employeeService.addOrUpdate(emp);
		} else {
			if (user.getAdmin() != null) {
				Admin ad = user.getAdmin();
				user.setAdmin(null);
				adminService.delete(ad);
			}
			if (user.getEmp() != null) {
				Employee emp = user.getEmp();
				user.setEmp(null);
				employeeService.delete(emp);
			}
		}
		return showUser();
	}

	public String showServe() {
		List<Serve> serveList = serveService.findAll();
		ServletActionContext.getRequest().setAttribute("serveList", serveList);
		return "showServe";
	}

	public String deleteServe() {
		int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("serveId"));
		serveService.deleteById(id);
		return showServe();
	}

	public String editServe() {
		Serve serve = serveService.getById(Integer.parseInt(ServletActionContext.getRequest().getParameter("serveId")));
		ServletActionContext.getRequest().setAttribute("serve", serve);
		return "editServe";
	}

	public String submitEdit() {
		int serveId = Integer.parseInt(ServletActionContext.getRequest().getParameter("serveId"));
		String name = ServletActionContext.getRequest().getParameter("sname");
		String description = ServletActionContext.getRequest().getParameter("des");
		Serve serve = serveService.getById(serveId);
		serve.setName(name);
		serve.setDescription(description);
		serveService.addOrUpdate(serve);
		return "submitEdit";
	}

	public String addServe() {
		String name = ServletActionContext.getRequest().getParameter("sname");
		String description = ServletActionContext.getRequest().getParameter("des");
		Serve serve = new Serve();
		serve.setName(name);
		serve.setDescription(description);
		serveService.addOrUpdate(serve);
		return "submitEdit";
	}

	public String showOrder() {
		int currentPage = 1;
		String sp = ServletActionContext.getRequest().getParameter("cp");
		if (sp != null && !"".equals(sp)) {
			currentPage = Integer.parseInt(sp);
		}
		String hql = "select count(*) from Order";
		int totalNum = Integer.parseInt(orderService.findByConditions(hql, null, null).get(0).toString());
		int everyPageNum = 10;
		Page page = PageUtil.createPage(currentPage, everyPageNum, totalNum);
		@SuppressWarnings("unchecked")
		List<Order> orderList = orderService.findByConditions("from User", null, page);
		ServletActionContext.getRequest().setAttribute("page", page);
		ServletActionContext.getRequest().setAttribute("orderList", orderList);
		return "showOrder";
	}

}
