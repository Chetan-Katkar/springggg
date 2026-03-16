package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.journalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class journalEntryController {
    private Map<Long, journalEntry> je = new HashMap<>();

    @GetMapping("/abc")
    public List<journalEntry> getAll() {
        return new ArrayList<>(je.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody journalEntry entry) {
        je.put(entry.getId(), entry);
        return true;
    }

    @GetMapping("/id/{id}")
    public journalEntry getEnteryById(@PathVariable Long id) {
        return je.get(id);
    }

    @DeleteMapping("/id/{id}")
    public journalEntry deleteEnteryById(@PathVariable Long id) {
        return je.remove(id);
    }

    @PutMapping("id/{id}")
    public journalEntry update(@PathVariable Long id, @RequestBody journalEntry myEntry) {
        return je.put(id, myEntry);
    }
}
