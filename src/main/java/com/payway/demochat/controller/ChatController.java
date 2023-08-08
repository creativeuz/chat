package com.payway.demochat.controller;

import com.payway.demochat.model.MessageRequest;
import com.payway.demochat.model.MessageResponse;
import com.payway.demochat.service.ChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatController {

    private final ChatService chatService;

    public ChatController(
        ChatService chatService
    ) {
        this.chatService = chatService;
    }

    // adding new Customer to database and return Customer id
    @PostMapping("/newCustomer")
    @ResponseBody
    public String addCustomer(@RequestParam String name) {
        return chatService.addCustomer(name);
    }

    // adding new Customer Support to database and returns Staff id
    @PostMapping("/newStaff")
    @ResponseBody
    public String addStaff(@RequestParam String name) {
        return chatService.addStaff(name);
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
    public String createRoom(@RequestParam String staff, String consumer) {
        return chatService.createRoom(staff, consumer);
    }

    // marking room as closed will make it unavailable for users
    // after room closed no one will be able to see messages
    @PostMapping("closeRoom")
    @ResponseBody
    public void closeRoom(@RequestParam String roomId) {
        chatService.close(roomId);
    }
}
