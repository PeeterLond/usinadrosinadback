package com.example.usinadrosinadback.domain.user.mailbox;

import com.example.usinadrosinadback.business.user.mailbox.dto.MessageDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MessageMapper {

    @Mapping(source = "receiverUser.username", target = "receiverUserUsername")
    @Mapping(source = "senderUser.username", target = "senderUserUsername")
    @Mapping(source = "letterBody", target = "messageLetterBody")
    @Mapping(source = "letterTitle", target = "messageLetterTitle")
    @Mapping(source = "letterTime", target = "messageLetterTime")
    @Mapping(source = "receiverUser.id", target = "receiverUserId")
    @Mapping(source = "senderUser.id", target = "senderUserId")
    MessageDto getMessageDto(Message message);

    List<MessageDto> getMessageDtos(List<Message> messages);


    @Mapping(source = "messageLetterBody", target = "letterBody")
    @Mapping(source = "messageLetterTitle", target = "letterTitle")
    Message toMessage(MessageDto messageDto);

}