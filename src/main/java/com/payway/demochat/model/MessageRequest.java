package com.payway.demochat.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageRequest {
    private String senderId;
    private String receiverId;
    private String content;
    private String roomId;


}
