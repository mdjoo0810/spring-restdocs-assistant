package kr.aaron.restdocsassistantexample;

import kr.aaron.restdocs_assistant.ResponseAssistant;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@TestConfiguration
public class AssistantConfig {

    @Bean
    public ResponseAssistant responseAssistant() {
        return new ResponseAssistant(getPackageName());
    }

    private String getPackageName() {
        return "kr.aaron";
    }

}
