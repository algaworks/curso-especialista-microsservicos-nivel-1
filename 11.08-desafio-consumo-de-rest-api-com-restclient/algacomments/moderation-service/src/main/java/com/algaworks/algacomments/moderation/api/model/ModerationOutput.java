package com.algaworks.algacomments.moderation.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModerationOutput {
    private UUID commentId;
    private Boolean approved;
    private String reason;

    public boolean isApproved() {
        return Boolean.TRUE.equals(getApproved());
    }
}