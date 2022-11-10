package com.chao.controller;

import com.chao.common.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传和下载
 *
 * @author Eliot
 */
@RestController
@RequestMapping("/common")
public class CommonController {

    @Value("${reggie.path}")
    private String basePath;

    /**
     * 上传图片 <br/>
     * file是一个临时文件，需要转存到指定位置，否则本次请求完成后临时文件会删除<br/>
     * <p> 步骤：<br/>
     *     1---将MultipartFile后缀名取出 <br/>
     *     2---新建文件名=UUID生成文件名 + 后缀名<br/>
     *     3---创建目录，判断是否存在<br/>
     *     4---转存文件 transferTo<br/>
     * </p>
     * @param file 上传图片必要的MultipartFile对象
     * @return 返回任意，文件名即可
     */
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file){

        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

        String fileName = UUID.randomUUID() +suffix;

        File dir = new File(basePath);
        if(!dir.exists()){
            dir.mkdirs();
        }

        try {
            file.transferTo(new File(basePath+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.success(fileName);
    }

    /**
     * 文件下载<br/>
     * <p>
     *     步骤:<br/>
     *     1---新建输入流获取文件<br/>
     *     2---设置浏览器文本类型为"image/jpeg"<br/>
     *     3---新建输出流将文件写入浏览器(刷新)<br/>
     *     4---关闭流
     * </p>
     * @param name 网页url携带文件名参数
     * @param response 用于获取输出流
     */
    @GetMapping("/download")
    public void download(String name, HttpServletResponse response){
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(basePath+name));

            ServletOutputStream outputStream = response.getOutputStream();

            response.setContentType("image/jpeg");

            byte[] bytes = new byte[1024];
            int len;
            while ((len = fileInputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
                outputStream.flush();
            }
            fileInputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}











