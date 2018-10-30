package com.example.manager.controller;

import com.example.manager.ManagerApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @author yuanjie
 * @date 2018/9/17 20:03
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUNit支持,由此引入Spring-Test框架支持
@SpringBootTest(classes = ManagerApplication.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration    // 由于是Web项目,Junit需要模拟ServletContext, 因此我们需要把我们的测试类上加上@Web。。
public class UserControllerTest {

    private MockMvc mockMvc;
    @Resource
    private UserController userController;
    @Before
    public void before() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }
    @Test
    public void getAll() throws Exception {
        mockMvc.perform(get("/user/all/1/10")).andDo(print()).andExpect(status().isOk());
    }

}
