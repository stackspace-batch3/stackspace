package org.stackspace.notification.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stackspace.notification.service.MailNotificationService;

@RestController
@RequestMapping("/stackspace/notification")
public class NotificationResource {

	@Autowired
	private MailNotificationService service;

	@GetMapping
	public String check() {
		return "Notification Microservice is Up and Running...";
	}

	@GetMapping(value = "/send/{message}")
	public String send(@PathVariable("message") String message) {
		service.send();

		return "sent";
	}
}
