package com.consumer.consumer_service.service;

import com.consumer.consumer_service.dao.DataRepository;
import com.consumer.consumer_service.model.DataRecord;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    private final DataRepository dataRepository;

    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public void saveData(String line) {
        DataRecord dataRecord = new DataRecord();
        dataRecord.setContent(line);
        dataRepository.save(dataRecord);
    }
}