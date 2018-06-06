package com.whh.spring.boot.service.impl;

import com.whh.spring.boot.dao.CmUserMapper;
import com.whh.spring.boot.model.CmUser;
import com.whh.spring.boot.service.CmUserService;
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
}
