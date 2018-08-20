package com.jxedu.controller;

import com.jxedu.commons.Result;
import com.jxedu.entity.Person;
import com.jxedu.service.PersonService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Controller
public class HelloController {

    @Autowired
    private PersonService personService;

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @PostConstruct
    public void init() {

        logger.debug("HelloController初始化了。。。。");
    }

    @GetMapping("/index.html")
    public String index(ModelMap map) {

        List<Person> persons = personService.findPerson();

        map.put("persons", persons);


        return "index";
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Result> getPerson(@PathVariable("id") Long personId) {

        Person person = personService.findPersonById(personId);

        return ResponseEntity.ok(new Result("200", person));
    }

    @PostMapping("/person")
    public ResponseEntity<Result> saveperson(Person person) {

        personService.savePerson(person);

        return ResponseEntity.ok(new Result("200", person));
    }

    @PostMapping("/form")
    public void  handleFormUpload(
            @RequestPart("file") MultipartFile multipartFile) {


        String name = multipartFile.getOriginalFilename();

        Path path = new File(RandomStringUtils.randomNumeric(6)+name.substring(name.lastIndexOf("."),name.length())).toPath();
        try {
            Files.copy(multipartFile.getInputStream(),path);
        } catch (IOException e) {
            logger.error("上传失败：{}", e);
        }

    }

    @GetMapping("/java8")
    @ResponseBody
    public String java8expample(@RequestParam("name")Optional<String> optional){

        return optional.orElse("原来是空的");
    }

    @GetMapping("/data")
    @ResponseBody
    public Object data(@RequestParam("date")@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Optional<LocalDateTime> localDateTime){

        return localDateTime.orElse(LocalDateTime.now().plusDays(1));
    }
}