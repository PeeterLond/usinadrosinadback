package com.example.usinadrosinadback.business.user.mailbox;

import com.example.usinadrosinadback.business.user.mailbox.dto.MessageDto;
import com.example.usinadrosinadback.domain.user.mailbox.Message;
import com.example.usinadrosinadback.domain.user.mailbox.MessageMapper;
import com.example.usinadrosinadback.domain.user.mailbox.MessageService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailboxService {

    @Resource
    private MessageService messageService;

    @Resource
    private MessageMapper messageMapper;

    public List<MessageDto> getAllMessagesBy(Integer userId) {
        List<Message> message = messageService.findAllMessagesBy(userId);
        return messageMapper.getMessageByDtos(message);

    }
}
