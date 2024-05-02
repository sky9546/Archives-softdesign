package com.Spring.demo.service;

import com.Spring.demo.modal.Record;

import java.util.List;

public interface RecordService {
    List<Record> getAllRecords();
    Record getRecordById(int id);
    Record addRecord(Record record);
    Record updateRecord(int id, Record record);
    void deleteRecord(int id);
}
