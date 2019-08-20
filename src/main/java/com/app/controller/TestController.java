package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

		@RequestMapping(value="/show")
		public String showPae() {
			return "page";
		}
}
