package com.payway.demochat.repository;

import com.payway.demochat.model.Message;
import com.payway.demochat.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MessageRepository extends JpaRepository<Message, UUID> {

    List<Message> getMessagesByRoomOrderBySentTime(Room room);
}
