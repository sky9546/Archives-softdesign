package com.Spring.demo.service;

import com.Spring.demo.modal.Record;
import com.Spring.demo.repo.RecordRepository;
import com.Spring.demo.emailService.EmailService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Service
public class RecordServiceImpl implements RecordService {
    private static final Logger logger = LogManager.getLogger(RecordServiceImpl.class);

    @Autowired
    private RecordRepository recordRepository;
    @Autowired
    private HttpServletRequest request;
@Autowired
EmailService emailService;


    @Override
    public List<Record> getAllRecords() {
        return recordRepository.findAll();
    }

    @Override
    public Record getRecordById(int id) {
        try {
            Optional<Record> optionalRecord = recordRepository.findById(id);
            return optionalRecord.orElseThrow(() -> new IllegalArgumentException("Record not found"));
        } catch (IllegalArgumentException e) {
            logger.error("Record not found for ID: {}", id);
            throw e;
        } catch (Exception e) {
            logger.error("Failed to fetch record by ID", e);
            throw new RuntimeException("Failed to fetch record by ID");
        }
    }

    @Override
    public Record addRecord(Record record) {
        try {
            Record savedRecord = recordRepository.save(record);
            emailService.sendMail("chouhanakash779.ac@gmail.com", "New Record Added", "A new record has been added.");
            return savedRecord;
        } catch (Exception e) {
            logger.error("Failed to add record", e);
            throw new RuntimeException("Failed to add record");
        }
    }


    @Override
    public Record updateRecord(int id, Record record) {
        try {
            Record existingRecord = getRecordById(id);
            if (existingRecord != null) {
                // Update the existing record with the new values
                existingRecord.setTitle(record.getTitle());
                existingRecord.setDate(record.getDate());
                existingRecord.setAuthor(record.getAuthor());
                existingRecord.setPreference(record.getPreference());
                existingRecord.setPublishedOnConnect(true);
                existingRecord.setAction(record.getAction());
                existingRecord.setPublicUrl(record.getPublicUrl());
                existingRecord.setAccessCategory(record.getAccessCategory());
                existingRecord.setFreeViewExpiry(record.getFreeViewExpiry());
                existingRecord.setDescription(record.getDescription());
                existingRecord.setFeatureImagePath(record.getFeatureImagePath());
                existingRecord.setPdfImagePath(record.getPdfImagePath());

                // Save the updated record
                return recordRepository.save(existingRecord);
            } else {
                throw new IllegalArgumentException("Record not found for update");
            }
        } catch (IllegalArgumentException e) {
            logger.error("Record not found for update with ID: {}", id);
            emailService.sendMail("chouhanakash779.ac@gmail.com", "Error: Record not found for update", "Record not found for update with ID: " + id);
            throw e;
        } catch (Exception e) {
            logger.error("Failed to update record", e);
            emailService.sendMail("chouhanakash779.ac@gmail.com", "Error: Failed to update record", "Failed to update record with ID: " + id);
            throw new RuntimeException("Failed to update record");
        }
    }
    @Override
    public void deleteRecord(int id) {
        try {
            recordRepository.deleteById(id);
        } catch (Exception e) {
            emailService.sendMail("chouhanakash779.ac@gmail.com", "New Record Added", "Failed to delete record");
            logger.error("Failed to delete record with ID: {}", id, e);
            throw new RuntimeException("Failed to delete record");
        }
    }
}
