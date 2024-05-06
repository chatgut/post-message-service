package com.example.postmessageservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import java.time.LocalDate;

@Data
@Builder
@Jacksonized
@Document(collection = "messages")
public class Message {

    @Id
    private String id;
    private String from;
    private String to;
    private String message;
    private LocalDate date;

}

