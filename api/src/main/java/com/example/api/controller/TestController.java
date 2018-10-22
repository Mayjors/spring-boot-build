package com.example.api.controller;

import com.example.pojo.model.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuanjie
 * @date 2018/9/27 20:34
 */
@RestController
public class TestController {

    // 创建线程安全的Map
    static Map<Integer, User> users = Collections.synchronizedMap(new HashMap<Integer, User>());

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public Object getUserById(@PathVariable(value = "id") Integer id) {
        User user = users.get(id);
        return user;
    }

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public Object add(@RequestBody User user) {
        users.put(user.getUserId(), user);
        return 0;
    }
}
