package com.pec.connect.services;

import com.pec.connect.entity.Record;
import com.pec.connect.exceptions.IdentityNotFoundException;

import java.util.List;

public interface RecordHistoryService {

    List<Record> getLastAccessedRecords(Long uid) throws IdentityNotFoundException;
}
