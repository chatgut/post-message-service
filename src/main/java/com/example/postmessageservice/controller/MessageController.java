package com.example.postmessageservice.controller;

import com.example.postmessageservice.dto.MessageDTO;
import com.example.postmessageservice.service.MessageService;
import com.example.postmessageservice.service.RabbitMqJsonProducer;
import com.example.postmessageservice.service.RabbitMqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
@CrossOrigin
public class MessageController {

    private MessageService messageService;
    private RabbitMqProducer producer;
    private RabbitMqJsonProducer jsonProducer;

    @Autowired
    public MessageController(MessageService messageService, RabbitMqProducer producer, RabbitMqJsonProducer jsonProducer) {
        this.messageService = messageService;
        this.producer = producer;
        this.jsonProducer = jsonProducer;
    }

    @GetMapping()
    public ResponseEntity<List<MessageDTO>> getAllMessages() {
        List <MessageDTO> messageList = messageService.getAllMessages();
        producer.sendMessage(messageList.toString());
        return new ResponseEntity<>(messageList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDTO> getMessageById(@PathVariable ("id")String id) {
        MessageDTO messageDTO = messageService.getMessageById(id);
        if (messageDTO != null) {
            producer.sendMessage(messageDTO.toString());
            return new ResponseEntity<>(messageDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<MessageDTO> saveMessage(@RequestBody MessageDTO messageDTO) {
        MessageDTO saveMessage = messageService.createMessage(messageDTO);
        jsonProducer.sendJsonMessage(saveMessage);
        return new ResponseEntity<>(saveMessage, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMessage(@PathVariable("id") String id) {
        boolean isDeleted = messageService.deleteMessage(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}