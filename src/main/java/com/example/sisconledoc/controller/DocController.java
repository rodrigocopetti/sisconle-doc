package com.example.sisconledoc.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.example.sisconledoc.dto.TemplateX;
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

  // @PostMapping(path = "/upload", consumes = {
  // MediaType.MULTIPART_FORM_DATA_VALUE })
  // public String populate(@RequestPart MultipartFile document, @RequestBody
  // TemplateX template) {

  @PostMapping(path = "/upload", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
  public String populate(@RequestPart MultipartFile document, @RequestPart String templateDir,
      @RequestPart String templateName) {
    try {
      service.uploadTemplate(document, templateDir, templateName);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "redirect:/";
  }

  /*
   * 
   * public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file")
   * MultipartFile file) {
   * String message = "";
   * try {
   * storageService.save(file);
   * 
   * message = "Uploaded the file successfully: " + file.getOriginalFilename();
   * return ResponseEntity.status(HttpStatus.OK).body(new
   * ResponseMessage(message));
   * } catch (Exception e) {
   * message = "Could not upload the file: " + file.getOriginalFilename() + "!";
   * return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new
   * ResponseMessage(message));
   * }
   * }
   * 
   */

}