package com.alexdinug.springrabbitmqproducer.rest;

import com.alexdinug.springrabbitmqproducer.model.entities.Article;
import com.alexdinug.springrabbitmqproducer.model.service.ArticleService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private ArticleService service;

    @PostMapping("/consume")
    public ResponseEntity<Article> consume(@RequestBody List<Article> articles) {
        service.saveToDb(articles);
        return ResponseEntity.ok().build();
    }

    //TODO: consume from rabbitmq and save to db

//    @RabbitListener(queues = "news_queue")
//    public void handleMessageFromRabbitMQ(@Payload List<Article> articles) throws SQLException {
//        service.saveToDb(articles);
//        System.out.println(articles);
//    }
}
