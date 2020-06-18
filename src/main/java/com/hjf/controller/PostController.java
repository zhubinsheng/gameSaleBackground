package com.hjf.controller;

import com.hjf.entity.*;
import com.hjf.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    /**
     * 显示所有帖子
     * @return
     */
    @PostMapping("/showallpost")
    @ResponseBody
    public ArrayList<Post> showAllpost(){
        ArrayList<Post> showAllpost =  postService.showAllpost();
        System.out.println("显示所有帖子");
        return showAllpost;

    }

    /**
     * 按发帖时间排序的帖子
     * @return
     */
    @PostMapping("shownowpost")
    @ResponseBody
    public ArrayList<PostAndUser> showNowpost(){
        ArrayList<PostAndUser> shownowpost =  postService.showNowpost();
        System.out.println("显示时间顺序的帖子");
        return shownowpost;

    }

    /**
     * 按回复数排序的帖子
     * @return
     */
    @PostMapping("showhotpost")
    @ResponseBody
    public ArrayList<PostAndUser> showHotpost(){
        ArrayList<PostAndUser> showhotpost =  postService.showHotpost();
        System.out.println("按回复数排序的帖子");
        return showhotpost;

    }

    /**
     * 显示帖子界面的信息
     * @return
     */
    @PostMapping("showpostdetail")
    @ResponseBody
    public PostAndUser showPostdetail(@RequestBody PostAndUser postAndUser){
        PostAndUser showpostdetail =  postService.showPostdetail(postAndUser.getPostId());
        System.out.println("显示帖子界面的信息");
        return showpostdetail;

    }

    /**
     * 显示帖子界面所有评论的信息
     * @return
     */
    @PostMapping("showpostcommon")
    @ResponseBody
    public ArrayList<CommentAndUser> showPostcommon(@RequestBody CommentAndUser commentAndUser){
        ArrayList<CommentAndUser> showpostcommon =  postService.showPostcommon(commentAndUser.getCommentPostid());
        System.out.println("显示帖子界面所有评论的信息");
        return showpostcommon;

    }

    /**
     * 显示个人帖子
     * @return
     */
    @PostMapping("/showpost")
    @ResponseBody
    public ArrayList<Post> showPost(@RequestBody Post post){
        ArrayList<Post> showpost =  postService.showPost(post.getPostUserid());
        System.out.println("显示个人帖子");
        return showpost;
    }

    /**
     * 模糊查询
     * @return
     */
    @PostMapping("/showlike")
    @ResponseBody
    public ArrayList<Post> showLike(@RequestBody Post post){
        ArrayList<Post> showLike = postService.showLike(post.getPostTitle());
        System.out.println("模糊查询成功");
        return showLike;
    }

    /**
     * 管理员添加帖子
     * @param post
     * @return
     */
    @PostMapping("/insertpost")
    @ResponseBody
    public String insertPost(@RequestBody Post post){
        int res = postService.insertPost(post.getPostTitle(),post.getPostContent(),
                post.getPostThumbs(),post.getPostUserid(),post.getPostUsername(),post.getPostCommons());
        if(res == 0){
            System.out.println("添加帖子失败");
            return "error";
        }else {
            System.out.println("添加帖子成功");
            return "success";
        }
    }

    /**
     * 删除帖子
     * @param post
     * @return
     */
    @PostMapping("deletepost")
    @ResponseBody
    public String deletePost(@RequestBody Post post){
        int res = postService.deletePost(post.getPostId());
        if(res == 0){
            System.out.println("删除帖子失败");
            return "error";
        }else {
            System.out.println("删除帖子成功");
            return "success";
        }
    }
}
