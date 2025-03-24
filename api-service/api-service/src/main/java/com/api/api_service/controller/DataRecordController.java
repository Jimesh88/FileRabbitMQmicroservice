package com.api.api_service.controller;

import com.api.api_service.model.DataRecord;
import com.api.api_service.service.DataRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataRecordController {

    @Autowired
    private DataRecordService dataRecordService;

    @GetMapping("/records")
    public Page<DataRecord> getRecords(
            @RequestParam(value = "pageno", defaultValue = "0") int pageNo,
            @RequestParam(value = "pagesize", defaultValue = "10") int pageSize,
            @RequestParam(value = "name", defaultValue = "") String name) {

        return dataRecordService.searchRecords(name, pageNo, pageSize);
    }
}