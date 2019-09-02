package com.example.personinfo2.Controller;

import com.example.personinfo2.Model.person;
import com.example.personinfo2.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping
    public List<person> findAll(){
        System.out.println("开始查询所有数据...");
        return personService.findAll();
    }

    @RequestMapping("/select")
    public Map<person,String> selectPerson(String usercode){
        usercode = "123";
        return personService.selectPerson(usercode);
    }

    @RequestMapping("/add")
    public void addPerson(person person){
        System.out.println("————开始新增————");
        personService.addPerson(person);
        System.out.println("————完成新增————");
    }

}
