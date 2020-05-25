package com.pec.connect.repo;

import com.pec.connect.entity.RecordAccessHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordHistoryRepository extends JpaRepository<RecordAccessHistory,Long> {

    @Query(nativeQuery = true,
            value = "select * from record_access_history where id in(select max(id) from record_access_history " +
                    "where user_id =?1 group by user_id,record_id) order by created_at desc limit 5")
    List<RecordAccessHistory> getAllByUserId(Long uid);

    RecordAccessHistory findTopByUserIdAndRecordId(Long userId, Long recordId);
}

