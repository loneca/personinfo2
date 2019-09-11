package com.example.personinfo2.Client;

import com.example.personinfo2.Service.PersonService;
import com.google.gson.Gson;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import java.util.Map;

public class CXFClient {
    public static void main(String[] args) {
        try {
            // 接口地址
            String address = "http://127.0.0.1:8080/soap/person";
            // 代理工厂
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            // 设置代理地址
            jaxWsProxyFactoryBean.setAddress(address);
            // 设置接口类型
            jaxWsProxyFactoryBean.setServiceClass(PersonService.class);
            // 创建一个代理接口实现
            PersonService us = (PersonService) jaxWsProxyFactoryBean.create();
            // 数据准备
            String json = null;
            // 调用代理接口的方法调用并返回结果
            Map map =us.selectPerson("123");
            System.out.println(map);

            Gson gson = new Gson();
            json = gson.toJson(map);
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
