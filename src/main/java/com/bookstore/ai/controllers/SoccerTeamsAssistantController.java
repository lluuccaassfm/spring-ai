package com.bookstore.ai.controllers;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.util.annotation.NonNull;

@RestController
@RequestMapping("/soccer-team")
public class SoccerTeamsAssistantController {

    @Autowired
    ChatClient chatClient;


    @GetMapping("/chat")
    public String soccerTeamChat(@NonNull @RequestParam(value = "message") String message) {
        return chatClient.call(message);
    }

    @GetMapping("/story")
    public String bookstoreReview(@RequestParam(value = "team", defaultValue = "São Paulo Futebol Clube") String team) {
        var promptTemplate = new PromptTemplate("""
                Por favor, me forneça
                um breve resumo da história do time de futebol {team}
                e também quais os seus principais títulos.
                """);
        promptTemplate.add("team", team);
        return chatClient.call(promptTemplate.create()).getResult().getOutput().getContent();
    }
}
