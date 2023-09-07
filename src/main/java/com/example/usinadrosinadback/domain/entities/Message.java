package com.example.usinadrosinadback.domain.entities;

import com.example.usinadrosinadback.domain.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "message")
public class Message {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "letter_title", nullable = false)
    private String letterTitle;

    @Size(max = 2000)
    @NotNull
    @Column(name = "letter_body", nullable = false, length = 2000)
    private String letterBody;

    @NotNull
    @Column(name = "letter_time", nullable = false)
    private Instant letterTime;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sender_user_id", nullable = false)
    private User senderUser;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "receiver_user_id", nullable = false)
    private User receiverUser;

    @NotNull
    @Column(name = "is_read", nullable = false)
    private Boolean isRead = false;

}