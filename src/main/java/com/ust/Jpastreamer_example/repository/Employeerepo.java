package com.ust.Jpastreamer_example.repository;

import com.ust.Jpastreamer_example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Employeerepo extends JpaRepository<Employee,Integer> {
}
