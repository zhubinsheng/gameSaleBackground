package com.hjf.controller;

import com.hjf.entity.CUthumb;
import com.hjf.entity.PUthumb;
import com.hjf.service.ThumbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/thumb")
public class ThumbController {

    @Autowired
    private ThumbService thumbService;

    /**
     * 判断帖子是否点赞
     * @return
     */
    @PostMapping("/puthumbol")
    @ResponseBody
    public String puThumbol(@RequestBody PUthumb pUthumb){
        PUthumb bol = thumbService.puThumbol(pUthumb.getPuthumbPostid(),pUthumb.getPuthumbUserid());
        if(bol == null){
            System.out.println("没有点赞过");
            return "success";
        }else {
            System.out.println("已经点赞了");
            return "error";
        }
    }

    /**
     * 添加帖子点赞
     * @return
     */
    @PostMapping("/addthumb")
    @ResponseBody
    public String addThumb(@RequestBody PUthumb pUthumb){
        int res = thumbService.addThumb(pUthumb.getPuthumbPostid(),pUthumb.getPuthumbUserid());
        if(res == 0){
            System.out.println("点赞失败");
            return "error";
        }else {
            System.out.println("点赞成功");
            return "success";
        }
    }

}
