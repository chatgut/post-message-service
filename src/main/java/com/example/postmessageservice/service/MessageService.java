package com.example.postmessageservice.service;

import com.example.postmessageservice.dto.MessageDTO;
import java.util.List;

public interface MessageService {

    MessageDTO getMessageById(String id);
    List<MessageDTO> getAllMessages();
    MessageDTO createMessage(MessageDTO messageDTO);
    boolean deleteMessage(String id);
}
