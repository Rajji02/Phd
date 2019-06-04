package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeKeys;

public interface EmployeeRepsoitory  extends JpaRepository<Employee,Long>{

Optional<Employee> findById(Employee id1);




}
