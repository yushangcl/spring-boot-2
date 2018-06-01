package com.whh.spring.boot.service;

import com.whh.spring.boot.model.CmUser;

import java.util.List;

public interface CmUserService {
    /**
     * 查询所有的用户信息
     * @return CmUser
     */
    List<CmUser> getUsers();
}
