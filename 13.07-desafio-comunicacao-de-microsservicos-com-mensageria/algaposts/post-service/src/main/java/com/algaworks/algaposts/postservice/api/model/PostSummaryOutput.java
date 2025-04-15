package com.algaworks.algaposts.postservice.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostSummaryOutput {
    private UUID id;
    private String title;
    private String summary;
    private String author;
}


