package service;
import java.util.List;
import pojo.Employee;

public interface EmployeeService {
	public List<Employee> employeeSelect();//²é
	public int employeeDelete(Employee id);//É¾
	public List<Employee> employeeUpdate(Employee p);//ÐÞ
	public List<Employee> employeeInsert(Employee p);//Ìí
}
