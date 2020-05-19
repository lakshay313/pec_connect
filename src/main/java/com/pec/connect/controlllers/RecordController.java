package com.pec.connect.controlllers;

import com.pec.connect.entity.Record;
import com.pec.connect.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecordController {

    @Autowired
    RecordService recordService;

    @PostMapping("/record")
    public Record createRecord(@RequestBody Record record) {
        return recordService.createRecord(record);
    }

    @GetMapping("/record")
    public List<Record> getRecords() {
        return recordService.getAllRecords();
    }

}
