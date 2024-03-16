package com.harsh.blog.blogapp.repository;

import com.harsh.blog.blogapp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
