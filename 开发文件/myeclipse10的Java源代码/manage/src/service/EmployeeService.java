package service;
import java.util.List;
import pojo.Employee;

public interface EmployeeService {
	public List<Employee> employeeSelect();//��
	public int employeeDelete(Employee id);//ɾ
	public List<Employee> employeeUpdate(Employee p);//��
	public List<Employee> employeeInsert(Employee p);//��
}
