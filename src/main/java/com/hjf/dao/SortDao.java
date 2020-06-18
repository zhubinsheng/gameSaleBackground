package com.hjf.dao;

import com.hjf.entity.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Repository
public interface SortDao {
    ArrayList<Sort> showSortPro();

    int insertSortPro(@RequestParam("sortName") String sortName,
                      @RequestParam("sortCount") Integer sortCount);

    int deleteSort(@RequestParam("sortId") Integer sortId);
}
