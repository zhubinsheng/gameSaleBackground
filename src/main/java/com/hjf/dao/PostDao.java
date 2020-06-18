package com.hjf.dao;

import com.hjf.entity.CommentAndUser;
import com.hjf.entity.PUthumb;
import com.hjf.entity.Post;
import com.hjf.entity.PostAndUser;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Repository
public interface PostDao {
    ArrayList<Post> showAllpostPro();

    int insertPostPro(@RequestParam("postTitle") String postTitle,
                      @RequestParam("postContent") String postContent,
                      @RequestParam("postTime") String postTime,
                      @RequestParam("postThumbs") Integer postThumbs,
                      @RequestParam("postUserid") Integer postUserid,
                      @RequestParam("postUsername") String postUsername,
                      @RequestParam("postCommons") Integer postCommons);

    int deletePostPro(@RequestParam("postId") Integer postId);

    ArrayList<Post> showPostPro(@RequestParam("postUserid") Integer postUserid);

    ArrayList<PostAndUser> showNowpostPro();

    ArrayList<PostAndUser> showHotpostPro();

    PostAndUser showPostdetailPro(@RequestParam("postId") Integer postId);

    ArrayList<CommentAndUser> showPostcommonPro(@RequestParam("commentPostid") Integer commentPostid);


    ArrayList<Post> showLikePro(@RequestParam("postTitle") String postTitle);
}
