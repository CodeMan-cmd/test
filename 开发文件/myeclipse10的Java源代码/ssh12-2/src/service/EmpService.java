package service;

import java.util.List;

import entity.Emp;

public interface EmpService {

	public List<Emp> findAll();
	public void add(Emp transientInstance) ;
}
