package com.totemdb.pgm.controller;

import com.totemdb.pgm.entity.ResponseMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.totemdb.pgm.utils.AliOssUtil;

import static com.totemdb.pgm.entity.ResponseMessage.success;


@RestController
public class UploadController {

    @PostMapping("/upload")
    public ResponseMessage<String> upload(MultipartFile file) throws Exception {

        String Filename = file.getOriginalFilename();
        String url = AliOssUtil.uploadFile(Filename,file.getInputStream());
        return ResponseMessage.success(url);
    }
}
