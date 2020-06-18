package com.hjf.dao;

import com.hjf.entity.Collection;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;

@Repository
public interface CollectionDao {

    ArrayList<Collection> showCollectionPro(@RequestParam("collectionUserid") Integer collectionUserid);

    int insertCollectionPro(@RequestParam("collectionName") String collectionName,
                            @RequestParam("collectionPrice") BigDecimal collectionPrice,
                            @RequestParam("collectionImg") String collectionImg,
                            @RequestParam("collectionGameid") Integer collectionGameid,
                            @RequestParam("collectionUserid") Integer collectionUserid);

    int deleteCollectionPro(@RequestParam("collectionGameid") Integer collectionGameid,
                            @RequestParam("collectionUserid") Integer collectionUserid);

    Collection showCollectPro(@RequestParam("collectionGameid") Integer collectionGameid,
                              @RequestParam("collectionGameid") Integer collectionUserid);

    int deleteCollect(@RequestParam("collectionName") String collectionName,
                      @RequestParam("collectionUserid") Integer collectionUserid);
}
