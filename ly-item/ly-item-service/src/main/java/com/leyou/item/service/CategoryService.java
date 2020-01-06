package com.leyou.item.service;

import com.leyou.exceptionenum.ExceptionEnum;
import com.leyou.excetion.CustomException;
import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> queryCategoryListByPid(Long pid){
        Category category = new Category();
        category.setParentId(pid);


        List<Category> categoryList = categoryMapper.select(category);

        /**
         * java中判断集合是否为空得工具类
         */
        if(CollectionUtils.isEmpty(categoryList)){
            throw new CustomException(ExceptionEnum.Exception_Categroy_Not_Find);
        }
        return categoryList;
    }

}
