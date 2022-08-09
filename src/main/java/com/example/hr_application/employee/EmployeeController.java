package com.example.hr_application.employee;

import com.example.hr_application.address.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("welcome")
    public String welcome(@RequestParam String name) {
        return "Welcome " + name;
    }

    @GetMapping("welcome/{name}")
    public String welcomePath(@PathVariable String name) {
        return "Welcome " + name;
    }

    @GetMapping("employee")
    public Employee getEmployee() {
        Employee employee = new Employee("Maria", "Software specialist", 9);
        Address address = new Address();
        address.setNumber("1");
        address.setStreet("street 1");
        employee.setAddress(address);
        return employee;
    }

    @GetMapping("employees")
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping("employee")
    public void addEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
    }


}




//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//public class EmployeeController {
//
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    public static List<Employee> employees = new ArrayList<>();
//    @GetMapping("welcome")
//    public String welcome(@RequestParam String name)
//    {
//        return "Welcome "+ name;
//    }
//
//    @GetMapping("welcome/{name}")
//    public String welcomePath(@PathVariable String name)
//    {
//        return "Welcome "+ name;
//    }
//
//    @GetMapping("employee")
//    public Employee getEmployee()
//    {
//        Employee employee = new Employee("Abhaya", "software specialist", 10);
//        return employee;
//    }
////    @GetMapping("allemployees")
////    public List<Employee> getEmployees()
////    {
////        return employees;
////    }
////
////    @PostMapping("addemployee")
////    public void addEmployee(Employee employee){
////        employees.add(employee);
////    }
//
//    @GetMapping("employees")
//    public List<Employee> getEmployees()
//    {
//        return employeeRepository.findAll();
//    }
//
//    @PostMapping("employee")
//    public void addEmployee(Employee employee){
//        employeeRepository.save(employee);
//    }
//
//
//}