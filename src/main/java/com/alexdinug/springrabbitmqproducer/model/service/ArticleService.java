package com.alexdinug.springrabbitmqproducer.model.service;

import com.alexdinug.springrabbitmqproducer.model.entities.Article;
import com.alexdinug.springrabbitmqproducer.model.entities.Comment;
import com.alexdinug.springrabbitmqproducer.repository.ArticleRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository repository;

    public void saveToDb(List<Article> articles) {
        repository.saveAll(articles);
    }
}
