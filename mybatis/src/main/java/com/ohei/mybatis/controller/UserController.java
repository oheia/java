package com.ohei.mybatis.controller;

import com.ohei.framework.bean.PageData;
import com.ohei.framework.bean.RespListBean;
import com.ohei.framework.bean.RespState;
import com.ohei.mybatis.mbg.model.User;
import com.ohei.mybatis.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/listAll")
    @ResponseBody
    public RespListBean<User> getUserList(){
        return new RespListBean<>(userService.listAllUser());
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public RespState createUser(@RequestBody User user){
        int result = userService.createUser(user);
        return new RespState(result == 1);
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public PageData<User> listUser(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize){
        List<User> list = userService.listUser(pageNum,pageSize);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        PageData<User> userPageData = new PageData<>();
        userPageData.setData(list);
        userPageData.setTotalCount((int) pageInfo.getTotal());
        return userPageData;
    }
}
