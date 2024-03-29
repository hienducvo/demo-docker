package com.hh.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/send/v1")
public class Controller {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/home")
	public String defaultController() {
		
		return "Hello world";
	}
	
	@PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody Employee employee){
        employeeRepository.save(employee);
    }
    
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

}
