package com.ohei.mybatis.service.impl;

import com.ohei.mybatis.mbg.mapper.UserMapper;
import com.ohei.mybatis.mbg.model.User;
import com.ohei.mybatis.mbg.model.UserExample;
import com.ohei.mybatis.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User getUser(Long id) {
        return userMapper.selectByPrimaryKey(Math.toIntExact(id));
    }

    @Override
    public List<User> listAllUser() {
        return userMapper.selectByExample(new UserExample());
    }

    @Override
    public List<User> listUser(int pageNum, int pageSize) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPage(()->
                userMapper.selectByExample(new UserExample()));
    }

    @Override
    public int createUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public int updateUser(Long id, User user) {
        user.setId(Math.toIntExact(id));
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int deleteUser(Long id) {
        return userMapper.deleteByPrimaryKey(Math.toIntExact(id));
    }
}
