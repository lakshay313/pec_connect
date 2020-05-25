package com.pec.connect.controlllers;

import com.pec.connect.entity.Record;
import com.pec.connect.entity.RecordAccessHistory;
import com.pec.connect.exceptions.IdentityNotFoundException;
import com.pec.connect.services.RecordHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecordHistoryController {

    @Autowired RecordHistoryService recordHistoryService;

    @GetMapping("/record/history")
    public List<Record> getLastAccessedRecords(@RequestParam(name = "uid") Long uid) throws IdentityNotFoundException {
        return recordHistoryService.getLastAccessedRecords(uid);
    }

    @PostMapping("/record/history")
    public List<Record> createLastAccessedRecord(@RequestBody RecordAccessHistory recordAccessHistory) throws IdentityNotFoundException{
        return recordHistoryService.createLastAccessedRecord(recordAccessHistory);
    }



}
