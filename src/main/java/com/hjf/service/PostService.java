package com.hjf.service;

import com.hjf.entity.CommentAndUser;
import com.hjf.entity.PUthumb;
import com.hjf.entity.Post;
import com.hjf.entity.PostAndUser;

import java.util.ArrayList;

public interface PostService {
    ArrayList<Post> showAllpost();

    int insertPost(String postTitle, String postContent,Integer postThumbs,
                    Integer postUserid, String postUsername,Integer postCommons);

    int deletePost(Integer postId);

    ArrayList<Post> showPost(Integer postUserid);

    ArrayList<PostAndUser> showNowpost();

    ArrayList<PostAndUser> showHotpost();

    PostAndUser showPostdetail(Integer postId);

    ArrayList<CommentAndUser> showPostcommon(Integer commentPostid);

    ArrayList<Post> showLike(String postTitle);

}
