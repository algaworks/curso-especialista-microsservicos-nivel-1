package com.algaworks.algaposts.textprocessorservice.infrastructure.rabbitmq;

import com.algaworks.algaposts.textprocessorservice.api.model.PostProcessingRequest;
import com.algaworks.algaposts.textprocessorservice.api.service.TextProcessingService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitListenerConfig {

    private final TextProcessingService textProcessingService;

    @RabbitListener(queues = RabbitConfig.POST_QUEUE)
    public void consumeProcessing(@Payload PostProcessingRequest request) {
        textProcessingService.receivePost(request);
    }

}
