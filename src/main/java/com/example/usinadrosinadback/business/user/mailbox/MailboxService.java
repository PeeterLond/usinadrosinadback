package com.example.usinadrosinadback.business.user.mailbox;

import com.example.usinadrosinadback.business.user.mailbox.dto.MessageDto;
import com.example.usinadrosinadback.business.user.mailbox.dto.MessageShowDto;
import com.example.usinadrosinadback.domain.user.User;
import com.example.usinadrosinadback.domain.user.UserService;
import com.example.usinadrosinadback.domain.user.mailbox.Message;
import com.example.usinadrosinadback.domain.user.mailbox.MessageMapper;
import com.example.usinadrosinadback.domain.user.mailbox.MessageService;
import com.example.usinadrosinadback.util.Time;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class MailboxService {

    @Resource
    private MessageService messageService;

    @Resource
    private MessageMapper messageMapper;

    @Resource
    private UserService userService;

    public List<MessageShowDto> findAllSentMessagesBy(Integer userId) {
        List<Message> messages = messageService.findAllSentMessagesBy(userId);
        return messageMapper.toMessageShowDtos(messages);

    }

    public List<MessageShowDto> findAllReceivedMessagesBy(Integer userId) {
        List<Message> messages = messageService.findAllReceivedMessagesBy(userId);
        return messageMapper.toMessageShowDtos(messages);
    }

    @Transactional
    public void addNewMessage(MessageDto request) {
        Message message = messageMapper.toMessage(request);
        getAndSetSenderUserIdToMessage(request.getSenderUserId(), message);
        getAndSetReceiverUserIdToMessage(request.getReceiverUserId(), message);
        getAndSetTimeToMessage(message);
        message.setIsRead(false);
        messageService.saveMessage(message);
    }

    private void getAndSetSenderUserIdToMessage(Integer userId, Message message) {
        User senderUserId = userService.getUserBy(userId);
        message.setSenderUser(senderUserId);
    }

    private void getAndSetReceiverUserIdToMessage(Integer userId, Message message) {
        User receiverUserId = userService.getUserBy(userId);
        message.setReceiverUser(receiverUserId);
    }

    private void getAndSetTimeToMessage(Message message) {
        Instant currentTimeStamp = Time.getCurrentTimeStamp();
        message.setLetterTime(currentTimeStamp);
    }

    public void changeMessageIsRead(Integer messageId) {
        Message messageBy = messageService.getMessageBy(messageId);
        messageBy.setIsRead(true);
        messageService.saveMessage(messageBy);


    }
}
