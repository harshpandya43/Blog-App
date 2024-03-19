package com.harsh.blog.blogapp.service;

import com.harsh.blog.blogapp.payload.CommentDTO;

public interface CommentService {
    CommentDTO createComment(long postId, CommentDTO commentDTO);
}
