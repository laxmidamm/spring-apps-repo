package com.example.conference.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.conference.demo.model.Employee;
import com.example.conference.demo.repo.EmployeeRepository;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@RequestMapping("/")
	public String home() {
		return "employee";
	}

	@RequestMapping("/addEmployee")
	public ModelAndView home(Employee emp) {
		Employee employee = employeeRepository.save(emp);
		ModelAndView mv = new ModelAndView();
		mv.addObject("emp", employee);
		mv.setViewName("redirect:employees");
		return mv;
	}
	
	@RequestMapping("/employees")
	public @ResponseBody ModelAndView getAllEmployees(){
		List<Employee> employeees = employeeRepository.findAll();
		System.out.println(employeees);
		ModelAndView mv = new ModelAndView();
		mv.addObject("employees", employeees);
		mv.setViewName("showEmployees");
		return mv;
	}
}
