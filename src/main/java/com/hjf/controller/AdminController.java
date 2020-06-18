package com.hjf.controller;

import com.hjf.entity.Admin;
import com.hjf.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 管理员的登陆
     * @return
     */
    @PostMapping("/alogin")
    @ResponseBody
    public String login(@RequestBody Admin admin){
        Admin login = adminService.login(admin.getAdminName(),admin.getAdminPwd());
        if(login == null){

            System.out.println("用户名或密码错误，登录失败！");
            return "error";

        }else {
            System.out.println("登陆成功");
            return "success";
        }
    }

    @PostMapping("/getid")
    @ResponseBody
    public Integer getId(@RequestBody Admin admin){
        Integer id = adminService.getId(admin.getAdminName());

        if(id == null){
            System.out.println("获取用户名失败");
            return 0;
        }else {
            System.out.println("获取用户名成功");
            return id;
        }

    }

}
