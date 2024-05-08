package com.example.postmessageservice.service.implementation;

import com.example.postmessageservice.dto.MessageDTO;
import com.example.postmessageservice.entity.MessageEntity;
import com.example.postmessageservice.mapper.MessageMapper;
import com.example.postmessageservice.repository.MessageRepository;
import com.example.postmessageservice.service.MessageService;
import org.modelmapper.ModelMapper;
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

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Cacheable(value = "messages", key = "#id")
    @Override
    public MessageDTO getMessageById(String id) {
        Optional<MessageEntity> messageEntity = messageRepository.findById(id);
        if(messageEntity.isPresent()) {
            return modelMapper.map(messageEntity.get(), MessageDTO.class);
        }
        return MessageMapper.convertEntityToDto(messageEntity.get());
    }

    @Cacheable(value = "messages")
    @Override
    public List<MessageDTO> getAllMessages() {
        List<MessageEntity> messageList = messageRepository.findAll();
        List<MessageDTO> messageDTOList = new ArrayList<>();
        for(MessageEntity message:messageList) {
            MessageDTO messageDTO = modelMapper.map(message, MessageDTO.class);
            messageDTOList.add(messageDTO);
        }
        return messageDTOList;
    }

    @CachePut(value = "messages", key = "#result.id")
    @Override
    public MessageEntity createMessage(MessageEntity messageEntity) {
        return messageRepository.save(messageEntity);
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
