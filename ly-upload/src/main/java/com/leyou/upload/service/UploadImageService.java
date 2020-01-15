package com.leyou.upload.service;

import com.leyou.exceptionenum.ExceptionEnum;
import com.leyou.excetion.CustomException;
import com.leyou.upload.mapper.UploadImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UploadImageService {

    private static final List<String> imageType = Arrays.asList("image/png", "image/jpeg", "image/bmp");
    /**
     * 上传图片
     * @param file
     * @return
     * @author wangxs
     */
    public String uploadImage(MultipartFile file){
        /**
         * 1.校验文件类型
         * 2.判断文件内容（上传文件是否未图片）
         * 3.返回文件上传路径
         */
        String fileContentType = file.getContentType(); //获取文件类型
        if (!imageType.contains(fileContentType)){  //判断上传文件类型是否存在
            throw new CustomException(ExceptionEnum.IMAGE_NOT_FOUND_TYPE);
        }

        /**
         * BufferedImage是带数据缓冲区的图像类
         * BufferedImage生成的图片在内存里有一个图像缓冲区，
         * 利用这个缓冲区我们可以很方便的操作这个图片，通常用来做图片修改操作如大小变换、图片变灰、
         * 设置图片透明或不透明等
         * 读取一幅图像到图像缓冲区
         */

        BufferedImage bufferedImage = null;

        try {
            //将图片读取到图片缓冲区
            bufferedImage = ImageIO.read(file.getInputStream());
        } catch (IOException e) {
            throw new CustomException(ExceptionEnum.IMAGE_NOT_FOUND_TYPE);
        }
        //判断图片缓冲区中是否放入图片
        if(bufferedImage == null){
            throw new CustomException(ExceptionEnum.IMAGE_NOT_FOUND_TYPE);
        }


        return "";
    }
}
