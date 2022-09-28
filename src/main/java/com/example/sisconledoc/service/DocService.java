package com.example.sisconledoc.service;

import java.io.IOException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.example.sisconledoc.configuration.AmpqConfig;
import com.example.sisconledoc.dto.DocTemplate;

@Service
public class DocService {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  RabbitTemplate rabbitTemplate;

  @Value("${gerador.url}")
  private String geradorUrl;

  public void convert(final String templatePath) {
    String url = String.format("%s/convert?templatePath=%s", geradorUrl, templatePath);
    ResponseEntity<String> result = restTemplate.postForEntity(url, null, String.class);
    System.out.println("result=======>" + result);
    sendTemplate(templatePath);
  }

  public void uploadTemplate(MultipartFile template) throws IOException {
    MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
    ByteArrayResource fileAsResource;
    fileAsResource = new ByteArrayResource(template.getBytes()) {
      @Override
      public String getFilename() {
        return template.getOriginalFilename();
      }
    };
    body.add("document", fileAsResource);
    HttpHeaders requestHeaders = new HttpHeaders();
    requestHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
    HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, requestHeaders);
    String url = String.format("%s/upload", geradorUrl);
    ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
    System.out.println("result=======>" + result);
  }

  public void sendTemplate(final String templatePath) {
    DocTemplate docTemplate = new DocTemplate();
    docTemplate.setTemplatePath(templatePath);
    rabbitTemplate.convertAndSend(AmpqConfig.QUEUE_TEMPLATE, docTemplate);
  }

  @RabbitListener(queues = AmpqConfig.QUEUE_GENERATED_DOC)
  public void generatedDocListener(DocTemplate docTemplate) {
    System.out.println("docTemplate.getDocPath()>>>>>>>>"+docTemplate.getDocPath());
  }

}
