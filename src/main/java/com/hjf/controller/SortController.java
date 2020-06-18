package com.hjf.controller;

import com.hjf.entity.Sort;
import com.hjf.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/sort")
public class SortController {
    @Autowired
    private SortService sortService;

    /**
     * 显示所有分类
     * @return
     */
    @PostMapping("/showsort")
    @ResponseBody
    public ArrayList<Sort> showSort(){
        ArrayList<Sort> showsort =  sortService.showSort();
        System.out.println("显示所有分类");
        return showsort;

    }

    /**
     * 管理员添加分类
     * @return
     */
    @PostMapping("/insertsort")
    @ResponseBody
    public String insertSort(@RequestBody Sort sort){
        int res = sortService.insertSort(sort.getSortName(),sort.getSortCount());
        if(res == 0){
            System.out.println("添加分类失败");
            return "error";
        }else {
            System.out.println("添加分类成功");
            return "success";
        }
    }

    /**
     * 管理员添加分类
     * @return
     */
    @PostMapping("/deletesort")
    @ResponseBody
    public String deleteSort(@RequestBody Sort sort){
        int res = sortService.deleteSort(sort.getSortId());
        if(res == 0){
            System.out.println("删除分类失败");
            return "error";
        }else {
            System.out.println("删除分类成功");
            return "success";
        }
    }



}
