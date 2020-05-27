package com.pec.connect.services.impl;

import com.pec.connect.entity.Record;
import com.pec.connect.repo.RecordRepository;
import com.pec.connect.services.RecordService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    RecordRepository recordRepository;

    @Override
    public Record createRecord(Record record) {
        try {
            recordRepository.save(record);
        } catch (Exception ignore) {
        }
        return recordRepository.findById(record.getId()).orElse(null);
    }

    @Override
    public List<Record> getAllRecords() {
        return recordRepository.getAll();
    }

    @Override
    public Record getById(Long recordId) {
        return recordRepository.findById(recordId).orElse(null);
    }

    @Override
    public List<Record> getRecords(Long numEntries) {
        return recordRepository.getRecentRecords(numEntries);
    }

    @Override
    public List<Record> getRecordsByKey(String key) {
        return recordRepository.getRecordsByKey(key.toLowerCase());
    }

    @Override
    public List<Record> getRecordsByParams(String key, String type, String category, String specialisation) {
        if(StringUtils.isBlank(key)){
           key= "";
        }
        if(StringUtils.isBlank(type)){
            type = "";
        }
        if(StringUtils.isBlank(category)){
            category = "";
        }
        if(StringUtils.isBlank(specialisation)) {
            specialisation = "";
        }

        return recordRepository.getRecordsByParams(key.toLowerCase(),type.toLowerCase(),
                category.toLowerCase(),specialisation.toLowerCase());
    }


}
