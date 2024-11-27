package com.project.LibraryManagementSystem.Service;

import java.time.LocalDateTime;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.project.LibraryManagementSystem.Entity.SentEmails;
import com.project.LibraryManagementSystem.Repository.SentEmailsRepository;
import com.project.LibraryManagementSystem.Service.SentEmailsService;
@Service
public class SentEmailsService{

	@Autowired
	private SentEmailsRepository sentEmailsRepository;
	
	@Autowired
	private JavaMailSender javaMailSender;

	//For Post Method
	
	public void sendEmailWithHistory(String recipient, String body, String subject, String fromEmailId) {
	    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
	    simpleMailMessage.setFrom(fromEmailId);
	    simpleMailMessage.setTo(recipient);
	    simpleMailMessage.setText(body);
	    simpleMailMessage.setSubject(subject);
	    javaMailSender.send(simpleMailMessage);

	    // Save email to history
	    SentEmails sentEmail = new SentEmails();
	    sentEmail.setRecipient(recipient);
	    sentEmail.setSubject(subject);
	    sentEmail.setBody(body);
	    sentEmail.setFromEmailId(fromEmailId);
	    sentEmail.setSentAt(LocalDateTime.now());
	    sentEmailsRepository.save(sentEmail);
	}

	//For Get Method
	
	public List<SentEmails> getEmailHistory() {
	    return sentEmailsRepository.findAll();
	}
}
