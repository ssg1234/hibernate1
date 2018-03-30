package service;

import java.util.ArrayList;
import java.util.List;

import bean.EmployeeBean;
import controller.Employee;
import dao.EmployeeDAO;

public class EmployeeService {
	List<EmployeeBean> lis= new ArrayList<>();
	
	public List<EmployeeBean> getEmployees(){
		EmployeeDAO ed=new EmployeeDAO();
		lis=ed.getAllEmployees();
		for(EmployeeBean emp:lis) {
			if(emp.getDesg().equals("manager")) {
				emp.setSalary(emp.getSalary()+2000);
			}else if(emp.getDesg().equals("developer")){
				emp.setSalary(emp.getSalary()+1000);
			}else if(emp.getDesg().equals("tester")) {
				emp.setSalary(emp.getSalary()+500);	
			}
		}
		return lis;
	}
	
	public int insertRecord(EmployeeBean eb) {
		EmployeeDAO empdao=new EmployeeDAO();
		int e=empdao.insertEmployee(eb);
		if(e>0) {
			return 1;
		} 
		
		return 0;
	}

}
