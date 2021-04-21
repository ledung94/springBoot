package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.EmployeeService;
@Controller
@RequestMapping("/template")
public class ViewApplicationController {
	@Autowired
	EmployeeService employeeService;
	@GetMapping(value = "/")
	public String getTemplate(@RequestParam(name = "name",required=false,defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("emps", employeeService.findAll());
		return "thymeleafTemplate";
	}

}
