package com.api.api_service.service;

import com.api.api_service.model.DataRecord;
import com.api.api_service.dao.DataRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DataRecordService {

    @Autowired
    private DataRecordRepository dataRecordRepository;

    public Page<DataRecord> searchRecords(String name, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return dataRecordRepository.findByContentContainingIgnoreCase(name, pageable);
    }
}