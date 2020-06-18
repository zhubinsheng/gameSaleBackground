package com.hjf.controller;

import com.hjf.entity.Collection;
import com.hjf.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/collection")
public class CollectionController {

    @Autowired
    CollectionService collectionService;

    /**
     * 显示收藏夹中的商品
     * @return
     */
    @PostMapping("/showcollection")
    @ResponseBody
    public ArrayList<Collection> showCollection(@RequestBody Collection collection){
        ArrayList<Collection> show = collectionService.showCollection(collection.getCollectionUserid());
        System.out.println("查询收藏夹成功");
        return show;

    }

    /**
     * 显示收藏夹中某个商品
     * @return
     */
    @PostMapping("/showcollect")
    @ResponseBody
    public Collection showCollect(@RequestBody Collection collection){
        Collection showcollect = collectionService.showCollect(collection.getCollectionGameid(),collection.getCollectionUserid());
        System.out.println("查询收藏夹是否存在商品成功");
        return showcollect;

    }

    /**
     * 添加商品到收藏夹
     * @return
     */
    @PostMapping("/insertcollection")
    @ResponseBody
    public String insertCollection(@RequestBody Collection collection){
        int res = collectionService.insertCollection(collection.getCollectionName(),collection.getCollectionPrice(),
                collection.getCollectionImg(),collection.getCollectionGameid(),collection.getCollectionUserid());
        if(res == 0){
            System.out.println("添加商品到收藏夹失败");
            return "error";
        }else {
            System.out.println("添加商品到收藏夹成功");
            return "success";
        }
    }

    /**
     * 通过用户ID和游戏ID删除收藏夹中的商品
     * @return
     */
    @PostMapping("/deletecollection")
    @ResponseBody
    public String deleteCollection(@RequestBody Collection collection){
        int res = collectionService.deleteCollection(collection.getCollectionGameid(),collection.getCollectionUserid());
        if(res == 0){
            System.out.println("删除收藏夹中的商品失败");
            return "error";
        }else {
            System.out.println("删除收藏夹中的商品成功");
            return "success";
        }
    }

    /**
     * 通过用户ID和名字删除收藏夹中的商品
     * @return
     */
    @PostMapping("/deletecollect")
    @ResponseBody
    public String deleteCollect(@RequestBody Collection collection){
        int res = collectionService.deleteCollect(collection.getCollectionName(),collection.getCollectionUserid());
        if(res == 0){
            System.out.println("删除收藏夹中的商品失败");
            return "error";
        }else {
            System.out.println("删除收藏夹中的商品成功");
            return "success";
        }
    }

}
