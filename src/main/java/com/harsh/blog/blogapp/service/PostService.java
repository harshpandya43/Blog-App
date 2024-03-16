package com.harsh.blog.blogapp.service;

import com.harsh.blog.blogapp.payload.PostDTO;

public interface PostService {
    PostDTO createPost(PostDTO postDTO);
}
