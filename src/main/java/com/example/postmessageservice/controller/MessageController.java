package com.example.postmessageservice.controller;

import com.example.postmessageservice.dto.MessageDTO;
import com.example.postmessageservice.entity.MessageEntity;
import com.example.postmessageservice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping(value = "/api")
public class MessageController {


    @Autowired
    private MessageService messageService;

    @GetMapping(path = "/messages")
    public ResponseEntity<List<MessageDTO>> getAllMessages() {
        List<MessageDTO> messageDTOList = messageService.getAllMessages();
        return new ResponseEntity<>(messageDTOList, HttpStatus.OK);
    }

    @GetMapping(path = "/messages/{id}")
    public ResponseEntity<MessageDTO> getMessageById(@PathVariable ("id")String id) {
        MessageDTO messageDTO = messageService.getMessageById(id);
        return new ResponseEntity <> (messageDTO, HttpStatus.OK);
    }

    @PutMapping(path = "/messages")
    public ResponseEntity<MessageEntity> saveMessage(@RequestBody MessageEntity messageEntity) {
        MessageEntity savedMessage = messageService.createMessage(messageEntity);
        return new ResponseEntity<>(savedMessage, HttpStatus.CREATED);
    }
}