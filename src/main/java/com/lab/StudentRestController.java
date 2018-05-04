package com.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRestController {

	@Autowired
	StudentRepository studentRepository;

	@RequestMapping("/students/{id}")
	public @ResponseBody Student next(@RequestParam("id") Long studentID) {
		System.out.println(" id = "+ studentID);
		return studentRepository.findById(studentID);
	}
}
