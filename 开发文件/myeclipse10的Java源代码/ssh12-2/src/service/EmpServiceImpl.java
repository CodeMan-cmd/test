package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.EmpDAO;

import entity.Emp;
@Service
public class EmpServiceImpl implements EmpService {
	
	@Resource
	private EmpDAO empDao;
	
	
	public EmpDAO getEmpDao() {
		return empDao;
	}


	public void setEmpDao(EmpDAO empDao) {
		this.empDao = empDao;
	}


	public List<Emp> findAll() {
		// TODO Auto-generated method stub
		return empDao.findAll();
	}


	public void add(Emp transientInstance) {
		// TODO Auto-generated method stub
		empDao.save(transientInstance);
	}

}
