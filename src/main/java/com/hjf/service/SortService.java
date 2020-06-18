package com.hjf.service;

import com.hjf.entity.Sort;

import java.util.ArrayList;

public interface SortService {
    ArrayList<Sort> showSort();

    int insertSort(String sortName,Integer sortCount);

    int deleteSort(Integer sortId);
}
