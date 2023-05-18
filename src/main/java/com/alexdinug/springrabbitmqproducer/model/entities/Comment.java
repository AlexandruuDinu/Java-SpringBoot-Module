package com.alexdinug.springrabbitmqproducer.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 3000000)
    private String text;
    private String author;
    @ManyToMany(mappedBy = "comments")
    private List<Article> articles;
}
