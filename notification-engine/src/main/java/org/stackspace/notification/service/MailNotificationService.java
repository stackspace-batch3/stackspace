package org.stackspace.notification.service;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.stackspace.notification.model.BenchEmpInfoList;
import org.stackspace.notification.model.BenchEmployeeInfo;

@Service
public class MailNotificationService {

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(MailNotificationService.class);

	//Here ${abc:xyz} abc is not mentioned in properties file it will take xyz value as default
	@Value("${stackspace.hr.email:alternativeGmail}")
	private String hrMail;
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private JavaMailSender javaMailSender;

	@Scheduled(fixedRate = 10000)
	public void send() {

		LOGGER.info("Start of send()");
		try {

			ResponseEntity<BenchEmpInfoList> response = restTemplate.getForEntity("http://localhost:7071/stackspace/employee/info",
					BenchEmpInfoList.class);

			// Use StringBuilder for better memory management
			String formate = "";
			if (response.getStatusCode() == HttpStatus.OK) {

				BenchEmpInfoList benchEmpInfoList = response.getBody();

				List<BenchEmployeeInfo> empInfos = benchEmpInfoList.getBenchEmpInfos();

				for (BenchEmployeeInfo info : empInfos) {
					formate += "empId= " + info.getEmpId() + ", experience= " + info.getExperience() + ", skills="
							+ info.getSkills() + "\n";

				}
				final String message = formate;

				javaMailSender.send(new MimeMessagePreparator() {

					@Override
					public void prepare(MimeMessage mimeMessage) throws Exception {

						MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
						messageHelper.setSubject("Bench employees information");
						messageHelper.setText(message);
						messageHelper.setTo(hrMail);

					}
				});
			} else {
				LOGGER.info("No response from target resource");
			}

		} catch (Exception e) {
			LOGGER.error("Error while sending..", e);
		}
		LOGGER.info("End of send()");
	}

}
