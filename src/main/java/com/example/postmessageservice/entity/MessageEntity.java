package com.example.postmessageservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.extern.jackson.Jacksonized;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@Jacksonized
@Document(collection = "messages")
public class MessageEntity implements Serializable {

    @Id
    private String id;
    private String from;
    private String to;
    private String message;
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime date;
}

