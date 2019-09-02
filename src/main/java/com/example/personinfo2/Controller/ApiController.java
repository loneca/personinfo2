package com.example.personinfo2.Controller;

import com.example.personinfo2.Model.person;
import com.example.personinfo2.Service.PersonService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller

public class ApiController extends HttpServlet {

    @Autowired
    private PersonService personService;


    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "personinfo", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public String personinfo(String usercode){
        String json = null;
        System.out.println(usercode);
        Map map= personService.selectPerson(usercode);

        Gson gson = new Gson();
        json = gson.toJson(map);
        System.out.println(json);
        return json;

    }

}
