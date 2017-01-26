package com.dao.imp;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beans.Employee;
import com.dao.EmployeeDao;

@Transactional
@Repository
public class EmployeeDaoImp extends BaseDaoImp<Employee> implements EmployeeDao {

}
