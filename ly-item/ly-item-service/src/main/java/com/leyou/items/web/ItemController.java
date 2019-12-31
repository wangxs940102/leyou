package com.leyou.items.web;

import com.leyou.exceptionenum.ExceptionEnum;
import com.leyou.excetion.CustomException;
import com.leyou.items.pojo.Items;
import com.leyou.items.service.ItemService;
import com.leyou.vo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<Items> saveItem(Items items){
        if(items.getPrice() == null){
           throw new CustomException(ExceptionEnum.Exception_Price_Cannot_Be_null);
        }
        ResponseEntity<Items> itemsResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(itemService.saveItem(items));
        return itemsResponseEntity;
    }
}
