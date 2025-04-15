package com.algaworks.algacomments.comment.domain.repository;

import com.algaworks.algacomments.comment.domain.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
}