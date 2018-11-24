package com.example.rabbitdemo.mapper;

import com.example.rabbitdemo.model.People;
import com.example.rabbitdemo.model.Work;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface WorkMapper {

    @Delete("DELETE FROM work WHERE id=#{id}")
    int deleteByKey(Integer id);

    @Insert("INSERT INTO work(work_name,place,start_time,end_time,detail) values (#{work_name},#{place},#{start_time},#{end_time},#{detail})")
    int insertOne(Work record);

//    int insertSelective(Model record);

    @Select("Select * from work where id=#{id} ")
    Work selectById(Integer id);

    int updateByPrimaryKeySelective(Work record);

    @Update("UPDATE work SET name=#{work_name}, place=#{place} WHERE id=#{id}")
    void update(Work record);

    @Select("select * from people where name=#{work_name}")
    Work findByName(@Param("work_name") String name);


    @Select("SELECT * FROM people")
    List<Work> findAll();
}