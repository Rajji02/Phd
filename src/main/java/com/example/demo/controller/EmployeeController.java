package com.example.demo.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeKeys;
import com.example.demo.repositories.EmployeeRepsoitory;

@RestController
@RequestMapping("/api/composite")
public class EmployeeController {
	@Autowired 
	private EmployeeRepsoitory repos;
	@PostMapping("/empdetails")
	public Employee add(@RequestBody Employee employee) {
		return repos.save(employee);
		
	}
	
	@GetMapping("/all")
	public List<Employee> display() {
		return repos.findAll();
	}

	@GetMapping("/working")
	public String d() {
		return "now its working";
	}
	
	/*@PutMapping("/update/{id}")
	public ResponseEntity<String> updates(@PathVariable("id") int id)
	{
		System.out.println("id=----->"+id);
		//EmployeeKeys ek=
	//	int m
		Employee emp2=new Employee(new EmployeeKeys(id));
		System.out.println("adharid of emp object------->"+emp2.getId().getAdharid());
		System.out.println("emp id of emp object-------->"+emp2.getId().getEmpid());
		Optional<Employee> emp= repos.findById(new EmployeeKeys(id));
		if(emp.isPresent())
			return ResponseEntity.ok().body("yse the details exists" );
		return ResponseEntity.ok().body("yse the details  dont exists" );
	}*/
	
	@PutMapping("/update1/{id}/{name}")
	public ResponseEntity<String> updates1(@PathVariable("id") int id,@PathVariable("name") String name)
	{
	List<Employee>	emp=repos.findAll();
	Iterator itr=emp.iterator();
	Employee e1=null;
	boolean b=true;
	while(itr.hasNext())
	{
		Employee e=(Employee) itr.next();
		if(e.getId().getAdharid()==id)
		{
			e1=e;
			b=false;}
	}
	if(!b)
	{
		e1.setLastname(name);
		repos.save(e1);
		return ResponseEntity.ok().body("yes it is present");
		
	}
	return  ResponseEntity.ok().body("adhar id is not  present");
	}
	
	@PutMapping("/update3")
	public ResponseEntity<String> updates3(@RequestBody Employee emp)
	{
		
	//EmployeeKeys ek=
	//	int m
		Optional <Employee>e=repos.findById(emp);

		//System.out.println("adharid of emp object------->"+emp2.getId().getAdharid());
		//System.out.println("emp id of emp object-------->"+emp2.getId().getEmpid());
		//Optional<Employee> emp= repos.findById(new EmployeeKeys(id));
		if(e.isPresent())
			return ResponseEntity.ok().body("yse the details exists" );
		return ResponseEntity.ok().body("yse the details  dont exists" );
	}
	
}
