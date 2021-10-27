package com.example.controller;

import com.example.util.JsonParseUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author zhaodaming
 * @description:
 * @date 10/26/21
 */
@RestController
public class JsonParseController {

    @PostMapping("/unzipByteString")
    public String unzipByteString(@RequestParam("byteString") String byteString) {
        try {
            return JsonParseUtil.unzipString(byteString);
        } catch (Exception e) {
            e.printStackTrace();
            return "无法解析输入的内容";
        }
    }
}
