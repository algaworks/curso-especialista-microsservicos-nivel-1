package com.algaworks.algacomments.comment.domain.exception;

public class ModerationRejectedException extends RuntimeException {
    public ModerationRejectedException(String message) {
        super(message);
    }
}