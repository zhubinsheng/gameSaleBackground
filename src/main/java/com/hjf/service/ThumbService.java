package com.hjf.service;

import com.hjf.entity.PUthumb;

public interface ThumbService {

    PUthumb puThumbol(Integer puthumbPostid, Integer puthumbUserid);

    int addThumb(Integer puthumbPostid, Integer puthumbUserid);

}
