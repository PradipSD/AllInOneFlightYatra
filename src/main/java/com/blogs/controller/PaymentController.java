package com.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.service.PaymentService;

@RestController
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	

}
