package com.bookstore.ai.controllers;

import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.util.annotation.NonNull;

@RestController
@RequestMapping("/bookstore")
public class BookstoreAssistantController {

    @Autowired
    private OpenAiChatClient chatClient;

    @GetMapping("/informations")
    public String bookstoreChat(@RequestParam(value = "message",
            defaultValue = "Quais são os livros best sellers dos últimos anos?") String message) {
        return chatClient.call(message);
    }

    @GetMapping("/chat/informations")
    public ChatResponse bookstoreChatEx2(@NonNull @RequestParam(value = "message") String message) {
        return chatClient.call(new Prompt(message));
    }

    @GetMapping("/reviews")
    public String bookstoreReview(@RequestParam(value = "book", defaultValue = "Dom Quixote") String book) {
        var promptTemplate = new PromptTemplate("""
                Por favor, me forneça
                um breve resumo do livro {book}
                e também a biografia de seu autor.
                """);
        promptTemplate.add("book", book);
        return chatClient.call(promptTemplate.create()).getResult().getOutput().getContent();
    }


}
