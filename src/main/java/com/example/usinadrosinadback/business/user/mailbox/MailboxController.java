package com.example.usinadrosinadback.business.user.mailbox;

import com.example.usinadrosinadback.business.user.mailbox.dto.MessageDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MailboxController {

    @Resource
    private MailboxService mailboxService;

    @GetMapping("/mailbox-sent")
    @Operation(summary = "Leiab userId järgi ülesse info saadetud meilide kohta")
    public List<MessageDto> findAllSentMessagesBy(@RequestParam Integer userId) {
        return mailboxService.findAllSentMessagesBy(userId);
    }

    @GetMapping("/mailbox-receive")
    @Operation(summary = "Leiab userId järgi ülesse info saadud meilide kohta")
    public List<MessageDto> findAllReceivedMessagesBy(@RequestParam Integer userId) {
        return mailboxService.findAllReceivedMessagesBy(userId);
    }

    @PostMapping("/mailbox")
    @Operation(summary = "Lisab message tabelisse uue sõnumi.")
    public void addNewMessage(@RequestBody MessageDto request) {
        mailboxService.addNewMessage(request);
    }

}
