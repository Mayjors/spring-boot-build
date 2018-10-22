package com.example.rpclearning.dao;

import com.example.rpclearning.RpcLearningApplication;
import com.example.rpclearning.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author yuanjie
 * @date 2018/9/26 10:06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RpcLearningApplication.class)
public class UserRepositoryTest {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() {

    }

    @Test
    public void test() {
        // 创建10个User，并验证User总数
        userRepository.save(new User(1L, "didi", 30));
        userRepository.save(new User(2L, "mama", 40));
        userRepository.save(new User(3L, "kaka", 50));
        userRepository.save(new User(4L, "didi2", 30));
        userRepository.save(new User(5L, "mama", 40));
        userRepository.save(new User(6L, "kaka2", 50));
        userRepository.save(new User(7L, "kaka", 50));
        userRepository.save(new User(8L, "kao", 50));
        userRepository.save(new User(9L, "ekakae", 50));
        userRepository.save(new User(10L, "kaka5", 50));
        userRepository.save(new User(11L, "", 50));
        userRepository.save(new User(12L, null, 50));
        this.logger.info(String.valueOf(userRepository.findAll().size()));
    }

    @Test
    public void test2() {
        List<User> u1 = userRepository.findByUserNameLike("kaka");
        logger.info(u1.toString());
        List<User> u2 = userRepository.findByUserName("mama");
        logger.info(u2.toString());

    }
}
