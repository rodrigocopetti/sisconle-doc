package com.example.sisconledoc.configuration;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmpqConfig {
  public static final String QUEUE_TEMPLATE = "ald-template.queue";
  public static final String QUEUE_GENERATED_DOC = "ald-generated-doc.queue";

  @Bean
  public Queue templateListenerQueue() {
    return new Queue(QUEUE_TEMPLATE);
  }

  @Bean
  public Queue generatedDocQueue() {
    return new Queue(QUEUE_GENERATED_DOC);
  }

  @Bean
  public RabbitTemplate template(final ConnectionFactory connectionFactory, final AmqpAdmin amqpAdmin) {
    final var template = new RabbitTemplate(connectionFactory);
    template.setMessageConverter(jack2msgconv());
    template.setRoutingKey(QUEUE_TEMPLATE);
    template.setRoutingKey(QUEUE_GENERATED_DOC);
    return template;
  }

  @Bean
  public Jackson2JsonMessageConverter jack2msgconv() {
    return new Jackson2JsonMessageConverter();
  }

}
