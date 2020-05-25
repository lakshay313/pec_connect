package com.pec.connect.repo;

import com.pec.connect.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

    @Query(nativeQuery = true,
            value = "select * from record order by posted_at desc")
    List<Record> getAll();

    @Query(nativeQuery = true,
            value = "select * from record order by posted_at desc limit ?1 ")
    List<Record> getRecentRecords(Long numEntries);

}
