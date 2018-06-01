package com.whh.spring.boot.service.impl;

import com.whh.spring.boot.dao.CmUserMapper;
import com.whh.spring.boot.model.CmUser;
import com.whh.spring.boot.service.CmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmUserServiceImpl implements CmUserService {
    @Autowired
    private CmUserMapper cmUserMapper;

    @Override
    public List<CmUser> getUsers() {
        return cmUserMapper.selectUsers();
    }
}
