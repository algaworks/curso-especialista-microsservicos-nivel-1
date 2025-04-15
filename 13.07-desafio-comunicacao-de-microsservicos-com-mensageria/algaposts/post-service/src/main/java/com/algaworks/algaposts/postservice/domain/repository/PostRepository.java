package com.algaworks.algaposts.postservice.domain.repository;

import com.algaworks.algaposts.postservice.domain.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {}
