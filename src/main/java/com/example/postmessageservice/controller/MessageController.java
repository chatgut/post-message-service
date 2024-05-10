package com.example.postmessageservice.controller;

import com.example.postmessageservice.dto.MessageDTO;
import com.example.postmessageservice.service.MessageService;
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

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping()
    public ResponseEntity<List<MessageDTO>> getAllMessages() {
        List <MessageDTO> messageList = messageService.getAllMessages();
        return new ResponseEntity<>(messageList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDTO> getMessageById(@PathVariable ("id")String id) {
        MessageDTO messageDTO = messageService.getMessageById(id);
        if (messageDTO != null) {
            return new ResponseEntity<>(messageDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<MessageDTO> saveMessage(@RequestBody MessageDTO messageDTO) {
        MessageDTO saveMessage = messageService.createMessage(messageDTO);
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