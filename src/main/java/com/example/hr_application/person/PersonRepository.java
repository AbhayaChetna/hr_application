package com.example.hr_application.person;

import com.example.hr_application.employee.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findAll();
    List<Person> findByName(String name);
    Person findByid(Long id);
}
