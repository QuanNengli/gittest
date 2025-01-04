package com.lzq.springmvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.util.UUID;

@Controller
public class FileController {
    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadFile(HttpServletResponse response, HttpServletRequest request) throws IOException {

        File file = new File(request.getServletContext().getRealPath("/upload") + "/9bca07ac-26cc-43f6-b297-773ea4f108a0.jpg");
        // 创建响应头对象
        HttpHeaders headers = new HttpHeaders();
        // 设置响应内容类型
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 设置下载文件的名称
        headers.setContentDispositionFormData("attachment", file.getName());

        // 下载文件
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(Files.readAllBytes(file.toPath()), headers, HttpStatus.OK);
        return entity;
    }
    @RequestMapping(value = "/file/up",method = RequestMethod.POST)
    public String up(@RequestParam("fileName") MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        System.out.println(multipartFile.getName());
        String originalFilename = multipartFile.getOriginalFilename();
        System.out.println(originalFilename);
        //获取输入流
        InputStream inputStream = multipartFile.getInputStream();
        BufferedInputStream in = new BufferedInputStream(inputStream);
        //获取上传后存放目录
        File file = new File(request.getServletContext().getRealPath("/upload"));
        //如果服务器目录不存在则新建
        if (!file.exists()) {
            file.mkdir();
        }
        //开始写文件
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file.getAbsolutePath() + "/" + UUID.randomUUID().toString()
                + originalFilename.substring(originalFilename.lastIndexOf("."))));
        byte[] bytes=new byte[1024*1024];
        int readCount=0;
        while ((readCount=in.read(bytes)) != -1){
            out.write(bytes,0,readCount);
        }
        //刷新缓冲流
        out.flush();
        //关闭流
        in.close();
        out.close();
        return "ok";
    }
}
