package com.algaworks.algaposts.textprocessorservice.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostProcessingResult {
    private UUID postId;
    private Integer wordCount;
    private BigDecimal calculatedValue;
}