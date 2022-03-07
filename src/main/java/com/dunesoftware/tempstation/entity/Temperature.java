package com.dunesoftware.tempstation.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Table(schema="temperaturestation")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Temperature {
    @Id
    @GeneratedValue
    private int id;
    private Timestamp measure_timestamp;
    private double temperature, humidity;
    private String location;
}
