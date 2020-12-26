package org.stackspace.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.stackspace.employee.entity.Employee;

@Service
@Transactional
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	Employee findByEmpId(int empId);
	// select * from Employee_stackspace where EmpId= empId

	@Modifying
	@Query(value = "delete from Employee where empId=:empId")
	int deleteByEmpId(@Param("empId") int empId);

	// @Query("//update")
	// void update(Employee employee);

	Employee findPkIdByEmpId(int empId);

	@Query(value = "select max(emp_id) from stackspace_employee", nativeQuery = true)
	Integer getMaxEmpId();

	// select * from stackspace_employee where is_active=falg
	List<Employee> findByisActive(String falg);

	// select * from stackspace_employee where
	List<Employee> findByIsBgvDone(String string);

}
