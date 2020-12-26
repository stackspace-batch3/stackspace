package org.stackspace.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.stackspace.employee.entity.PreviousExperienceInfo;

@Repository
public interface PreviousCompaniesRepo extends JpaRepository<PreviousExperienceInfo, Integer> {

	
	List<PreviousExperienceInfo> findByStackspaceEmpId(Integer empId);
	//select * from PreviousExperienceInfo where empId=?
}
