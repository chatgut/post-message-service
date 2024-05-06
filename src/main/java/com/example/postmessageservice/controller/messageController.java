package com.example.postmessageservice.controller;

import com.example.postmessageservice.model.Message;
import com.example.postmessageservice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping(value = "/api")
public class messageController {

    @Autowired
    private MessageService messageService;

    @GetMapping(path = "/messages")
    public ResponseEntity<List<Message>> getAllMessages() {
        return ResponseEntity.ok().body(messageService.getMessages());
    }

    @GetMapping(path = "/messages/{id}")
    public ResponseEntity<Message> getMessageByIdPath(@PathVariable String id) {
        return ResponseEntity.ok().body(messageService.getMessageById(id));
    }

    @PostMapping(path = "/messages")
    public ResponseEntity<Message> saveMessage(@RequestBody Message message) {
        return ResponseEntity.ok().body(messageService.saveMessage(message));
    }
}