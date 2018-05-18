package com.dongvv2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

@Controller
@RequestMapping("/uploadfile")
public class UploadFileDemoController {

    @Autowired
    ServletContext context;

    @GetMapping
    public String index() {
        return "themsanpham";
    }

    @PostMapping
    public String upload(MultipartHttpServletRequest request) {

        String pathSave = context.getRealPath("/resources/image/test/");
        Iterator<String> listNames = request.getFileNames();
        MultipartFile mpf = request.getFile(listNames.next());
        File file = new File(pathSave + mpf.getOriginalFilename());
        try {
            mpf.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "true";
    }

}
