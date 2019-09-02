package com.example.personinfo2.Mapper;


import com.example.personinfo2.Model.person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface PersonMapper {
    //通过人员工号查询人员信息
    @Select("select * from person where usercode=#{usercode};")
    Map<person,String> selectPerson(String usercode);

    @Select("select * from person")
    List<person> findAll();

    @Insert("insert into person(usercode,username,department) values (#{usercode},#{username},#{department}) ")
    void addPerson(person person);

}
