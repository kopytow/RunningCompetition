package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ResultsProcessorConfiguration {
    @Bean
    ResultsProcessor getProcessor() {
        return new ResultsProcessorImplementer();
    }
}
