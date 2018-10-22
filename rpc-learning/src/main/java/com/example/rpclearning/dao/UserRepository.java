package com.example.rpclearning.dao;

import com.example.rpclearning.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author yuanjie
 * @date 2018/9/26 9:54
 */
@Mapper
public interface UserRepository extends MongoRepository<User, Long> {

    List<User> findByUserNameLike(String userName);

    List<User> findByUserName(String userName);

    /**
     * greaterThan (大于)
     * {"age": {"$gt": age}}
     * @param age
     * @return
     */
    List<User> findByAgeGreaterThan(int age);

    /**
     * lessThan (小于)
     * {"age": {"$lt": age}}
     * @param age
     * @return
     */
    List<User> findByAgeLessThan(int age);

    /**
     * Between (在...之间)
     * {{"age": {"$gt": from, "$lt": to}}}
     * @param from
     * @param to
     * @return
     */
    List<User> findByAgeBetween(int from, int to);

    /**
     * 是否为空
     * @return
     */
    List<User> findByUserNameNotNull();

    List<User> findByUserNameNull();

    /**
     * Not (不包含)
     * @param userName
     * @return
     */
    List<User> findByUserNameNot(String userName);
}
