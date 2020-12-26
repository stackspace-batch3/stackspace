package org.stackspace.bgv.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.stackspace.bgv.bindings.BgvPendingEmpInfo;

@Service
public class BgvService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BgvService.class);

	private static final String URL = "http://localhost:7071/stackspace/pre-exp";
	@Autowired
	private RestTemplate restTemplate;

	public ResponseEntity<Object> getList() {

		BgvPendingEmpInfo bgvPendingEmpInfo = null;
		ResponseEntity<Object> responseEntity = null;
		try {

			LOGGER.info("Start of getList()");

			bgvPendingEmpInfo = restTemplate
					.exchange(URL, HttpMethod.GET, null, BgvPendingEmpInfo.class, new Object[] {}).getBody();

			LOGGER.info("End of getList() ={}", bgvPendingEmpInfo);
			responseEntity = new ResponseEntity<>(bgvPendingEmpInfo, HttpStatus.OK);

		} catch (Exception e) {
			LOGGER.error("Error while getiing the list", e);
			responseEntity = new ResponseEntity<>("Failed to retrive", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return responseEntity;
	}
}
