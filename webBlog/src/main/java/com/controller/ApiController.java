package com.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.controller.builder.PageBuilder;

@CrossOrigin(origins = "http://localhost:8091")
@RestController
@RequestMapping(path = "api/", method = RequestMethod.GET)
public class ApiController extends PageBuilder {

	@GetMapping("main")
	public HashMap<String, Object> example() {

		return super.executeApi();
	}
}
