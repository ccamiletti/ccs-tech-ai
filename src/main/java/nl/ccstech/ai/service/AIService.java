package nl.ccstech.ai.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import lombok.RequiredArgsConstructor;
import nl.ccstech.ai.model.GeminiQuestion;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AIService {

    private final WebClient webClient;
    private final Client client;

    public Mono<ResponseEntity<String>> getAnswer(String question) {
        return webClient.post().bodyValue(GeminiQuestion.createQuestion(question))
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(this::logTraceResponse);
    }

    public String getAnswerString(String question) {
        GenerateContentResponse response =
                client.models.generateContent("gemini-3-flash-preview", question, null);

        return response.text();
    }

    private Mono<ResponseEntity<String>> logTraceResponse(ClientResponse response) {

        if (HttpStatus.OK.equals(response.statusCode())) {
            return response.bodyToMono(String.class).map(r -> ResponseEntity.ok().body(r));
        }

        return response.createException().flatMap(Mono::error);

    }

}
