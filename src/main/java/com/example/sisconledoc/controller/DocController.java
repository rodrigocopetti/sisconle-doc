package com.example.sisconledoc.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.example.sisconledoc.service.DocService;



@Controller
public class DocController {

  @Autowired
  DocService service;

  @GetMapping("/")
  public String home(Model model) {
    return "home";
  }

  @PostMapping("/convert")
  String convert(@RequestParam String templatePath) {
    service.convert(templatePath);
    return "redirect:/";
  }


  @PostMapping(path = "/upload", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
  public String populate(@RequestPart MultipartFile document) {
    try {
      service.uploadTemplate(document);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "redirect:/";
  }



}