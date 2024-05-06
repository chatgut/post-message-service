package com.example.postmessageservice.repository;

import com.example.postmessageservice.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String>{
}
