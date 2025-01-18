package com.example.starter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {
	
	private static List<EmployeeModel> employeeList=
			new ArrayList<EmployeeModel>();
	
	
	
	public List<EmployeeModel> getEmployees(){
		return employeeList;
	}
	
	public EmployeeModel getEmployee(String employeeId){
		List<EmployeeModel> list=employeeList.stream()
				.filter(e->String.valueOf(e.getId()).equalsIgnoreCase(employeeId)).collect(Collectors.toList());
		return list.get(0);
	}
	
	public List<EmployeeModel> addEmployee(EmployeeModel employee){
		employeeList.add(employee);
		return employeeList;
		
	}
	
	public List<EmployeeModel> updateEmployee(EmployeeModel employee){
		employeeList.removeIf(emp->String.valueOf(employee.getId()).equals(String.valueOf(emp.getId())));
		employeeList.add(employee);
		return employeeList;
		
	}
	
	public List<EmployeeModel> deleteEmployee(String employeeId){
		employeeList.removeIf(emp->employeeId.equals(String.valueOf(emp.getId())));
		return employeeList;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static {
		EmployeeModel emp1=new EmployeeModel(Long.parseLong("1"), "AAAAAAA", "1111111111", "aaaaaa@mail.com", "Admin");
		EmployeeModel emp2=new EmployeeModel(Long.parseLong("2"), "BBBBBBB", "2222222222", "aaaaaa@mail.com", "Admin");
		EmployeeModel emp3=new EmployeeModel(Long.parseLong("3"), "CCCCCCC", "3333333333", "aaaaaa@mail.com", "Admin");
		EmployeeModel emp4=new EmployeeModel(Long.parseLong("4"), "DDDDDDD", "4444444444", "aaaaaa@mail.com", "Admin");
		employeeList=new ArrayList<EmployeeModel>(Arrays.asList(emp1,emp2,emp3,emp4));
		
		
	}

}
