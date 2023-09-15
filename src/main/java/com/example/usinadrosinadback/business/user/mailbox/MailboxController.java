package com.example.usinadrosinadback.business.user.mailbox;

import com.example.usinadrosinadback.business.user.mailbox.dto.MessageDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MailboxController {

    @Resource
    private MailboxService mailboxService;

    @GetMapping("/mailbox")
    @Operation(summary = "Leiab userId järgi ülesse info saadetud ja saadud meilide kohta")
    public List<MessageDto> getAllMessagesBy(@RequestParam Integer userId){
        return mailboxService.getAllMessagesBy(userId);
    }
}
