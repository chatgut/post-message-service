package com.example.postmessageservice.repository;

import com.example.postmessageservice.entity.MessageEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<MessageEntity, String>{
}
