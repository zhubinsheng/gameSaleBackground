package com.hjf.service.impl;

import com.hjf.dao.ThumbDao;
import com.hjf.entity.PUthumb;
import com.hjf.service.ThumbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThumbServiceImpl implements ThumbService {

    @Autowired
    private ThumbDao thumbDao;

    @Override
    public PUthumb puThumbol(Integer puthumbPostid, Integer puthumbUserid) {
        return thumbDao.puThumbolPro(puthumbPostid,puthumbUserid);
    }

    @Override
    public int addThumb(Integer puthumbPostid, Integer puthumbUserid) {
        int bol = thumbDao.addThumbPro(puthumbPostid,puthumbUserid);
        if(bol!=0) {
            thumbDao.updateThumbPro(puthumbPostid);
            return bol;
        }else {
            return bol;
        }
    }

}
