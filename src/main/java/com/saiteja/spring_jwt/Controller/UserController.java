package com.saiteja.spring_jwt.Controller;

import com.saiteja.spring_jwt.entity.User;
import com.saiteja.spring_jwt.service.KafkaMessagePublisher;
import com.saiteja.spring_jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private KafkaMessagePublisher publisher;

    @PostMapping("/register")
    public User addUser(@RequestBody User user) {
        publisher.sendUserToTopic(user);
        publisher.messageSendToTopic("User Registered: " + user.getUsername());
        return service.addUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        publisher.sendUserToTopic(user);
        publisher.messageSendToTopic("User logged in: " + user.getUsername());
        return service.verify(user);
    }
}
