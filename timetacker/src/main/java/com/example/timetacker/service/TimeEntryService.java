package com.example.timetacker.service;

import com.example.timetacker.model.TimeEntry;
import com.example.timetacker.repository.TimeEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeEntryService {

    @Autowired
    private TimeEntryRepository timeEntryRepository;

    public List<TimeEntry> getAllTimeEntries() {
        return timeEntryRepository.findAll();
    }

    public Optional<TimeEntry> getTimeEntryById(Long id) {
        return timeEntryRepository.findById(id);
    }

    public TimeEntry createTimeEntry(TimeEntry timeEntry) {
        return timeEntryRepository.save(timeEntry);
    }

    public TimeEntry updateTimeEntry(Long id, TimeEntry timeEntryDetails) {
        TimeEntry timeEntry = timeEntryRepository.findById(id).orElseThrow();
        timeEntry.setDescription(timeEntryDetails.getDescription());
        timeEntry.setStartTime(timeEntryDetails.getStartTime());
        timeEntry.setEndTime(timeEntryDetails.getEndTime());
        return timeEntryRepository.save(timeEntry);
    }

    public void deleteTimeEntry(List<Long> ids) {
        timeEntryRepository.deleteAllById(ids);
    }
}

