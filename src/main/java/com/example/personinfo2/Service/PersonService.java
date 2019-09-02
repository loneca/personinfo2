package com.example.personinfo2.Service;

import com.example.personinfo2.Model.person;

import java.util.List;
import java.util.Map;

public interface PersonService {
    Map<person,String> selectPerson(String usercode);

    List<person> findAll();

    void addPerson(person person);
}
