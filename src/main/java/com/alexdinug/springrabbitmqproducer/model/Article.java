package com.alexdinug.springrabbitmqproducer.model;

import lombok.Data;

import java.util.List;

@Data
public class Article {
    private String article;
    private List<Comment> comments;
}
