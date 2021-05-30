package com.example.design.entity;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long labId;
    private Long startWeek;
    private Long endWeek;
}
