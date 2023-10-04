package com.example.usinadrosinadback.domain.advertisement;

import com.example.usinadrosinadback.domain.advertisement.tool.Tool;
import com.example.usinadrosinadback.domain.advertisement.type.Type;
import com.example.usinadrosinadback.domain.location.coordinate.Coordinate;
import com.example.usinadrosinadback.domain.location.city.City;
import com.example.usinadrosinadback.domain.location.county.County;
import com.example.usinadrosinadback.domain.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "advertisement")
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "county_id", nullable = false)
    private County county;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tool_id", nullable = false)
    private Tool tool;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coordinate_id")
    private Coordinate coordinate;

    @Size(max = 2000)
    @NotNull
    @Column(name = "description", nullable = false, length = 2000)
    private String description;

    @Column(name = "area")
    private Integer area;

    @NotNull
    @Column(name = "price", nullable = false, precision = 5, scale = 2)
    private Float price;

    @NotNull
    @Column(name = "\"time\"", nullable = false)
    private Instant time;

}