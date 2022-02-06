package com.dunesoftware.tempstation.controller;

import com.dunesoftware.tempstation.entity.Temperature;
import com.dunesoftware.tempstation.service.TemperatureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@Slf4j
public class TemperatureController {

    @Autowired
    TemperatureService temperatureService;

    @GetMapping("/temperature")
    public ResponseEntity<List<Temperature>> getAllTemperatures() {
        return new ResponseEntity<>(temperatureService.getAllTemperatures(), HttpStatus.OK);
    }

    @PostMapping("/temperature")
    public ResponseEntity<Temperature> registerMeasure(@RequestBody Temperature temperature) {
        return new ResponseEntity<>(temperatureService.saveTemperature(temperature),HttpStatus.CREATED);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        log.debug("Testing a call");
        log.info("Testing a call");
        return new ResponseEntity<String>("We received your request!!",HttpStatus.OK);
    }

    @GetMapping("/weather/save")
    public ResponseEntity<String> saveMeasure(@RequestParam String t,
                                              @RequestParam String h,
                                              @RequestParam String l) {
        log.info("Temperature {}, Humidity {}, region {}",t,h,l);
        if(t.equalsIgnoreCase("nan")){
            log.error("no measure received for date {}", Instant.now());
        } else {
            temperatureService.saveTemperature(t,h,l);
        }
        return new ResponseEntity<>("Temperature registered",HttpStatus.OK);
    }
}
