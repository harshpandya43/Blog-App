package com.harsh.blog.blogapp.service.impl;

import com.harsh.blog.blogapp.entity.Post;
import com.harsh.blog.blogapp.payload.PostDTO;
import com.harsh.blog.blogapp.repository.PostRepository;
import com.harsh.blog.blogapp.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
//        Convert DTO to entity
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setDescription(postDTO.getDescription());

        Post newPost = postRepository.save(post);

//        Convert Entity to DTO
        PostDTO postReponse = new PostDTO();
        postReponse.setId(newPost.getId());
        postReponse.setDescription(newPost.getDescription());
        postReponse.setContent(newPost.getContent());

        return postReponse;
    }
}
