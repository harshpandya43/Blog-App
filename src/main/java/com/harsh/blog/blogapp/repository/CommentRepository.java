package com.harsh.blog.blogapp.repository;

import com.harsh.blog.blogapp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
