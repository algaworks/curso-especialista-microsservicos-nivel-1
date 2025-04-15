package com.algaworks.algacomments.moderation.domain.service;

import com.algaworks.algacomments.moderation.api.model.ModerationInput;
import com.algaworks.algacomments.moderation.api.model.ModerationOutput;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ModerationService {
    private static final List<String> BANNED_WORDS = List.of("ódio", "xingamento", "php");

    public ModerationOutput moderate(ModerationInput request) {
        String text = request.getText().toLowerCase();

        Set<String> bannedWordsFound = new HashSet<>();
        for (String word : BANNED_WORDS) {
            if (text.contains(word.toLowerCase())) {
                bannedWordsFound.add(word);
            }
        }

        if (!bannedWordsFound.isEmpty()) {
            return ModerationOutput.builder()
                    .approved(false)
                    .reason("Contém palavras proibidas: " + bannedWordsFound)
                    .build();
        }

        return ModerationOutput.builder()
                .approved(true)
                .reason("Comentário aprovado não palavras proibidas")
                .build();
    }
}