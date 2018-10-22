package com.example.manager.mapper;

import com.example.manager.entity.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @author yuanjie
 * @date 2018/9/19 18:29
 */
@Component
public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {

    Employee queryEmployeeById(String id);
}
