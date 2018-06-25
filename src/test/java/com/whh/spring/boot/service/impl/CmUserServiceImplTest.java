package com.whh.spring.boot.service.impl;

import com.whh.spring.boot.BaseTests;
import com.whh.spring.boot.model.CmUser;
import com.whh.spring.boot.service.CmUserService;
import com.whh.spring.boot.utils.BaseQuery;
import com.whh.spring.boot.utils.Pagination;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author huahui.wu
 * @date 2018/6/25 15:06
 * @description
 */
public class CmUserServiceImplTest extends BaseTests {

    @Autowired
    private CmUserService cmUserService;

    @Test
    public void getUsers() {
    }

    @Test
    public void getUsersQuery() {

        BaseQuery query = new BaseQuery();
        query.setPage(1);
        query.setSize(10);
        Pagination<CmUser> pagination = cmUserService.getUsersQuery(query);
        System.out.println(pagination);
    }
}