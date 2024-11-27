 package com.project.LibraryManagementSystem.Controller;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.LibraryManagementSystem.Entity.SendEmailRequest;
//import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.project.LibraryManagementSystem.Entity.SentEmails;
import com.project.LibraryManagementSystem.Service.SentEmailsService;

@RestController
@RequestMapping("/users")
public class SentEmailsController {

	@Autowired
	private SentEmailsService sentEmailsService;
	
	//This method is used to send a Email
	@PostMapping("/send-email")
	public ResponseEntity<String> sendEmail(@RequestBody SendEmailRequest emailRequest) {
		sentEmailsService.sendEmailWithHistory(
	        emailRequest.getRecipient(),
	        emailRequest.getBody(),
	        emailRequest.getSubject(),
	        emailRequest.getFromEmailId()
	    );
	    return ResponseEntity.ok("Email sent successfully to " + emailRequest.getRecipient());
	}
	
	
	@GetMapping("/email-history")
	public ResponseEntity<List<SentEmails>> getEmailHistory() {
	    List<SentEmails> emailHistory = sentEmailsService.getEmailHistory();
	    return ResponseEntity.ok(emailHistory);
	}
}
