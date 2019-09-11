package com.example.personinfo2.Service;

import com.example.personinfo2.Model.person;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;
import java.util.Map;


@WebService(targetNamespace = "http://Service.personinfo2.example.com")
public interface PersonService {

    @WebMethod(operationName = "selectPerson")
    Map<person,String> selectPerson(String usercode);

    @WebMethod(operationName = "findAll")
    List<person> findAll();

    @WebMethod(operationName = "addPerson")
    void addPerson(person person);
}
