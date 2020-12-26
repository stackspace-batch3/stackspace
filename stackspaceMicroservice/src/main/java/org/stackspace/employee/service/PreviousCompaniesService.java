package org.stackspace.employee.service;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.stackspace.employee.bindings.BgvPendingEmpInfo;
import org.stackspace.employee.bindings.EmpInfo;
import org.stackspace.employee.bindings.ExpInfo;
import org.stackspace.employee.bindings.PreviousExperienceInfos;
import org.stackspace.employee.entity.PreviousExperienceInfo;
import org.stackspace.employee.exception.FailedToSaveCompaniesInfoException;
import org.stackspace.employee.repository.PreviousCompaniesRepo;

@Service
public class PreviousCompaniesService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PreviousCompaniesService.class);

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private PreviousCompaniesRepo companiesRepo;

	public ResponseEntity<Object> getAll() {

		List<ExpInfo> expInfos = null;
		List<EmpInfo> empInfos = null;
		List<Integer> empIdList = null;
		BgvPendingEmpInfo pendingEmpInfo = null;
		List<PreviousExperienceInfo> expList = null;

		ResponseEntity<Object> responseEntity = null;
		try {
			LOGGER.info("Start of getAll()");

			// BGV not started
			empIdList = employeeService.getEmpIdsForNonBgv();

			pendingEmpInfo = new BgvPendingEmpInfo();

			empInfos = new LinkedList<>();

			for (Integer empId : empIdList) {
				expList = companiesRepo.findByStackspaceEmpId(empId);

				expInfos = new LinkedList<>();

				EmpInfo empInfo = new EmpInfo();
				empInfo.setEmpId(empId);
				empInfo.setExpInfo(expInfos);

				for (PreviousExperienceInfo info : expList) {

					ExpInfo expInfo = new ExpInfo();
					expInfo.setName(info.getCompanyName());
					expInfo.setEmpId(info.getEmpId());
					expInfo.setHrMail(info.getHrEmail());
					expInfo.setEmail(info.getEmail());

					expInfos.add(expInfo);

				}

				empInfos.add(empInfo);
			}

			pendingEmpInfo.setEmpInfo(empInfos);

			responseEntity = new ResponseEntity<>(pendingEmpInfo, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Error while getting all emp info ", e);
			responseEntity = new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOGGER.info("End of getAll()");

		return responseEntity;
	}

	public ResponseEntity<Object> save(PreviousExperienceInfos experienceInfos)
			throws FailedToSaveCompaniesInfoException {

		PreviousExperienceInfos infos = null;
		List<PreviousExperienceInfo> savedDate = null;

		ResponseEntity<Object> responseEntity = null;
		try {
			LOGGER.info("Strat of save(...)");
			infos = new PreviousExperienceInfos();

			savedDate = companiesRepo.saveAll(experienceInfos.getExperienceInfos());

			infos.setExperienceInfos(savedDate);

			responseEntity = new ResponseEntity<>(infos, HttpStatus.CREATED);
			LOGGER.info("End of save(...)");
		} catch (Exception e) {
			LOGGER.error("Error while saving the PreviousExperienceInfos {}", e);
			responseEntity = new ResponseEntity<>("Error while saving companies info",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return responseEntity;
	}
}
