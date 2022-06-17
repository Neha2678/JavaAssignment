package com.example.Block.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Block.Entity.Employee;



public interface EmployeeRepo extends JpaRepository<Employee,Integer>{
	
	@Query("select e from Employee e where e.Employee_Name= :employee_name")
	public Employee getEmployeeById(@Param("employee_name") String employee_name);


}
