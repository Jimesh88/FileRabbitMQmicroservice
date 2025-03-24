package com.consumer.consumer_service.dao;


import com.consumer.consumer_service.model.DataRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<DataRecord, Long> {
}