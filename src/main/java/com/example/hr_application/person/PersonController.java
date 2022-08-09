package com.example.hr_application.person;

import com.example.hr_application.address.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("person")
    public Person getPerson()
    {
        //Address address = new Address("20", "street1", "chennai", 600015);
        Person person = new Person("Abhaya", "music");
        Address address = new Address();
        address.setNumber("1");
        address.setStreet("street 1");
        person.setAddress(address);
        return person;
    }

    @GetMapping("person1")
    public String welcome(@RequestParam String name, String hobby)
    {
        return "Welcome "+ name + " "+ hobby;
    }

    @GetMapping("welcome/{name}/{hobby}")
    public String welcomePath(@PathVariable String name, @PathVariable String hobby)
    {
        return "Welcome "+ name + hobby;
    }

    @GetMapping("persons")
    public List<Person> getPersons() {
        return personRepository.findAll();
    }

   @PostMapping("person")
    public void addPerson(@RequestBody Person person) {
       personRepository.save(person);
    }

    @PostMapping("editperson")
    public void editPerson(@RequestBody Person person)
    {
        Person person1 = personRepository.findByid(person.getId());
        person1.setName(person.getName());
        person1.setHobby(person.getHobby());
        person1.setAddress(person.getAddress());
        personRepository.save(person1);
    }

    @GetMapping("find")
    public List<Person> findPerson(@RequestParam String name){
        return personRepository.findByName(name);
    }

    @GetMapping("findID")
    public Person findPersonByID(@RequestParam Long id){
        return personRepository.findByid(id);
    }

    @PostMapping("delete")
    public void deletePerson(@RequestParam Long id){
        personRepository.deleteById(id);
    }
}
