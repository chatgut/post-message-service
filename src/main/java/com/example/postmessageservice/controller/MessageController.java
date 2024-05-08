package com.example.postmessageservice.controller;

import com.example.postmessageservice.dto.MessageDTO;
import com.example.postmessageservice.entity.MessageEntity;
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


    @Autowired
    private MessageService messageService;

    @GetMapping()
    public ResponseEntity<List<MessageDTO>> getAllMessages() {
        List<MessageDTO> messageDTOList = messageService.getAllMessages();
        return new ResponseEntity<>(messageDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDTO> getMessageById(@PathVariable ("id")String id) {
        MessageDTO messageDTO = messageService.getMessageById(id);
        return new ResponseEntity <> (messageDTO, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<MessageEntity> saveMessage(@RequestBody MessageEntity messageEntity) {
        MessageEntity savedMessage = messageService.createMessage(messageEntity);
        return new ResponseEntity<>(savedMessage, HttpStatus.CREATED);
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