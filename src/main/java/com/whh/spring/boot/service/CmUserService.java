package com.whh.spring.boot.service;

import com.whh.spring.boot.model.CmUser;
import com.whh.spring.boot.utils.BaseQuery;
import com.whh.spring.boot.utils.Pagination;

import java.util.List;

public interface CmUserService {
    /**
     * 查询所有的用户信息
     * @return CmUser
     */
    List<CmUser> getUsers();


    Pagination<CmUser> getUsersQuery(BaseQuery query);

    
}
