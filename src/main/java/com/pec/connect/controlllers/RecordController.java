package com.pec.connect.controlllers;

import com.pec.connect.entity.Record;
import com.pec.connect.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Record> getRecords(@RequestParam(name = "entries", required = false) Long numEntries) {
        if (numEntries == null)
            return recordService.getAllRecords();
        else
            return recordService.getRecords(numEntries);
    }


    @GetMapping("/record/search")
    public List<Record> getSearchRecords(@RequestParam(name = "key") String key) {
        return recordService.getRecordsByKey(key);
    }

    @GetMapping("/record/search/filter")
    public List<Record> getSearchRecordsByParam(@RequestParam(value = "key", required = false) String key,
                                                @RequestParam(value = "type", required = false) String type,
                                                @RequestParam(value = "category", required = false) String category,
                                                @RequestParam(value = "specialisation", required = false) String specialisation
    ) {
        return recordService.getRecordsByParams(key, type, category, specialisation);
    }

}
