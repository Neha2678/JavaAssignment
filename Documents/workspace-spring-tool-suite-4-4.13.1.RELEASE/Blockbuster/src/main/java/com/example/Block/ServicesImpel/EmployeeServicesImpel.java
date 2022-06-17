package com.example.Block.ServicesImpel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Block.Validators.UserFoundException;
import com.example.Block.Entity.Employee;
import com.example.Block.Repo.EmployeeRepo;
import com.example.Block.Services.EmployeeServices;
@Service
public class EmployeeServicesImpel implements EmployeeServices {

	@Autowired
	EmployeeRepo empRepo;
	
	@Override
	public Employee addEmployee(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		Employee emp = this.empRepo.getEmployeeById(employee.getEmployee_Name());
		 if (emp != null) {
	            System.out.println("Employee is already there !!");
	            throw new UserFoundException();
	        }
		 else
		 {
			 emp = this.empRepo.save(employee);
		 }
		 return emp;
	}

}
