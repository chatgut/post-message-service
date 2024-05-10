package com.example.postmessageservice.service.implementation;

import com.example.postmessageservice.dto.MessageDTO;
import com.example.postmessageservice.entity.MessageEntity;
import com.example.postmessageservice.mapper.MessageMapper;
import com.example.postmessageservice.repository.MessageRepository;
import com.example.postmessageservice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MessageImplementation implements MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    @Autowired
    public MessageImplementation(MessageRepository messageRepository, MessageMapper messageMapper) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
    }

    @Cacheable(value = "messages", key = "#id")
    @Override
    public MessageDTO getMessageById(String id) {
        Optional<MessageEntity> messageEntity = messageRepository.findById(id);
        return messageEntity.map(messageMapper::toDto).orElse(null);
    }

    @Cacheable(value = "messages")
    @Override
    public List<MessageDTO> getAllMessages() {
        List<MessageEntity> messageList = messageRepository.findAll();
        List<MessageDTO> messageDTOList = new ArrayList<>();
        for (MessageEntity message : messageList) {
            messageDTOList.add(messageMapper.toDto(message));
        }
        return messageDTOList;
    }

    @CachePut(value = "messages", key = "#result.id")
    @Override
    public MessageDTO  createMessage(MessageDTO messageDTO) {
        MessageEntity message = messageMapper.toEntity(messageDTO);
        MessageEntity savedMessage = messageRepository.save(message);
        return messageMapper.toDto(savedMessage);
    }

    @CacheEvict(value = "messages", key = "#id")
    @Override
    public boolean deleteMessage(String id) {
        Optional<MessageEntity> messageEntity = messageRepository.findById(id);
        if (messageEntity.isPresent()) {
            messageRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
