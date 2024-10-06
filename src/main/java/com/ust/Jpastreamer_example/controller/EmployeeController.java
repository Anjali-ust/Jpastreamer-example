package com.ust.Jpastreamer_example.controller;

import com.ust.Jpastreamer_example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ust.Jpastreamer_example.service.EmployeeService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class EmployeeController {

    @Autowired
   private EmployeeService employeeService;

    @GetMapping("/groupByCity")
    public Map<String, List<Employee>> groupEmployeeByCity()
    {
        return employeeService.groupEmployeeByCity();
    }

    @GetMapping("/findAll")
    public List<Employee> findAllEmployee()
    {
        return employeeService.findAllEmployee();
    }

    @PostMapping("/save")
    public List<Employee> saveEmployee(@RequestBody List<Employee> employee)
    {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/groupByEducation/paymentTier/{tier}")
   public Map<String,Long> groupByEducationUnderPaymentTier(@PathVariable("tier") int tier)
   {
       return employeeService.groupByEducationUnderPaymentTier(tier);
   }

   @GetMapping("/countByGender")
    public Map<String,Long> countEmployeesByGender()
    {
        return employeeService.countEmployeesByGender();
    }
}
