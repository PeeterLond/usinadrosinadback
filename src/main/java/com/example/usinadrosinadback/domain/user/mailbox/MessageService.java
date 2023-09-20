package com.example.usinadrosinadback.domain.user.mailbox;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Resource
    MessageRepository messageRepository;

    public List<Message> findAllSentMessagesBy(Integer userId) {
        return messageRepository.findAllSentMessagesBy(userId);
    }

    public void saveMessage(Message message) {
        messageRepository.save(message);
    }

    public List<Message> findAllReceivedMessagesBy(Integer userId) {
        return messageRepository.findAllReceivedMessagesBy(userId);
    }

    public Message getMessageBy(Integer messageId) {
        return messageRepository.getReferenceById(messageId);
    }
}
