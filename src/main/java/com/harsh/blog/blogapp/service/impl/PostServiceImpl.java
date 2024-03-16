package com.harsh.blog.blogapp.service.impl;

import com.harsh.blog.blogapp.entity.Post;
import com.harsh.blog.blogapp.exception.ResourceNotFoundException;
import com.harsh.blog.blogapp.payload.PostDTO;
import com.harsh.blog.blogapp.payload.PostResponse;
import com.harsh.blog.blogapp.repository.PostRepository;
import com.harsh.blog.blogapp.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        PostDTO postResponse = mapToDTO(newPost);
        return postResponse;
    }

    @Override
    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy) {

//        create pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Post> posts = postRepository.findAll(pageable);

//        get content from page object
        List<Post> listOfPosts = posts.getContent();

        List<PostDTO> content = listOfPosts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());
        PostResponse postResponse = new PostResponse();
        postResponse.setContent(content);
        postResponse.setPageNo(posts.getNumber());
        postResponse.setPageSize(posts.getSize());
        postResponse.setTotalPages(posts.getTotalPages());
        postResponse.setLast(posts.isLast());
        return postResponse;
    }

    @Override
    public PostDTO getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        PostDTO postDTO = mapToDTO(post);
        return postDTO;
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        post.setContent(postDTO.getContent());
        post.setTitle(postDTO.getTitle());
        post.setDescription(post.getDescription());

        Post updatedPost = postRepository.save(post);

        return mapToDTO(updatedPost);
    }

    @Override
    public void deletePost(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        postRepository.delete(post);

    }

    private Post mapToEntity(PostDTO postDTO) {
        Post post = new Post();

        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setDescription(postDTO.getDescription());

        return post;
    }

    //    convert Entity to DTO
    private PostDTO mapToDTO(Post post) {
        PostDTO postDTO = new PostDTO();

        postDTO.setTitle(post.getTitle());
        postDTO.setId(post.getId());
        postDTO.setContent(post.getContent());
        postDTO.setDescription(post.getDescription());

        return postDTO;
    }


}
