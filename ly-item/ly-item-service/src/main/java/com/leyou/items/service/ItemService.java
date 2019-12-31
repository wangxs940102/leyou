package com.leyou.items.service;

import com.leyou.items.pojo.Items;
import org.springframework.stereotype.Service;


@Service
public class ItemService {

    public Items insertItem(Items items){
        int i = (int) Math.random() * 100;
        items.setId(i);
        items.setName("手机");
        items.setPrice(899.0);
        return items;
    }

}
