package com.whh.spring.boot.controller;

import com.whh.spring.boot.model.CmUser;
import com.whh.spring.boot.service.CmUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class CmUserController {

    @Resource
    private CmUserService cmUserService;

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public List<CmUser> getUsers() {
        return cmUserService.getUsers();
    }
}
