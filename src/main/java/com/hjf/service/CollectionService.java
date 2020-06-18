package com.hjf.service;

import com.hjf.entity.Collection;

import java.math.BigDecimal;
import java.util.ArrayList;

public interface CollectionService {

    ArrayList<Collection> showCollection(Integer collectionUserid);

    int insertCollection(String collectionName, BigDecimal collectionPrice,
                         String collectionImg, Integer collectionGameid, Integer collectionUserid);

    int deleteCollection(Integer collectionGameid, Integer collectionUserid);

    Collection showCollect(Integer collectionGameid, Integer collectionUserid);

    int deleteCollect(String collectionName, Integer collectionUserid);
}
