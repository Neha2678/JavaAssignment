package com.example.MiniProject.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class TestingController {
	@RequestMapping("/neha")
	public String JustTesting()
	{
		return "customer";
	}

}
