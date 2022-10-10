package com.example.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.back.model.Employee;

@Repository

public interface Emp_rep extends JpaRepository<Employee, Long> {

}
