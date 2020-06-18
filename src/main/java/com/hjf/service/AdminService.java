package com.hjf.service;

import com.hjf.entity.Admin;

public interface AdminService {

    Admin login(String adminName, String adminPwd);

    Integer getId(String adminName);
}
