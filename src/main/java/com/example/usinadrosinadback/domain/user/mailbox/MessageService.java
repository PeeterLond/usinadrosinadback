package com.example.usinadrosinadback.domain.user.mailbox;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Resource
    MessageRepository messageRepository;

    public List<Message> findAllMessagesBy(Integer userId) {
        return messageRepository.getAllMessagesBy(userId);
    }

    public void saveMessage(Message message) {
        messageRepository.save(message);
    }
}
