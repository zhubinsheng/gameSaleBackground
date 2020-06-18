package com.hjf.dao;

import com.hjf.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface AdminDao {

    Admin loginPro(@RequestParam("adminName") String adminName, @RequestParam("adminPwd") String adminPwd);

    Integer getIdPro(@RequestParam("adminName") String adminName);
}
