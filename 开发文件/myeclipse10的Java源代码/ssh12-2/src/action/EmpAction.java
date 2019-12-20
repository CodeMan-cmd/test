package action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import service.EmpService;

import com.opensymphony.xwork2.ActionSupport;

import entity.Emp;
@Controller
public class EmpAction extends ActionSupport {

	@Resource
	private EmpService empService;
	private List<Emp> list;
	
	
	public List<Emp> getList() {
		return list;
	}


	public void setList(List<Emp> list) {
		this.list = list;
	}


	public EmpService getEmpService() {
		return empService;
	}


	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		list = empService.findAll();
		for (Emp emp : list) {
			System.out.println(emp.getEname());
		}
		
		return SUCCESS;
	}
	
	private String userName;
	
	
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String save(){
		Emp e=new Emp();
		e.setEname(userName);
		empService.add(e);
		return SUCCESS;
	}

	
}
