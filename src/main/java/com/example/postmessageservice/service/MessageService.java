package com.example.postmessageservice.service;

import com.example.postmessageservice.model.Message;
import com.example.postmessageservice.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getMessages() {
        return messageRepository.findAll();
    }

    public Message getMessageById(String id) {
        return messageRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No message by ID: " + id));
    }

    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }
}