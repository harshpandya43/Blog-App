package com.harsh.blog.blogapp.payload;

import lombok.Data;

//Data annotation generates all getters and setters for the DTO
@Data
public class PostDTO {
    private long id;
    private String title;
    private String description;
    private String content;

}
