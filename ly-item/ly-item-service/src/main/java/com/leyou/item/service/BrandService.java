package com.leyou.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.exceptionenum.ExceptionEnum;
import com.leyou.excetion.CustomException;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import com.leyou.vo.PageResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class BrandService {

    @Autowired
    private BrandMapper brandMapper;

    public PageResult<Brand> queryBrandListByPid(int page,int rows,String sortBy,Boolean desc,String key){
        /**
         * 1.分页
         * page当前页
         * rows每页显示得数量
         * 查询第page页，rows条数据，默认查询总条数count
         */
        PageHelper.startPage(page,rows);

        /**
         * 2.排序
         * 相当于select * from tb_brand order by ?
         */
        Example example = new Example(Brand.class);
        if (StringUtils.isNotBlank(sortBy)){
            example.setOrderByClause(sortBy+(desc? " DESC":" ASC"));
        }

        /**
         * 3.查询
         * 搜索：根据key关键字条件查询
         */


        if(StringUtils.isNotBlank(key)) {
            example.createCriteria().orLike("name", key +"%").orEqualTo("letter", key.toUpperCase());
        }

        List<Brand> list=this.brandMapper.selectByExample(example);

        /**
         * 判断查询是否查询到结果，如果未查询到结果则返回错误信息
         */

        if(CollectionUtils.isEmpty(list)){
            throw new CustomException(ExceptionEnum.EXCEPTION_Brand_IS_NULL);
        }

        /***
         * 4.创建PageInfo
         * 使用PageInfo对上面得结果进行封装
         */
        PageInfo<Brand> pageInfo = new PageInfo<>(list);

        /**
         * 5.返回分页结果
         */
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }

    /**
     * 新增品牌
     * @param brand
     * @param cids
     * @return
     */
    @Transactional
    public void saveBrand(Brand brand, List<Long> cids){

        int count = brandMapper.insert(brand);

        if(count != 1){
            throw new CustomException(ExceptionEnum.EXCEPTION_Save_Brand_Error);
        }

        for (Long cid : cids) {
          count =  brandMapper.saveCategoryAndBrand(cid,brand.getId());

            if(count != 1){
                throw new CustomException(ExceptionEnum.EXCEPTION_Save_Brand_Error);
            }
        }
    }
}
