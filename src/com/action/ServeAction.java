package com.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.beans.Employee;
import com.beans.Order;
import com.beans.Serve;
import com.beans.ServeInfo;
import com.beans.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.EmployeeService;
import com.service.OrderService;
import com.service.ServeService;
import com.service.UserService;
import com.util.Page;
import com.util.PageUtil;

@SuppressWarnings("serial")
public class ServeAction extends ActionSupport {
	private String message;
	@Resource
	private EmployeeService employeeService;
	@Resource
	private OrderService orderService;
	@Resource
	private ServeService serveService;
	@Resource
	private UserService userService;
	private int serveId;

	public String getMessage() {
		return message;
	}

	public int getServeId() {
		return serveId;
	}

	public void setServeId(int serveId) {
		this.serveId = serveId;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	// �û��鿴ĳһ����������Ա��
	public String showInfo() {
		System.out.println("����showInfo����");
		int serveId = Integer.parseInt(ServletActionContext.getRequest().getParameter("serveId"));
		Serve serve = serveService.getById(serveId);
		List<Employee> empList = new ArrayList<Employee>();
		List<ServeInfo> serveInfo = serve.getServeInfo();
		for (int i = 0; i < serveInfo.size(); i++) {
			Employee emp = serveInfo.get(i).getEmployee();
			System.out.println(emp.getId());
			empList.add(emp);
		}
		ServletActionContext.getRequest().setAttribute("serveId", serveId);
		ServletActionContext.getRequest().setAttribute("empList", empList);
		return "showInfo";
	}

	// �û��ύԤԼ
	public String order() {
		System.out.println("����order����");
		Order order = new Order();
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("currentUser");
		int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
		int serveId = Integer.parseInt(ServletActionContext.getRequest().getParameter("serveId"));
		Employee emp = employeeService.getById(id);
		order.setState("������");
		order.setEmployee(emp);
		order.setUser(user);
		order.setMessage(message);
		order.setStartTime(new Date());
		System.out.println(message + "liuyan");
		order.setServe(serveService.getById(serveId));
		if (orderService.checkOrder(order)) {
			ServletActionContext.getRequest().setAttribute("flag", false);
		} else {
			orderService.addOrUpdate(order);
			ServletActionContext.getRequest().setAttribute("flag", true);
		}
		return "ordered";
	}

	// Ա���鿴�Լ���ԤԼ
	public String showOrder() {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("currentUser");
		user = userService.checkUser(user);
		Employee emp = user.getEmp();
		List<Order> order = emp.getOrder();
		Iterator<Order> iterator = order.iterator();
		while (iterator.hasNext()) {
			if (!iterator.next().getState().equals("������")) {
				iterator.remove();
			}
		}
		ServletActionContext.getRequest().setAttribute("orderList", order);
		return "showOrder";
	}

	public String showOrder2() {
		int currentPage = 1;
		int everyPageNum = 10;
		String a = ServletActionContext.getRequest().getParameter("currentPage");
		if (a != null && !"".equals(a)) {
			currentPage = Integer.parseInt(a);
			if (currentPage <= 0)
				currentPage = 1;
		}
		String hql = "select count(*) from Order where employee.id=? and state<>?";
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("currentUser");
		user = userService.checkUser(user);
		Employee emp = user.getEmp();
		String[] param = { emp.getId() + "", "������" };
		int totalCount = Integer.parseInt(orderService.findByConditions(hql, param, null).get(0).toString());
		Page page = PageUtil.createPage(currentPage, everyPageNum, totalCount);
		if (currentPage > page.getTotalPage()) {
			currentPage = page.getTotalPage();
			page = PageUtil.createPage(currentPage, everyPageNum, totalCount);
		}
		hql = "from Order where employee.id=? and state<>?";
		@SuppressWarnings("unchecked")
		List<Order> order = orderService.findByConditions(hql, param, page);
		ServletActionContext.getRequest().setAttribute("orderList", order);
		ServletActionContext.getRequest().setAttribute("page", page);
		ServletActionContext.getRequest().setAttribute("flag", 2);
		return "showOrder2";
	}

	// Ա���鿴ĳһ��ԤԼ������
	public String showOrderInfo() {
		int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
		Order order = orderService.getById(id);
		ServletActionContext.getRequest().setAttribute("order", order);
		return "showOrderInfo";
	}

	// Ա���ظ�ԤԼ
	public String replyOrder() {
		int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
		String str = ServletActionContext.getRequest().getParameter("reply");
		Order order = orderService.getById(id);
		order.setState(str);
		order.setFinishTime(new Date());
		orderService.addOrUpdate(order);
		return "replyOrder";
	}
}
