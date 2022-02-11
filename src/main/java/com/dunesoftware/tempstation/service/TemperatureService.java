package com.dunesoftware.tempstation.service;

import com.dunesoftware.tempstation.entity.Temperature;
import com.dunesoftware.tempstation.entity.TemperatureGroup;
import com.dunesoftware.tempstation.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Set;

@Service
public class TemperatureService {

    @Autowired
    TemperatureRepository temperatureRepository;

    public List<Temperature> getAllTemperatures() {
        return temperatureRepository.findAll();
    }

    public Temperature saveTemperature(Temperature temperature) {
        if(temperature.getMeasure_timestamp() == null) {
            temperature.setMeasure_timestamp(Timestamp.from(Instant.now()));
        }
        return temperatureRepository.save(temperature);
    }

    public Temperature saveTemperature(String temperature, String humidity, String location) {
        Temperature measure = Temperature.builder()
                .temperature(Double.parseDouble(temperature))
                .humidity(Double.parseDouble(humidity))
                .location(location)
                .measure_timestamp(Timestamp.from(Instant.now()))
                .build();
        return temperatureRepository.save(measure);
    }

    public List<TemperatureGroup> getTodayTemperature() {
        return null;
        //return temperatureRepository.getTodayTemperature();
    }
}
