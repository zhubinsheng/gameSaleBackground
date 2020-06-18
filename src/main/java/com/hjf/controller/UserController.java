package com.hjf.controller;

import com.hjf.entity.Userinfo;
import com.hjf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Map;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;



    /**
     * 用户的登陆
     * @return
     */
    @PostMapping("/ulogin")
    @ResponseBody
    public Userinfo login(@RequestBody Userinfo user){
        Userinfo userinfo= userService.login(user.getUserinfoName(),user.getUserinfoPwd());
        if(userinfo == null){
            System.out.println("用户名或密码错误，登录失败！");
            return null;
        }else {
            //request.getSession().setAttribute("session_user",userinfo);
            System.out.println("登陆成功");
            return userinfo;
        }
    }

    /**
     * 注册
     * @return
     */
    @PostMapping("/register")
    @ResponseBody
    public String register(@RequestBody Userinfo user){
        int res = userService.register(user.getUserinfoName(),user.getUserinfoPwd());
        if(res == 0){
            System.out.println("注册失败");
            return "error";
        }else {
            System.out.println("注册成功");
            return "success";
        }
    }

    /**
     * 个人信息修改
     * @return
     */
    @PostMapping("/updateuser")
    @ResponseBody
    public String updateUser(@RequestBody Userinfo user){

        int res = userService.updateUser(user.getUserinfoImg(),user.getUserinfoName(),user.getUserinfoSex(),user.getUserinfoBirthday(),user.getUserinfoId());
        if(res == 0){
            System.out.println("修改用户失败");
            return "error";
        }else {
            System.out.println("修改用户成功");
            return "success";
        }
    }
    
    /**
     * 通过ID显示（查询）个人资料
     * @return
     */
    @PostMapping("/showuser")
    @ResponseBody
    public Userinfo showUser(@RequestBody Userinfo user){
        Userinfo show = userService.showUser(user.getUserinfoId());
        System.out.println("查询成功");
        return show;
    }

    /**
     * 修改密码
     * @return
     */
    @PostMapping("/updatepwd")
    @ResponseBody
    public String updatePwd(@RequestBody Userinfo user){
        int res = userService.updatePwd(user.getUserinfoPwd(),user.getUserinfoId());
        if(res == 0){
            System.out.println("修改密码失败");
            return "error";
        }else {
            System.out.println("修改密码成功");
            return "success";
        }
    }

    /**
     * 修改邮箱
     * @return
     */
    @PostMapping("/updateemail")
    @ResponseBody
    public String updateEmail(@RequestBody Userinfo user){
        int res = userService.updateEmail(user.getUserinfoEmail(),user.getUserinfoId());
        if(res == 0){
            System.out.println("修改邮箱失败");
            return "error";
        }else {
            System.out.println("修改邮箱成功");
            return "success";
        }
    }

    /**
     * 修改手机号
     * @return
     */
    @PostMapping("/updatephone")
    @ResponseBody
    public String updatePhone(@RequestBody Userinfo user){
        int res = userService.updatePhone(user.getUserinfoPhone(),user.getUserinfoId());
        if(res == 0){
            System.out.println("修改手机失败");
            return "error";
        }else {
            System.out.println("修改手机成功");
            return "success";
        }
    }

//    /**
//     * 没有了
//     * 退出登陆
//     * @param request
//     * @param response
//     * @throws IOException
//     */
//    @PostMapping("/outUser")
//    public String outUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        request.getSession().removeAttribute("session_user");
//        return "login";
//    }

    /**
     * 显示所有用户信息
     * @return
     */
    @PostMapping("/showalluser")
    @ResponseBody
    public ArrayList<Userinfo> showAlluser(){

        ArrayList<Userinfo> showalluser = userService.showAllUser();

        System.out.println("查询所有用户成功");
        return showalluser;

    }

    /**
     * 模糊查询
     * @return
     */
    @PostMapping("/showlike")
    @ResponseBody
    public ArrayList<Userinfo> showLike(@RequestBody Userinfo userinfo){
        ArrayList<Userinfo> showLike = userService.showLike(userinfo.getUserinfoName());
        System.out.println("模糊查询成功");
        return showLike;
    }

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    @PostMapping("/insertuser")
    @ResponseBody
    public String insertUser(@RequestBody Userinfo user){
        int res = userService.insertUser(user.getUserinfoName(),user.getUserinfoPwd(),user.getUserinfoEmail(),
                user.getUserinfoPhone(),user.getUserinfoSex(),user.getUserinfoBirthday(),user.getUserinfoImg());
        if(res == 0){
            System.out.println("添加用户失败");
            return "error";
        }else {
            System.out.println("添加用户成功");
            return "success";
        }
    }


    /**
     * 删除用户
     * @param user
     * @return
     */
    @PostMapping("/deleteuser")
    @ResponseBody
    public String deleteUser(@RequestBody Userinfo user){
        int res = userService.deleteUser(user.getUserinfoId());
        if(res == 0){
            System.out.println("删除用户失败");
            return "error";
        }else {
            System.out.println("删除用户成功");
            return "success";
        }
    }


    /**
     * 返回各性别人数
     * @return
     */
    @PostMapping("/getsex")
    @ResponseBody
    public Map getSex(){
        Map showsex = userService.getSex();
        System.out.println("返回各性别数量");
        return showsex;
    }

    /**
     * 返回各年龄段人数
     * @return
     */
    @PostMapping("/getage")
    @ResponseBody
    public Map getAge(){
        Map showage = userService.getAge();
        System.out.println("返回各年龄段人数");
        return showage;

    }

    /**
     * 注册时用户名是否重复
     * @param user
     * @return
     */
    @PostMapping("/duplicate")
    @ResponseBody
    public String Duplicate(@RequestBody Userinfo user){
        Userinfo usercount = userService.duplicate(user.getUserinfoName());
        if(usercount==null){
            System.out.println("用户名未被使用");
            return "success";
        }else {
            System.out.println("用户名重复");
            return "error";
        }
    }

    /**
     * 通过用户名返回用户ID
     * @param user
     * @return
     */
    @PostMapping("/getuserid")
    @ResponseBody
    public Userinfo getUserId(@RequestBody Userinfo user){
        Userinfo showuserid = userService.getUserId(user.getUserinfoName());
        System.out.println("返回个人ID");
        return showuserid;
    }

    /**
     * 通过用户名返回是否存在用户
     * @param user
     * @return
     */
    @PostMapping("/getuser")
    @ResponseBody
    public Userinfo getUser(@RequestBody Userinfo user){
        Userinfo exist = userService.getUser(user.getUserinfoName());
        if(exist==null){
            System.out.println("用户不存在");
            return null;
        }else {
            System.out.println("用户存在");
            return exist;
        }
    }

//    /**
//     * 通过用户是否存在
//     * @param user
//     * @return
//     */
//    @PostMapping("/userbol")
//    @ResponseBody
//    public Userinfo userol(@RequestBody Userinfo user){
//        Userinfo exist = userService.B(user.getUserinfoName());
//        if(exist==null){
//            System.out.println("用户不存在");
//            return null;
//        }else {
//            System.out.println("用户存在");
//            return exist;
//        }
//    }
}
