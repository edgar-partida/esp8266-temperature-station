package com.dunesoftware.tempstation.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Temperature {
    @Id
    @GeneratedValue
    private int id;
    private Timestamp measure_timestamp;
    private double temperature, humidity;
    private String location;
}
