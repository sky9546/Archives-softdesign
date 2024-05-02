package com.Spring.demo.controller;

import com.Spring.demo.emailService.EmailService;
import com.Spring.demo.modal.Record;
import com.Spring.demo.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class RecordController {
    @Autowired
    private RecordService recordService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public ModelAndView getAllStudents() {
        ModelAndView mav = new ModelAndView("records");
        List<Record> records = recordService.getAllRecords();
        mav.addObject("records", records);
        return mav;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Record> getRecordById(@PathVariable("id") int id) {
        Record record = recordService.getRecordById(id);
        if (record != null) {
            return new ResponseEntity<>(record, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save-record")
    public String addRecord(@ModelAttribute Record record, @RequestParam("article_date") String article_date) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(article_date);
            record.setDate(date);
            recordService.addRecord(record);
            return "redirect:/";
        } catch (ParseException e) {
            e.printStackTrace();
            return "redirect:/error";
        }
    }


    /*   @PostMapping("/save-student")
    public String saveStaff(@ModelAttribute Student student) {
        studentService.save(student);
        return "redirect:/";
    }*/
    @GetMapping("/add-record")
    public ModelAndView addRecord() {
        ModelAndView mav = new ModelAndView("add-record");
        mav.addObject("add-record", new Record());

        return mav;
    }
    @GetMapping("/view-record")
    public ModelAndView viewRecord() {
        ModelAndView mav = new ModelAndView("view-record");
        mav.addObject("view-record", new Record());
        return mav;
    }
    @GetMapping("/update-record/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        // Fetch record from database using id and add it to the model
        Record record = recordService.getRecordById(id);
        model.addAttribute("record", record);
        return "update-record";
    }

    @PostMapping("/update-record/{id}")
    public String updateRecord(@PathVariable("id") int id, @ModelAttribute  Record updatedRecord, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "update-record";
        }

        recordService.updateRecord(id, updatedRecord);
        return "redirect:/";
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable("id") int id) {
        recordService.deleteRecord(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
