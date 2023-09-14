package com.example.usinadrosinadback.domain.advertisementChore;

import com.example.usinadrosinadback.domain.advertisement.Advertisement;
import com.example.usinadrosinadback.domain.advertisement.chore.Chore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "advertisement_chore")
public class AdvertisementChore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "chore_id", nullable = false)
    private Chore chore;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "advertisement_id", nullable = false)
    private Advertisement advertisement;

}