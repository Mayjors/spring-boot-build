package com.example.rabbitdemo.mapper;

import com.example.rabbitdemo.model.Model;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ModelMapper {

    @Delete("DELETE FROM model WHERE id=#{id}")
    int deleteByKey(Integer id);

    @Insert("INSERT INTO model(name,password) values (#{name},#{password})")
    int insertOne(Model record);

//    int insertSelective(Model record);

    @Select("Select * from model where id=#{id} ")
    Model selectById(Integer id);

    int updateByPrimaryKeySelective(Model record);

    @Update("UPDATE model SET name=#{name}, password=#{password} WHERE id=#{id}")
    void update(Model record);

    @Select("select * from model where name=#{name}")
    Model findByName(@Param("name") String name);


    @Select("SELECT * FROM model")
    List<Model> findAll();
}