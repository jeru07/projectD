package com.chainsys.application.Employee;
import java.util.Iterator;
import java.util.List;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController

public class EmployeeService
{
   @RequestMapping("/getemployee")
	public String getData(@RequestParam(name="id") String id)
	{
	   int empId = Integer.parseInt(id);
		Employee emp = EmployeeDao.getEmployeeById(empId);
			return emp.getFirst_name()+", " + emp.getLast_name()+", " + emp.getJob_id()+", " + emp.getSalary()+", "
					+ emp.getHire_date()+", " + emp.getEmail() ;
	   
	   
	}
	
   @RequestMapping("/getAll")
   public String getAll() {

		List<Employee> allEmployees = EmployeeDao.getAllEmployees();
		Iterator<Employee> empIterator = allEmployees.iterator();
		String result="";
		while(empIterator.hasNext())
		{
			Employee emp = empIterator.next();
			result+="<div>"+emp.getEmp_id()+" : "+emp.getFirst_name()+" : "+emp.getLast_name()+" : " 
					+ emp.getEmail() +" : " + emp.getHire_date()+ " : " + emp.getJob_id() +" : "+ emp.getSalary()+"</div>";
		}
			return 	result;

   }
	
}
