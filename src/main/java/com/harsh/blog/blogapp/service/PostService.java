package com.harsh.blog.blogapp.service;

import com.harsh.blog.blogapp.payload.PostDTO;
import com.harsh.blog.blogapp.payload.PostResponse;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostDTO postDTO);

    PostResponse getAllPosts(int pageNo, int pageSize);

    PostDTO getPostById(long id);

    PostDTO updatePost(PostDTO postDTO, long id);

    void deletePost(long id);
}
