package com.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;

import org.apache.struts2.ServletActionContext;

import com.beans.Comment;
import com.beans.Employee;
import com.beans.Order;
import com.beans.Serve;
import com.beans.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.CommentService;
import com.service.EmployeeService;
import com.service.OrderService;
import com.service.ServeService;
import com.service.UserService;
import com.util.Page;
import com.util.PageUtil;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport {
	private String userName;
	private String password;
	@Resource
	private UserService userService;
	@Resource
	private EmployeeService employeeService;
	private String type;
	@Resource
	private ServeService serveService;
	@Resource
	private OrderService orderService;
	@Resource
	private CommentService commentService;
	private int flag;
	private int orderId;

	public String getType() {
		return type;
	}

	public int getFlag() {
		return flag;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String checkUser() {
		String hql = "from User where loginId=? and passwd=?";
		String[] param = { userName, password };
		List userList = userService.findByConditions(hql, param, null);
		User user = null;
		if (!userList.isEmpty()) {
			user = (User) userList.get(0);
		}
		if (type.equals("1") || type.equals("")) {
			if (user != null) {
				ServletActionContext.getRequest().getSession().setAttribute("currentUser", user);
				List<Serve> serve = serveService.findAll();
				ServletActionContext.getRequest().getSession().setAttribute("serve", serve);
				return "success1";
			} else
				return "login";
		} else if (type.equals("2")) {
			if (user != null && user.getEmp() != null) {
				ServletActionContext.getRequest().getSession().setAttribute("currentUser", user);
				return "success2";
			} else
				return "login";
		} else {
			if (user != null && user.getAdmin() != null) {
				ServletActionContext.getRequest().getSession().setAttribute("currentUser", user);
				return "success3";
			}
			return "login";
		}

	}

	// 用户进入预约界面
	public String yuyue() {
		int serveId = Integer.parseInt(ServletActionContext.getRequest().getParameter("serveId"));
		System.out.println(ServletActionContext.getRequest().getParameter("empId"));
		int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("empId"));
		System.out.println(id);
		Employee emp = employeeService.getById(id);
		ServletActionContext.getRequest().setAttribute("emp", emp);
		ServletActionContext.getRequest().setAttribute("serve", serveService.getById(serveId));
		return "yuyue";
	}

	public void showImg() throws IOException {
		int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
		byte pic[] = userService.getById(id).getImg();
		ServletOutputStream out = ServletActionContext.getResponse().getOutputStream();
		if (pic != null) {
			out.write(pic);
		}
		out.flush();
		out.close();
	}

	// 用户查看历史订单
	public String showOrder1() {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("currentUser");
		int currentPage = 1;
		String s = ServletActionContext.getRequest().getParameter("currentPage");
		if (s != null && !"".equals(s)) {
			float d = Float.parseFloat(s);
			currentPage = Math.round(d);
		}
		int everyPageNum = 10;
		String hql = "select count(*) from Order where user.id=? and state<>? ";
		String[] param = { user.getId() + "", "待接受" };
		int totalNum = Integer.parseInt(orderService.findByConditions(hql, param, null).get(0).toString());
		Page page = PageUtil.createPage(currentPage, everyPageNum, totalNum);
		if (currentPage > page.getTotalPage()) {
			page.setCurrentPage(page.getTotalPage());
		}
		hql = "from Order where user.id=? and state<>?";
		@SuppressWarnings("unchecked")
		List<Order> orderList = orderService.findByConditions(hql, param, page);
		ServletActionContext.getRequest().setAttribute("orderList", orderList);
		flag = 1;
		ServletActionContext.getRequest().setAttribute("flag", flag);
		ServletActionContext.getRequest().setAttribute("page", page);
		return "showOrder";
	}

	public String showOrder2() {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("currentUser");
		String hql = "from Order where user.id=? and state=?";
		String[] param = { user.getId() + "", "待接受" };
		@SuppressWarnings("unchecked")
		List<Order> orderList = orderService.findByConditions(hql, param, null);
		flag = 2;
		ServletActionContext.getRequest().setAttribute("orderList", orderList);
		ServletActionContext.getRequest().setAttribute("flag", flag);
		return "showOrder";
	}

	public String deleteOrder() {
		System.out.println("==========orderId: " + orderId);
		orderService.deleteById(orderId);
		return "deleteOrder";
	}

	public String editOrder() {
		ServletActionContext.getRequest().setAttribute("order", orderService.getById(orderId));
		return "editOrder";
	}

	public String submitEdit() {
		Order order = orderService.getById(orderId);
		order.setMessage(ServletActionContext.getRequest().getParameter("message"));
		orderService.addOrUpdate(order);
		return "submitEdit";
	}

	public String comment() {
		ServletActionContext.getRequest().setAttribute("order", orderService.getById(orderId));
		return "comment";
	}

	public String comment2() {
		String message = ServletActionContext.getRequest().getParameter("message");
		Order order = orderService.getById(orderId);
		Comment c;
		if (order.getComment() == null) {
			c = new Comment();
			c.setComments(message);
			c.setOrder(order);
		} else {
			c = order.getComment();
			c.setComments(message);
		}
		commentService.saveOrUpdate(c);
		return "comment2";
	}

	public String showInfo() {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("currentUser");
		user = userService.getById(user.getId());
		ServletActionContext.getRequest().getSession().setAttribute("currentUser", user);
		System.out.println(user.toString());
		return "showInfo";
	}

	public String logout() {
		ServletActionContext.getRequest().getSession().invalidate();
		System.out.println("========退出登录============");
		return "logout";
	}
}
