package com.etfmovies.videoinfo;

import com.etfmovies.videoinfo.auth.AuthEventSubscriber;
import com.etfmovies.videoinfo.repositories.CategoryRepository;
import com.etfmovies.videoinfo.repositories.ShowsRepository;
import com.etfmovies.videoinfo.repositories.VideoRepository;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class EtfMovieVideoInfoApplication {
    @Value("${spring.rabbitmq.topic-exchange-name}")
    private String topicExchangeName;

    @Value("${spring.rabbitmq.queue-name}")
    private String queueName;

    @Value("${spring.rabbitmq.routing-key}")
    private String routingKey;

    @Bean
    public TopicExchange receiverExchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    public Queue eventReceivingQueue() {
        if (queueName == null) {
            throw new IllegalStateException("No queue to listen to! Please specify the name of the queue to listen to with the property 'subscriber.queue'");
        }
        return new Queue(queueName, false);
    }

    @Bean
    public Binding binding(Queue eventReceivingQueue, TopicExchange receiverExchange) {
        if (routingKey == null) {
            throw new IllegalStateException("No events to listen to! Please specify the routing key for the events to listen to with the property 'subscriber.routingKey' (see EventPublisher for available routing keys).");
        }
        return BindingBuilder
                .bind(eventReceivingQueue)
                .to(receiverExchange)
                .with(routingKey);
    }

    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                                    MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    public MessageListenerAdapter listenerAdapter(AuthEventSubscriber authEventSubscriber) {
        return new MessageListenerAdapter(authEventSubscriber, "receive");
    }

    @Bean
    public AuthEventSubscriber eventReceiver() {
        return new AuthEventSubscriber();
    }

    public static void main(String[] args) {
        SpringApplication.run(EtfMovieVideoInfoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(VideoRepository videoRepository, ShowsRepository showsRepository, CategoryRepository categoryRepository) {
        return (args) -> {
            // save a couple of categories
			/*categoryRepository.save(new Category("Comedy"));
			categoryRepository.save(new Category("Drama"));
			categoryRepository.save(new Category("Thriller"));
			categoryRepository.save(new Category("Animated"));
			categoryRepository.save(new Category("Horror"));*/
        };
    }
}
