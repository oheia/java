package com.ohei.mybatis.service;

import com.ohei.mybatis.mbg.model.User;

import java.util.List;

public interface UserService {

    User getUser(Long id);

    List<User> listAllUser();

    List<User> listUser(int pageNum, int pageSize);

    int createUser(User user);

    int updateUser(Long id, User user);

    int deleteUser(Long id);
}
