package com.hjf.service.impl;

import com.hjf.dao.CollectionDao;
import com.hjf.entity.Collection;
import com.hjf.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;

@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    CollectionDao collectionDao;

    @Override
    public ArrayList<Collection> showCollection(Integer collectionUserid) {
        return collectionDao.showCollectionPro(collectionUserid);
    }

    @Override
    public int insertCollection(String collectionName, BigDecimal collectionPrice, String collectionImg,
                                Integer collectionGameid, Integer collectionUserid) {
        return collectionDao.insertCollectionPro(collectionName,collectionPrice,
                collectionImg,collectionGameid,collectionUserid);
    }

    @Override
    public int deleteCollection(Integer collectionGameid, Integer collectionUserid) {
        return collectionDao.deleteCollectionPro(collectionGameid,collectionUserid);
    }

    @Override
    public Collection showCollect(Integer collectionGameid, Integer collectionUserid) {
        return collectionDao.showCollectPro(collectionGameid,collectionUserid);
    }

    @Override
    public int deleteCollect(String collectionName, Integer collectionUserid) {
        return collectionDao.deleteCollect(collectionName,collectionUserid);
    }
}
