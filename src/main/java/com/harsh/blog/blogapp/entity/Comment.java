package com.harsh.blog.blogapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //    If we don't use @Column annotation, the JPA uses the field name as column names
    private String name;
    private String email;
    private String body;

//    The FetchType.LAZY tells Hibernate to only Fetch the related entities from the database when you use the relationship
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id") // This is a foreign key
    private Post post;

}
