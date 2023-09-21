package com.example.usinadrosinadback.domain.user.mailbox;

import com.example.usinadrosinadback.business.user.mailbox.dto.MessageDto;
import com.example.usinadrosinadback.business.user.mailbox.dto.MessageShowDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MessageMapper {

    @Mapping(source = "messageLetterBody", target = "letterBody")
    @Mapping(source = "messageLetterTitle", target = "letterTitle")
    Message toMessage(MessageDto messageDto);

    @Mapping(source = "id", target = "messageId")
    @Mapping(source = "senderUser.id", target = "senderUserId")
    @Mapping(source = "senderUser.username", target = "senderUserUsername")
    @Mapping(source = "receiverUser.id", target = "receiverUserId")
    @Mapping(source = "receiverUser.username", target = "receiverUserUsername")
    MessageShowDto toMessageShowDto(Message message);

    List<MessageShowDto> toMessageShowDtos(List<Message> messages);
}