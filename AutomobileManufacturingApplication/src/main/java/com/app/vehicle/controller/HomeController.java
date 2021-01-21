package com.app.vehicle.controller;

import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/")
	public String home() {
		//LocalDateTime dt=LocalDateTime.now();
		return "Server Start Time is "+ LocalDateTime.now();
	}
}
