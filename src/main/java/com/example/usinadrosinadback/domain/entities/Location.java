package com.example.usinadrosinadback.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "location")
public class Location {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "long", nullable = false, precision = 17, scale = 14)
    private BigDecimal longField;

    @NotNull
    @Column(name = "lat", nullable = false, precision = 17, scale = 14)
    private BigDecimal lat;

}