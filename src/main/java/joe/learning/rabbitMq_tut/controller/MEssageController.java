package joe.learning.rabbitMq_tut.controller;

import joe.learning.rabbitMq_tut.publisher.RabbitMqProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MEssageController {
    private RabbitMqProducer producer;

    public MEssageController(RabbitMqProducer producer) {
        this.producer = producer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message")String message ){
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent to rabbitMq");
    }
}
