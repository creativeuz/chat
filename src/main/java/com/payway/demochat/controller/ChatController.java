package com.payway.demochat.controller;

import com.payway.demochat.model.MessageRequest;
import com.payway.demochat.model.MessageResponse;
import com.payway.demochat.service.ChatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ChatController {

    private final ChatService chatService;

    public ChatController(
        ChatService chatService
    ) {
        this.chatService = chatService;
    }

    // adding new User to database
    @PostMapping("/newUser")
    @ResponseBody
    public void addUser(@RequestParam String name) {
        chatService.addUser(name);
    }

    // adding new Customer Support to database
    @PostMapping("/newCS")
    @ResponseBody
    public void addCS(@RequestParam String name) {
        chatService.addCS(name);
    }

    // sending message from sender to reciever in the form of MessageRequest
    @PostMapping("/send")
    @ResponseBody
    public void sendMessage(@RequestBody MessageRequest request) {
        chatService.sendMessage(
            request.getSenderId(),
            request.getReceiverId(),
            request.getContent(),
            request.getRoomId()
        );
    }

    // getting all message in this room between consumer and staff
    @GetMapping("/get")
    @ResponseBody
    public List<MessageResponse> getMessage(@RequestParam String roomId) {
        return chatService.getMessages(roomId);
    }

    // Before messaging need to create new room where
    // all messages associated with these 2 people will be stored
    @PostMapping("newRoom")
    @ResponseBody
    public void createRoom(@RequestParam String staff, String consumer) {
        chatService.createRoom(staff, consumer);
    }

    // marking room as closed will make it unavailable for users
    // after room closed no one will be able to see messages
    @PostMapping("closeRoom")
    @ResponseBody
    public void closeRoom(@RequestParam String roomId) {
        chatService.close(roomId);
    }
}
