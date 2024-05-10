package com.example.postmessageservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.annotation.CreatedDate;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@Jacksonized
public class MessageDTO implements Serializable {
    private String id;
    private String from;
    private String to;
    private String message;
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime date;
}

