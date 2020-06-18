package com.hjf.controller;

import com.hjf.entity.Comment;
import com.hjf.entity.Game;
import com.hjf.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 显示所有评论
     * @return
     */
    @PostMapping("/showallcomment")
    @ResponseBody
    public ArrayList<Comment> showAllcomment(){
        ArrayList<Comment> showAllcomment =  commentService.showAllcomment();
        System.out.println("显示所有评论");
        return showAllcomment;
    }

    /**
     * 显示个人评论
     * @return
     */
    @PostMapping("/showcomment")
    @ResponseBody
    public ArrayList<Comment> showComment(@RequestBody Comment comment){
        ArrayList<Comment> showcomment =  commentService.showComment(comment.getCommentUserid());
        System.out.println("显示个人评论");
        return showcomment;
    }

    /**
     * 模糊查询
     * @return
     */
    @PostMapping("/showlike")
    @ResponseBody
    public ArrayList<Comment> showLike(@RequestBody Comment comment){
        ArrayList<Comment> showLike = commentService.showLike(comment.getCommentPostname());
        System.out.println("模糊查询成功");
        return showLike;
    }

    /**
     * 删除评论
     * @param comment
     * @return
     */
    @PostMapping("/deletecomment")
    @ResponseBody
    public String deleteComment(@RequestBody Comment comment){

        int res =  commentService.deleteComment(comment.getCommentId());
        if(res == 0){
            System.out.println("删除评论失败");
            return "error";
        }else {
            System.out.println("删除评论成功");
            return "success";
        }
    }

    /**
     * 添加评论
     * @param comment
     * @return
     */
    @PostMapping("/insertcomment")
    @ResponseBody
    public String insertComment(@RequestBody Comment comment){
        int res =  commentService.insertComment(comment.getCommentPostname(),comment.getCommentUserimg(),
                comment.getCommentContent(),comment.getCommentUserid(),comment.getCommentPostid());
        if(res == 0){
            System.out.println("添加评论失败");
            return "error";
        }else {
            System.out.println("添加评论成功");
            return "success";
        }
    }


}
