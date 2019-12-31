package com.leyou.items.web;

import com.leyou.items.pojo.Items;
import com.leyou.items.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<Items> insertItem(Items items){
        if(items.getPrice() == null){
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        ResponseEntity<Items> itemsResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(itemService.insertItem(items));
        return itemsResponseEntity;
    }
}
