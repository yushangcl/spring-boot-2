package com.whh.spring.boot.service.impl;

import com.whh.spring.boot.dao.CmUserMapper;
import com.whh.spring.boot.model.CmUser;
import com.whh.spring.boot.model.CmUserExample;
import com.whh.spring.boot.service.CmUserService;
import com.whh.spring.boot.utils.BaseQuery;
import com.whh.spring.boot.utils.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmUserServiceImpl implements CmUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CmUserServiceImpl.class);

    @Autowired
    private CmUserMapper cmUserMapper;

    @Override
    public List<CmUser> getUsers() {
        List<CmUser> cmUsers = cmUserMapper.selectUsers();
        LOGGER.debug(cmUsers.toString());
        return cmUsers;
    }

    @Override
    public Pagination<CmUser> getUsersQuery(BaseQuery query) {
        CmUserExample example = new CmUserExample();
        example.setLimit(query.getLimit());
        example.setOffset(query.getOffset());
        List<CmUser> cmUsers = cmUserMapper.selectByExample(example);
        return new Pagination<CmUser>(query.getPage(), query.getSize(), 1, cmUsers);
    }
}
