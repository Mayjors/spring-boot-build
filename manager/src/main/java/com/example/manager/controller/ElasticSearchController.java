package com.example.manager.controller;

import com.example.manager.entity.Employee;
import com.example.manager.mapper.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yuanjie
 * @date 2018/9/19 18:31
 */
@RestController
@RequestMapping("/es")
public class ElasticSearchController {
    @Autowired
    private EmployeeRepository er;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @RequestMapping("/add")
    public String add() {
        Employee employee = new Employee();
        employee.setId("1");
        employee.setFirstName("xuxu");
        employee.setLastName("zh");
        employee.setAge(26);
        employee.setAbout("i am in peking");
        er.save(employee);

        System.err.println("add a obj");

        return "success";
    }

    @RequestMapping("/delete")
    public String delete() {
        er.deleteById("1");

        return "success";
    }

    //局部更新
    @RequestMapping("/update")
    public String update(){

        Employee employee=er.queryEmployeeById("1");
        employee.setFirstName("哈哈");
        er.save(employee);

        System.err.println("update a obj");

        return "success";
    }

    //查询
    @RequestMapping("/query")
    public Employee query(){

        SearchQuery searchQuery = new NativeSearchQueryBuilder().build();
        List<Employee> list = elasticsearchTemplate.queryForList(searchQuery, Employee.class);

        Employee accountInfo=er.queryEmployeeById("1");
        System.err.println(accountInfo.toString());

        return accountInfo;
    }

}
