package com.hjf.dao;

import com.hjf.entity.PUthumb;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface ThumbDao {

    PUthumb puThumbolPro(@RequestParam("puthumbPostid") Integer puthumbPostid,
                       @RequestParam("puthumbUserid") Integer puthumbUserid);

    int addThumbPro(@RequestParam("puthumbPostid") Integer puthumbPostid,
                    @RequestParam("puthumbUserid") Integer puthumbUserid);

    void updateThumbPro(@RequestParam("puthumbPostid") Integer puthumbPostid);

}
