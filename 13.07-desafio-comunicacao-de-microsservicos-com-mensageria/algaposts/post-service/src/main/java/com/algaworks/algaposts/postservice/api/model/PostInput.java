package com.algaworks.algaposts.postservice.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostInput {
    private String title;
    private String body;
    private String author;
}
