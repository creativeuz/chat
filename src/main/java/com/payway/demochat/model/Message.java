package com.payway.demochat.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "sender_id")
    private UUID senderId;
    @Column(name = "receiver_id")
    private UUID receiverId;
    @ManyToOne
    @JoinColumn(name = "room")
    Room room;
    @Column(name = "sent_time", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private ZonedDateTime sentTime;
    @Column(name = "content")
    private String content;

    @PrePersist
    protected void onCreate() {
        if (this.sentTime == null) {
            this.sentTime = ZonedDateTime.now();
        }
    }

    public Message(UUID senderId, UUID receiverId, String content) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.content = content;
    }

    public Message(UUID senderId, UUID receiverId, String content, Room room) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.room = room;
        this.content = content;
    }
}
