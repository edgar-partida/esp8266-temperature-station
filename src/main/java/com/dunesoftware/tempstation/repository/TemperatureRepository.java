package com.dunesoftware.tempstation.repository;

import com.dunesoftware.tempstation.entity.Temperature;
import com.dunesoftware.tempstation.entity.TemperatureGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface TemperatureRepository extends JpaRepository<Temperature,Integer> {


    /*@Query("select new com.dunesoftware.tempstation.entity.TemperatureGroup(location,truncate(avg(temperature),2) as 'temperature',truncate(avg(humidity),2) as 'humidity')" +
            "from temperaturestation.temperature" +
            "where date(now()) = date(measure_timestamp)" +
            "group by 1" +
            "order by measure_timestamp desc;")
    List<TemperatureGroup> getTodayTemperature();*/
}
