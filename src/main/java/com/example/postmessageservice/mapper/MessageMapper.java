package com.example.postmessageservice.mapper;

import com.example.postmessageservice.dto.MessageDTO;
import com.example.postmessageservice.entity.MessageEntity;
public class MessageMapper {
    public static MessageDTO convertEntityToDto(MessageEntity messageEntity) {
        MessageDTO messageDto = new MessageDTO();
        messageDto.setId(messageEntity.getId());
        messageDto.setFrom(messageEntity.getFrom());
        messageDto.setTo(messageEntity.getTo());
        messageDto.setMessage(messageEntity.getMessage());
        messageDto.setDate(messageEntity.getDate());
        return messageDto;
    }
}
