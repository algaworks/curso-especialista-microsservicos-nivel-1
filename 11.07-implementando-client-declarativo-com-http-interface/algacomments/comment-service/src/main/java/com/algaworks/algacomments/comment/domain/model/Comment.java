package com.algaworks.algacomments.comment.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {

    @Id
    @Builder.Default
    private UUID id = UUID.randomUUID();
    private String text;
    private String author;
    @Builder.Default
    private OffsetDateTime createdAt = OffsetDateTime.now();

}