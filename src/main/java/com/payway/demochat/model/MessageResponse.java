package com.payway.demochat.model;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
public class MessageResponse {

    private UUID id;
    private UUID senderId;
    private UUID receiverId;
    private ZonedDateTime sentTime;
    private String content;
}
