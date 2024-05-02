package com.Spring.demo.repo;

import com.Spring.demo.modal.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, Integer> {
    // You can add custom query methods if needed
}
