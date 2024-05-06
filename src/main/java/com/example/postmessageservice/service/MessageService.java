package com.example.postmessageservice.service;

import com.example.postmessageservice.dto.MessageDTO;
import com.example.postmessageservice.entity.MessageEntity;

import java.util.List;

public interface MessageService {

    MessageDTO getMessageById(String id);

    List<MessageDTO> getAllMessages();

    MessageEntity createMessage(MessageEntity messageEntity);
}
