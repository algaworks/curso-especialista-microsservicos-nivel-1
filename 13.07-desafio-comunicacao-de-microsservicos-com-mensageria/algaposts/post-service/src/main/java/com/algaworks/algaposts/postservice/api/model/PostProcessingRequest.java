package com.algaworks.algaposts.postservice.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostProcessingRequest {
    private UUID postId;
    private String postBody;
}
