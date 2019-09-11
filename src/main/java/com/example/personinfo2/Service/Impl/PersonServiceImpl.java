package com.example.personinfo2.Service.Impl;

import com.example.personinfo2.Mapper.PersonMapper;
import com.example.personinfo2.Model.person;
import com.example.personinfo2.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonMapper personMapper;

    @Override
    public Map<person,String> selectPerson(String usercode){
        return personMapper.selectPerson(usercode);
    }

    @Override
    public List<person> findAll(){return personMapper.findAll();}

    @Override
    public void addPerson(person person){
        person.setUsercode("789");
        person.setUsername("刘五");
        person.setDepartment("财务部");

        personMapper.addPerson(person);
    }

}
