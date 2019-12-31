package com.leyou.items.service;

import com.leyou.items.pojo.Items;
import org.springframework.stereotype.Service;


@Service
public class ItemService {

    public Items saveItem(Items items){
        int i = (int) Math.random() * 100;
        items.setId(i);
        items.setName(items.getName());
        items.setPrice(items.getPrice());
        return items;
    }

}
