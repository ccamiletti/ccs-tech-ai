package nl.ccstech.ai.model;

import java.util.Map;

public class GeminiQuestion {

    public static Map<String, Object> createQuestion(String question) {

        return Map.of("contents", new Object[] {
                Map.of("parts", new Object[] {
                        Map.of("text", question)
                })
        });

    }

}
