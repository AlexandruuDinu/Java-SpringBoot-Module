package com.alexdinug.springrabbitmqproducer.model;

import lombok.Data;

@Data
public class Comment {
    private String text;
    private String author;
}
