package com.fileservice.demo.service.demo.controller;

import com.fileservice.demo.service.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {
    @Autowired
    FileService fileService;



    @GetMapping("/read-file")
    public String readFile(@RequestParam("path") String filePath) {
        fileService.readFileAndSendToQueue(filePath);
        return "File reading started";
    }
}