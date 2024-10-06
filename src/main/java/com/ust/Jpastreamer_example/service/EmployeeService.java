package com.ust.Jpastreamer_example.service;

import com.speedment.jpastreamer.application.JPAStreamer;
import com.ust.Jpastreamer_example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ust.Jpastreamer_example.repository.Employeerepo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private Employeerepo emprepo;
    private final JPAStreamer jpaStreamer;

   @Autowired
    public EmployeeService(final JPAStreamer jpaStreamer) {
        this.jpaStreamer = jpaStreamer;
    }

    public Map<String, List<Employee>> groupEmployeeByCity()
    {
        return jpaStreamer.stream(Employee.class)
                .collect(Collectors.groupingBy(Employee::getCity));
    }

    public List<Employee> findAllEmployee()
    {
        return emprepo.findAll();
    }

    public List<Employee> saveEmployee(List<Employee> employee){
       return emprepo.saveAll(employee);
    }

    public Map<String,Long> groupByEducationUnderPaymentTier(int tier)
    {
        return jpaStreamer.stream(Employee.class)
                .filter(Employee -> Employee.getPaymentTier()<=tier)
                .collect(Collectors.groupingBy(Employee::getEducation,Collectors.counting()));
    }

    public Map<String,Long> countEmployeesByGender()
    {
        return jpaStreamer.stream(Employee.class)
                .collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
    }
}
