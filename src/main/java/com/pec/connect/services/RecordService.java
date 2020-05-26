package com.pec.connect.services;

import com.pec.connect.entity.Record;

import java.util.List;

public interface RecordService {

    Record createRecord(Record record);

    List<Record> getAllRecords();

    Record getById(Long recordId);

    List<Record> getRecords(Long numEntries);

    List<Record> getRecordsByKey(String key);
}
