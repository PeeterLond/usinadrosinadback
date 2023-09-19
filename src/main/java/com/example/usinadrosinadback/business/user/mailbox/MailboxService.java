package com.example.usinadrosinadback.business.user.mailbox;

import com.example.usinadrosinadback.business.user.mailbox.dto.MessageDto;
import com.example.usinadrosinadback.domain.user.User;
import com.example.usinadrosinadback.domain.user.UserService;
import com.example.usinadrosinadback.domain.user.mailbox.Message;
import com.example.usinadrosinadback.domain.user.mailbox.MessageMapper;
import com.example.usinadrosinadback.domain.user.mailbox.MessageService;
import com.example.usinadrosinadback.util.Time;
import jakarta.annotation.Resource;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

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

    public List<MessageDto> getAllMessagesBy(Integer userId) {
        List<Message> message = messageService.findAllMessagesBy(userId);
        return messageMapper.getMessageByDtos(message);

    }

    public void addNewMessage(MessageDto request) {
        Message message = messageMapper.toMessage(request);
        getAndSetSenderUserIdToMessage(request, message);
        getAndSetReceiverUserIdToMessage(request, message);
        getAndSetTimeToMessage(message);
        messageService.saveMessage(message);
    }

    private void getAndSetSenderUserIdToMessage(MessageDto request, Message message) {
        User senderUserId = userService.getUserBy(request.getSenderUserId());
        message.setSenderUser(senderUserId);
    }

    private void getAndSetReceiverUserIdToMessage(MessageDto request, Message message) {
        User receiverUserId = userService.getUserBy(request.getReceiverUserId());
        message.setReceiverUser(receiverUserId);
    }

    private void getAndSetTimeToMessage(Message message) {
        Instant currentTimeStamp = Time.getCurrentTimeStamp();
        message.setLetterTime(currentTimeStamp);
    }
}
