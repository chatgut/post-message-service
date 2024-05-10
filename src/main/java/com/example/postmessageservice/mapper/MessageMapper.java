package com.example.postmessageservice.mapper;

import com.example.postmessageservice.dto.MessageDTO;
import com.example.postmessageservice.entity.MessageEntity;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {

    public MessageDTO toDto(MessageEntity entity) {
        return MessageDTO.builder()
                .id(entity.getId())
                .from(entity.getFrom())
                .to(entity.getTo())
                .message(entity.getMessage())
                .date(entity.getDate())
                .build();
    }

    public MessageEntity toEntity(MessageDTO dto) {
        return MessageEntity.builder()
                .id(dto.getId())
                .from(dto.getFrom())
                .to(dto.getTo())
                .message(dto.getMessage())
                .date(dto.getDate())
                .build();
    }
}
