package com.example.manager;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author yuanjie
 * @date 2018/9/17 20:10
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUNit支持,由此引入Spring-Test框架支持
@SpringBootTest(classes = ManagerApplication.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration    // 由于是Web项目,Junit需要模拟ServletContext, 因此我们需要把我们的测试类上加上@Web。。
public class UserServiceTest {
}
