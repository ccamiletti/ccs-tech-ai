package nl.ccstech.ai.controller;

import lombok.RequiredArgsConstructor;
import nl.ccstech.ai.model.QuestionRequest;
import nl.ccstech.ai.service.AIService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class AIController {

    private final AIService aiService;

    @PostMapping
    public Mono<ResponseEntity<String>> getAnswer(@RequestBody QuestionRequest questionRequest) {
        return aiService.getAnswer(questionRequest.getQuestion());
    }

    @PostMapping("/client")
    public ResponseEntity<String> getAnswerString(@RequestBody QuestionRequest questionRequest) {
        return ResponseEntity.ok(aiService.getAnswerString(questionRequest.getQuestion()));
    }

}
