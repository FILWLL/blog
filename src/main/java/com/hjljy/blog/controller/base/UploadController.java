package com.hjljy.blog.controller.base;

import com.hjljy.blog.common.AjaxJson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: HJLJY
 * @Date: 2018/12/27 0027 10:32
 * @Description: 文件上传处理
 */
@RestController
@RequestMapping("/upload")
public class UploadController extends BaseController {

    @Value("${hjljy-upload-path}")
    private  String uploadPath;

    @PostMapping("/upload1")
    public AjaxJson upload1(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        File targetFile = new File(uploadPath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        try {
            FileOutputStream out = new FileOutputStream(uploadPath + file.getOriginalFilename());
            out.write(file.getBytes());
            out.flush();
            out.close();
        } catch (IOException e) {
            logger.error("文件上传错误："+e.getMessage());
        }
        AjaxJson ajaxJson = new AjaxJson();
        HashMap<String,String> list =new HashMap<>();
        list.put("src", "/files/"+file.getOriginalFilename());
        ajaxJson.setSuccessData(list);
        return ajaxJson;
    }
}
