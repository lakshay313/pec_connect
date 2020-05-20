package com.pec.connect.services.impl;

import com.pec.connect.entity.Identity;
import com.pec.connect.entity.Record;
import com.pec.connect.entity.RecordAccessHistory;
import com.pec.connect.exceptions.IdentityNotFoundException;
import com.pec.connect.repo.RecordHistoryRepository;
import com.pec.connect.services.IdentityService;
import com.pec.connect.services.RecordHistoryService;
import com.pec.connect.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecordHistoryServiceImpl implements RecordHistoryService {

    @Autowired RecordHistoryRepository recordHistoryRepository;

    @Autowired IdentityService identityService;

    @Autowired RecordService recordService;

    @Override
    public List<Record> getLastAccessedRecords(Long uid) throws IdentityNotFoundException{
        Identity identity = identityService.getUserById(uid);
        if(identity == null){
            throw new IdentityNotFoundException("Invalid User Id");
        }
        List<RecordAccessHistory> recordHistories = recordHistoryRepository.findAllByUserId(uid);
        List<Record> response = new ArrayList<>();

        recordHistories.forEach( recordHistory ->{
            Record record = recordService.getById(recordHistory.getRecordId());
            if(record == null){
                recordHistoryRepository.deleteById(recordHistory.getId());
            }else{
                response.add(record);
            }
        });
        return response;

    }

}
