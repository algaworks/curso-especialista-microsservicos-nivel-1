package com.algaworks.algacomments.comment.api.client;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class ModerationClientBadGatewayException extends RuntimeException {
}
