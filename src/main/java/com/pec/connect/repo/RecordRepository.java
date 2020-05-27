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

    @Query(nativeQuery = true,
            value = "select * from record where LOWER(title) like %?1% OR LOWER(category) like %?1% " +
                    " OR LOWER(specialisation) like %?1% OR LOWER(record.type) like %?1% OR LOWER(posted_by) " +
                    " LIKE %?1% order by posted_at desc")
    List<Record> getRecordsByKey(String key);

//    @Query(nativeQuery = true,
//            value = "select * from record where LOWER(title) like %?1% OR LOWER(category) like %?3% " +
//                    " OR LOWER(specialisation) like %?4% OR LOWER(record.type) like %?2% OR LOWER(posted_by) " +
//                    " LIKE %?5% order by posted_at desc")
//    List<Record> getAllRecordsByParams(String title, String type, String category, String specialisation,String postedBy);

    @Query(nativeQuery = true,
            value = "select * from record where case when title is not null then LOWER(title) like %?1% else title like % end order by posted_at desc")
    List<Record> getAllRecordsByParams(String title, String type, String category, String specialisation, String postedBy);
}
