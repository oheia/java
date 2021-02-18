package com.ohei.swaggerui.Controller;

import com.ohei.framework.bean.RespState;
import com.ohei.swaggerui.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation("用户列表")
    @GetMapping("/{id}")
    @ResponseBody
    public User getViewObjectMapping(@PathVariable("id") Long id) {
        User user = new User();
        user.setAge(18);
        user.setId(18);
        user.setMoney(1800000D);
        user.setName("ohei");
        return user;
    }

    @ApiOperation("创建用户")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public RespState createUser(@RequestBody User user){
        return new RespState(true);
    }

}
