package joe.learning.rabbitMq_tut.publisher;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class RabbitMqProducer {
    @Value("${rabbitmq.queue.name}")
    private String queue;

    @Value("${rabbitmq.queue.exchange}")
    private String exchange;

    @Value("${rabbitmq.queue.routingKey}")
    private String routingKey;
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqProducer.class);

    private RabbitTemplate rabbitTemplate;

    public RabbitMqProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message){
        LOGGER.info(String.format("Message sent -> %s",message));
        rabbitTemplate.convertAndSend(exchange,routingKey,message);
    }


}
