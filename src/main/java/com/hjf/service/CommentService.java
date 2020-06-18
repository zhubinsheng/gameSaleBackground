package com.hjf.service;

import com.hjf.entity.Comment;

import java.util.ArrayList;

public interface CommentService {
    ArrayList<Comment> showAllcomment();

    int deleteComment(Integer commentId);

    ArrayList<Comment> showComment(Integer commentUserid);

    int insertComment(String commentPostname,String commentUserimg,String commentContent,
                      Integer commentUserid,Integer commentPostid);

    ArrayList<Comment> showLike(String commentPostname);
}
