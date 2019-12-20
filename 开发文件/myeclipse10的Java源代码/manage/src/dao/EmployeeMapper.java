package dao;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import pojo.Employee;
@Repository("employeeMapper")
public  interface EmployeeMapper {
	public List<Employee> employeeSelect();//²é
	public int employeeDelete(@Param("id")Employee id);//É¾
	public List<Employee> employeeUpdate(@Param("p")Employee p);//ÐÞ
	public List<Employee> employeeInsert(@Param("p")Employee p);//Ìí
}
