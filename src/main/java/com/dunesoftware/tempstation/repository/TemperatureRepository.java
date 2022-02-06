package com.dunesoftware.tempstation.repository;

import com.dunesoftware.tempstation.entity.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureRepository extends JpaRepository<Temperature,Integer> {

}
