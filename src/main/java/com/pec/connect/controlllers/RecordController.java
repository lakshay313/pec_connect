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
    public List<Record> getRecords(@RequestParam(name = "entries" ,required = false) Long numEntries) {
        if(numEntries == null)
            return recordService.getAllRecords();
        else
            return recordService.getRecords(numEntries);
    }


    /*
       TODO :
           1) Add global search API
           2) Add search with filters API
     */

}
