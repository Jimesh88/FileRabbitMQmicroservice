package com.api.api_service.dao;

import com.api.api_service.model.DataRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRecordRepository extends JpaRepository<DataRecord, Long> {
    Page<DataRecord> findByContentContainingIgnoreCase(String name, Pageable pageable);
}