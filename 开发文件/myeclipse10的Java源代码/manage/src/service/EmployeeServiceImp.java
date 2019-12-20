package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import dao.EmployeeMapper;

import pojo.Employee;

@Repository("employeeService")
public class EmployeeServiceImp implements EmployeeService {
	@Resource
	private EmployeeMapper employeeMapper;

	public List<Employee> employeeSelect() {
		return employeeMapper.employeeSelect();
	}

	public int employeeDelete(Employee id) {
		return employeeMapper.employeeDelete(id);
	}

	public List<Employee> employeeUpdate(Employee p) {
		return employeeMapper.employeeUpdate(p);
	}

	public List<Employee> employeeInsert(Employee p) {
		return employeeMapper.employeeInsert(p);
	}

}
