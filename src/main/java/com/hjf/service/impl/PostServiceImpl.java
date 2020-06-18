package com.hjf.service.impl;

import com.hjf.dao.PostDao;
import com.hjf.entity.CommentAndUser;
import com.hjf.entity.Post;
import com.hjf.entity.PostAndUser;
import com.hjf.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Override
    public ArrayList<Post> showAllpost() {
        return postDao.showAllpostPro();
    }

    @Override
    public int insertPost(String postTitle, String postContent, Integer postThumbs,
                          Integer postUserid, String postUsername, Integer postCommons ) {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("用户创建时间：" + dateFormat.format(date));
        String postTime =  dateFormat.format(date);
        return postDao.insertPostPro(postTitle,postContent,postTime,postThumbs,postUserid,postUsername,postCommons);
    }

    @Override
    public int deletePost(Integer postId) {
        return postDao.deletePostPro(postId);
    }

    @Override
    public ArrayList<Post> showPost(Integer postUserid) {
        return postDao.showPostPro(postUserid);
    }

    @Override
    public ArrayList<PostAndUser> showNowpost() {
        return postDao.showNowpostPro();
    }

    @Override
    public ArrayList<PostAndUser> showHotpost() {
        return postDao.showHotpostPro();
    }

    @Override
    public PostAndUser showPostdetail(Integer postId) {
        return postDao.showPostdetailPro(postId);
    }

    @Override
    public ArrayList<CommentAndUser> showPostcommon(Integer commentPostid) {
        return postDao.showPostcommonPro(commentPostid);
    }

    @Override
    public ArrayList<Post> showLike(String postTitle) {
        return postDao.showLikePro(postTitle);
    }


}
