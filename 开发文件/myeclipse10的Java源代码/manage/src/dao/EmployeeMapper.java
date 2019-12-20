package dao;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import pojo.Employee;
@Repository("employeeMapper")
public  interface EmployeeMapper {
	public List<Employee> employeeSelect();//��
	public int employeeDelete(@Param("id")Employee id);//ɾ
	public List<Employee> employeeUpdate(@Param("p")Employee p);//��
	public List<Employee> employeeInsert(@Param("p")Employee p);//��
}
