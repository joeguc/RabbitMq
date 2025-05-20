package joe.learning.rabbitMq_tut.controller;

import joe.learning.rabbitMq_tut.dto.User;
import joe.learning.rabbitMq_tut.publisher.RabbitMqJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {
    private RabbitMqJsonProducer rabbitMqJsonProducer;

    public MessageJsonController(RabbitMqJsonProducer rabbitMqJsonProducer) {
        this.rabbitMqJsonProducer = rabbitMqJsonProducer;
    }
    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(User user){
        rabbitMqJsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("json message sent to rabbit MQ ya joe basha ");
    }
}
