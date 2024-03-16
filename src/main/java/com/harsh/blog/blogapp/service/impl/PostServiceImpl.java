package com.harsh.blog.blogapp.service.impl;

import com.harsh.blog.blogapp.entity.Post;
import com.harsh.blog.blogapp.payload.PostDTO;
import com.harsh.blog.blogapp.repository.PostRepository;
import com.harsh.blog.blogapp.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
//        Convert DTO to entity
        Post post = mapToEntity(postDTO);

        Post newPost = postRepository.save(post);

//        Convert Entity to DTO
        PostDTO postResponse = mapDTO(newPost);
        return postResponse;
    }

    @Override
    public List<PostDTO> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post -> mapDTO(post)).collect(Collectors.toList());
    }

    private Post mapToEntity(PostDTO postDTO) {
        Post post = new Post();

        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setDescription(postDTO.getDescription());

        return post;
    }

    //    convert Entity to DTO
    private PostDTO mapDTO(Post post) {
        PostDTO postDTO = new PostDTO();

        postDTO.setTitle(post.getTitle());
        postDTO.setId(post.getId());
        postDTO.setContent(post.getContent());
        postDTO.setDescription(post.getDescription());

        return postDTO;
    }


}
