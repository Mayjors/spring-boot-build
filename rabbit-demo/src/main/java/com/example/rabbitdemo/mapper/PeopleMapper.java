package com.example.rabbitdemo.mapper;

import com.example.rabbitdemo.model.People;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PeopleMapper {

    @Delete("DELETE FROM people WHERE id=#{id}")
    int deleteByKey(Integer id);

    @Insert("INSERT INTO people(name,age,detail) values (#{name},#{age},#{detail})")
    int insertOne(People record);

//    int insertSelective(Model record);

    @Select("Select * from people where id=#{id} ")
    People selectById(Integer id);

    int updateByPrimaryKeySelective(People record);

    @Update("UPDATE people SET name=#{name}, age=#{age} WHERE id=#{id}")
    void update(People record);

    @Select("select * from people where name=#{name}")
    People findByName(@Param("name") String name);


    @Select("SELECT * FROM people")
    List<People> findAll();
}