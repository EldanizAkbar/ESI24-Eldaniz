package com.esi.studentservice.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public NewTopic SSMTopicCreation() {
        return TopicBuilder.name("SSMRequestCreatedTopic")
                .build();
    }

    @Bean
    public NewTopic SSMTopicFinalized() {
        return TopicBuilder.name("SSMRequestFinalizedTopic")
                .build();
    }
}
