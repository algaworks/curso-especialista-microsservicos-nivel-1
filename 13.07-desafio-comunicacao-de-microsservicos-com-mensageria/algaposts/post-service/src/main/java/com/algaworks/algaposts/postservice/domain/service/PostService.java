package com.algaworks.algaposts.postservice.domain.service;

import com.algaworks.algaposts.postservice.api.model.*;
import com.algaworks.algaposts.postservice.domain.model.Post;
import com.algaworks.algaposts.postservice.domain.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.algaworks.algaposts.postservice.infrastructure.rabbitmq.RabbitConfig.POST_QUEUE;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final AmqpTemplate amqpTemplate;

    @Transactional
    public PostOutput create(PostInput input) {
        UUID id = UUID.randomUUID();
        Post post = new Post();
        post.setId(id);
        post.setTitle(input.getTitle());
        post.setBody(input.getBody());
        post.setAuthor(input.getAuthor());
        postRepository.saveAndFlush(post);

        amqpTemplate.convertAndSend(POST_QUEUE, new PostProcessingRequest(id, input.getBody()));

        return new PostOutput(id, post.getTitle(), post.getBody(),
                post.getAuthor(), null, null);
    }

    @Transactional
    public void updatePostInfo(PostProcessingResult result) {
        Post post = postRepository.findById(result.getPostId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        post.setWordCount(result.getWordCount());
        post.setCalculatedValue(result.getCalculatedValue());
        postRepository.save(post);
    }

    public PostOutput findById(UUID id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new PostOutput(post.getId(), post.getTitle(), post.getBody(), post.getAuthor(), post.getWordCount(), post.getCalculatedValue());
    }

    public PagedModel<PostSummaryOutput> list(Pageable pageable) {
        return new PagedModel<>(postRepository.findAll(pageable).map(post -> new PostSummaryOutput(
            post.getId(),
            post.getTitle(),
            summarize(post.getBody()),
            post.getAuthor()
        )));
    }

    private String summarize(String body) {
        return Arrays.stream(body.split("\\n")).limit(3).collect(Collectors.joining("\n"));
    }
}