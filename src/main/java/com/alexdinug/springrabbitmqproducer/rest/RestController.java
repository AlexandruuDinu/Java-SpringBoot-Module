package com.alexdinug.springrabbitmqproducer.rest;

import com.alexdinug.springrabbitmqproducer.model.Article;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private RabbitTemplate template;

    @PostMapping("/consume")
    public ResponseEntity<Article> consume(@RequestBody List<Article> articles) {
        var articlesSize = articles.size();
        System.out.println(articlesSize);
        return ResponseEntity.ok().body(articles.get(0));

        //TODO: read from rabbit

        //TODO: add to db
    }
}
