package com.harsh.blog.blogapp.controller;

import com.harsh.blog.blogapp.payload.PostDTO;
import com.harsh.blog.blogapp.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //    create blog post
    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO) {
        return new ResponseEntity<>(postService.createPost(postDTO), HttpStatus.CREATED);
    }

    //    get all posts
    @GetMapping
    public List<PostDTO> getAllPosts() {
        return postService.getAllPosts();
    }

//    get post by id
    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable(name="id") long id){
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }
}
