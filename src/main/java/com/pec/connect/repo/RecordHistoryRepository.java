package com.pec.connect.repo;

import com.pec.connect.entity.RecordAccessHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordHistoryRepository extends JpaRepository<RecordAccessHistory,Long> {

    List<RecordAccessHistory> findAllByUserId(Long uid);
}
