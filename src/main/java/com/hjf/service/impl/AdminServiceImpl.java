package com.hjf.service.impl;

import com.hjf.dao.AdminDao;
import com.hjf.entity.Admin;
import com.hjf.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin login(String adminName, String adminPwd) {
        return adminDao.loginPro(adminName,adminPwd);
    }

    @Override
    public Integer getId(String adminName) {
        return adminDao.getIdPro(adminName);
    }
}
