package com.example.personinfo2.Config;


import com.example.personinfo2.Service.PersonService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class CXFconfig {

    @Autowired
    private Bus bus;
    @Autowired
    private PersonService personService;


    @Bean
    public ServletRegistrationBean dispatcherServlet(){
        return new ServletRegistrationBean(new CXFServlet(),"/soap/*");
    }

    /*
    * 发布服务
    *
    * */
    @Bean
    public Endpoint personEndpoint(){
        EndpointImpl endpoint = new EndpointImpl(bus,personService);
        endpoint.publish("/person");
        return endpoint;
    }

}
