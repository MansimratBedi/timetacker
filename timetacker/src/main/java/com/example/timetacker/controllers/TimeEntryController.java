package com.example.timetacker.controllers;

import com.example.timetacker.model.TimeEntry;
import com.example.timetacker.service.TimeEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

    @RestController
    @RequestMapping("/time-entries")
    public class TimeEntryController {

        @Autowired
        private TimeEntryService timeEntryService;

        @GetMapping
        public List<TimeEntry> getAllTimeEntries() {
            return timeEntryService.getAllTimeEntries();
        }

        @GetMapping("/{id}")
        public ResponseEntity<TimeEntry> getTimeEntryById(@PathVariable Long id) {
            Optional<TimeEntry> timeEntry = timeEntryService.getTimeEntryById(id);
            return timeEntry.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @PostMapping
        public TimeEntry createTimeEntry(@RequestBody TimeEntry timeEntry) {
            return timeEntryService.createTimeEntry(timeEntry);
        }

        @PutMapping("/{id}")
        public ResponseEntity<TimeEntry> updateTimeEntry(@PathVariable Long id, @RequestBody TimeEntry timeEntryDetails) {
            return ResponseEntity.ok(timeEntryService.updateTimeEntry(id, timeEntryDetails));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteTimeEntry(@PathVariable List<Long> ids) {
            timeEntryService.deleteTimeEntry(ids);
            return ResponseEntity.noContent().build();
        }
    }


