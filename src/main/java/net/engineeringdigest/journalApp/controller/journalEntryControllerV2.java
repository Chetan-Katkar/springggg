package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.journalEntry;
import net.engineeringdigest.journalApp.service.journalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/journal")
public class journalEntryControllerV2 {

    @Autowired
    private journalEntryService jes;

    @GetMapping
    public List<journalEntry> getAll() {
        return jes.getAll();
    }

    @PostMapping
    public journalEntry createEntry(@RequestBody journalEntry entry) {
        entry.setDateTime(LocalDateTime.now());
        jes.saveEntry(entry);
        return entry;
    }

    @GetMapping("/id/{id}")
    public Optional<journalEntry> getEntryById(@PathVariable ObjectId id) {
        return jes.findById(id);
    }

    @DeleteMapping
    public boolean deleteAll() {
        return jes.deleteAll();
    }
    @DeleteMapping("/id/{id}")
    public void deleteEntryById(@PathVariable ObjectId id) {
        jes.deletebyId(id);
    }

    @PutMapping("id/{id}")
    public journalEntry update(@PathVariable ObjectId id, @RequestBody journalEntry newEntry) {
        journalEntry old = jes.findById(id).orElse(null);
        if (old != null) {
            old.setContent(newEntry.getTittle() != null && newEntry.getTittle().equals("") ? newEntry.getTittle() : old.getTittle());
            old.setContent(newEntry.getContent() != null && newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
        }
        jes.saveEntry(old);
        return old;
    }
}
