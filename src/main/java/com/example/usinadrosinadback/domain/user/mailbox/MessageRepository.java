package com.example.usinadrosinadback.domain.user.mailbox;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    @Query("select m from Message m where m.senderUser.id = ?1 or m.receiverUser.id = ?1")
    List<Message> getAllMessagesBy(Integer userId);

}