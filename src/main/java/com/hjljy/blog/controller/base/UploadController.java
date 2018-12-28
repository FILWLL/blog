package com.hjljy.blog.controller.base;

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
 * @Description: 文件上传
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

    @PostMapping("/upload1")
    public Map<String, Object> upload1(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IOException {
        String filename = file.getOriginalFilename();
        String filePath = request.getSession().getServletContext().getRealPath("/images/");
        System.out.println(filePath+ file.getOriginalFilename());
        File targetFile = new File("/var/uploaded_files/");
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream("/var/uploaded_files/" + "qwert1.png");
        out.write(file.getBytes());
        out.flush();
        out.close();

        Map<String, Object> result = new HashMap<>(16);
        HashMap<String,String> list =new HashMap<>();

        result.put("contentType", file.getContentType());
        result.put("code", "0");
        result.put("msg", "");
        result.put("data", list);
        result.put("fileName", file.getOriginalFilename());
        result.put("fileSize", file.getSize() + "");
        return result;
    }
}
