package joe.learning.rabbitMq_tut.publisher;

import joe.learning.rabbitMq_tut.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqJsonProducer {
    @Value("${rabbitmq.queue.exchange}")
    private String exchange ;
    @Value("${rabbitmq.queue.routing.jsonKey}")
    private String routingKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqJsonProducer.class);
    private RabbitTemplate rabbitTemplate;

    public RabbitMqJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(User user){
        LOGGER.info(String.format("Json message sent -> %s",user.toString()));
        rabbitTemplate.convertAndSend(exchange,routingKey,user);
    }
}
