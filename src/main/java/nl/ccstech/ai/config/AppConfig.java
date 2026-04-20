package nl.ccstech.ai.config;

import com.google.genai.Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

    @Value("${app.apikey}")
    public String apikey;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=".concat(apikey))
                .build();
    }


    @Bean
    public Client client() {
        System.out.println(System.getenv("GEMINI_API_KEY"));
        return Client.builder().apiKey(apikey).build();
    }




}
