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

    @GetMapping("/mailbox")
    @Operation(summary = "Leiab userId järgi ülesse info saadetud ja saadud meilide kohta")
    public List<MessageDto> getAllMessagesBy(@RequestParam Integer userId) {
        return mailboxService.getAllMessagesBy(userId);
    }

    @PostMapping("/mailbox")
    @Operation(summary = "Lisab message tabelisse uue sõnumi.")
    public void addNewMessage(@RequestBody MessageDto request) {
        mailboxService.addNewMessage(request);
    }

}
