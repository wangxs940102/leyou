package com.leyou.item.web;

import com.leyou.item.pojo.Brand;
import com.leyou.item.service.BrandService;
import com.leyou.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://manage.leyou.com")
@RestController
@RequestMapping("brand")
public class BrandController {

    @Autowired
    private BrandService brandService;



    /**
     * defaultValue默认值
     * required表示是否必须，默认值为true
     * page当前页
     * rows当前页面展示条数
     * sortBy排序字段
     * desc是否排序
     * key搜索关键字
     */
    @GetMapping("/page")
    public ResponseEntity<PageResult<Brand>> queryBrandListByPid(@RequestParam(name = "page",defaultValue = "1") Integer page,
                                                                 @RequestParam(name ="rows",defaultValue = "10") Integer rows,
                                                                 @RequestParam(name ="sortBy",required = false) String sortBy,
                                                                 @RequestParam(name ="desc",required = false) Boolean desc,
                                                                 @RequestParam(name ="key",required = false)  String key) {
        return ResponseEntity.ok(brandService.queryBrandListByPid(page,rows,sortBy,desc,key));
    }

    /**
     * 新增品牌
     * @param brand
     * @param cids
     * @return
     */
    @PostMapping
    public ResponseEntity<Void> saveBrand(Brand brand,@RequestParam("cids") List<Long> cids){
        /**
         * 操作成功不返回信息
         */
        brandService.saveBrand(brand,cids);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
