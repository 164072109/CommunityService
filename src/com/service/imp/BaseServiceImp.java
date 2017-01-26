package com.service.imp;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import com.dao.AdminDao;
import com.dao.BaseDao;
import com.dao.EmployeeDao;
import com.dao.OrderDao;
import com.dao.ServeApplyDao;
import com.dao.ServeDao;
import com.dao.UserDAO;
import com.service.BaseService;
import com.util.Page;

@SuppressWarnings("rawtypes")
public class BaseServiceImp<I> implements BaseService<I> {
	private Class<I> I;
	private BaseDao<I> baseDao;
	@Resource
	private AdminDao adminDao;
	@Resource
	private EmployeeDao employeeDao;
	@Resource
	private OrderDao orderDao;
	@Resource
	private ServeApplyDao serveApplyDao;
	@Resource
	private ServeDao serveDao;
	@Resource
	private UserDAO userDao;

	@SuppressWarnings("unchecked")
	public BaseServiceImp() {
		System.out.println("=====BaseServiceImp≥ı ºªØ======");
		Type type = getClass().getGenericSuperclass();
		this.I = (Class<I>) ((ParameterizedType) type).getActualTypeArguments()[0];
		System.out.println(I);// class com.beans.Admin
	}

	@PostConstruct
	public void a() throws Exception {
		System.out.println("======BaseService==A========");
		String className = I.getSimpleName();
		System.out.println(className);// Admin
		String classDaoName = className.substring(0, 1).toLowerCase() + className.substring(1) + "Dao";
		System.out.println(classDaoName);// adminDao
		Field daoNameField = this.getClass().getSuperclass().getDeclaredField(classDaoName);
		System.out.println(daoNameField.getName());// adminDao
		Object object = daoNameField.get(this);
		Field baseDaoNameField = this.getClass().getSuperclass().getDeclaredField("baseDao");
		System.out.println(baseDaoNameField.getName());// baseDao
		baseDaoNameField.set(this, object);
	}

	@Override
	public I getById(int id) {
		return baseDao.getById(id);
	}

	@Override
	public void add(I I) {
		baseDao.add(I);
	}

	@Override
	public void update(I I) {
		baseDao.update(I);
	}

	@Override
	public void addOrUpdate(I I) {
		baseDao.saveOrUpdate(I);
	}

	@Override
	public void deleteById(int id) {
		System.out.println("idididi" + id);
		baseDao.deleteById(id);
	}

	@Override
	public void delete(I I) {
		baseDao.delete(I);
	}

	@Override
	public List findByConditions(String hql, String[] param, Page page) {
		return baseDao.findByConditions(hql, param, page);
	}

}
