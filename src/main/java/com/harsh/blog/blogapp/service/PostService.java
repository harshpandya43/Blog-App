package com.harsh.blog.blogapp.service;

import com.harsh.blog.blogapp.payload.PostDTO;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostDTO postDTO);
    List<PostDTO> getAllPosts();
    PostDTO getPostById(long id);
}
