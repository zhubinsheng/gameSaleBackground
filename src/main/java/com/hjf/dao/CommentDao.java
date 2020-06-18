package com.hjf.dao;

import com.hjf.entity.Comment;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Repository
public interface CommentDao {
    ArrayList<Comment> showAllcommentPro();

    int deleteCommentPro(@RequestParam("commentId") Integer commentId);

    ArrayList<Comment> showCommentPro(@RequestParam("commentUserid") Integer commentUserid);

    int insertCommentPro(@RequestParam("commentPostname") String commentPostname,
                         @RequestParam("commentUserimg") String commentUserimg,
                         @RequestParam("commentContent") String commentContent,
                         @RequestParam("commentUserid") Integer commentUserid,
                         @RequestParam("commentPostid") Integer commentPostid);

    void updateCommonsPro(@RequestParam("commentPostid") Integer commentPostid);

    Comment getPost(@RequestParam("commentId") Integer commentId);

    void updatePostommons(@RequestParam("commentPostid") Integer commentPostid);

    ArrayList<Comment> showLikePro(@RequestParam("commentPostname") String commentPostname);
}
