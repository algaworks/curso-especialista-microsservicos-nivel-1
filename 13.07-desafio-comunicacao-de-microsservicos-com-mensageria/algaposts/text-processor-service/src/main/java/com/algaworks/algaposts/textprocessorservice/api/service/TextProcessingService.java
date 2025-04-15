package com.algaworks.algaposts.textprocessorservice.api.service;

import com.algaworks.algaposts.textprocessorservice.api.model.PostProcessingRequest;
import com.algaworks.algaposts.textprocessorservice.api.model.PostProcessingResult;
import com.algaworks.algaposts.textprocessorservice.infrastructure.rabbitmq.RabbitConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;

@Service
public class TextProcessingService {

    private final AmqpTemplate amqpTemplate;

    public TextProcessingService(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void receivePost(PostProcessingRequest request) {
        int words = countWords(request.getPostBody());
        BigDecimal value = new BigDecimal(words * 0.10);

        PostProcessingResult result = new PostProcessingResult(request.getPostId(), words, value);
        amqpTemplate.convertAndSend(RabbitConfig.RESULT_QUEUE, result);
    }

    private int countWords(String body) {
        return (int) Arrays.stream(body.trim().split("\\s+")).count();
    }
}