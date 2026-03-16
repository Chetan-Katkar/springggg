package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.journalEntry;
import net.engineeringdigest.journalApp.repo.journalEntryRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class journalEntryService {

    @Autowired
    private journalEntryRepo jer;

    public void saveEntry(journalEntry je) {
        jer.save(je);
    }

    public List<journalEntry> getAll() {
        return jer.findAll();
    }

    public Boolean deleteAll() {
        jer.deleteAll();
        return true;
    }

    public void deletebyId(ObjectId id) {
        jer.deleteById(String.valueOf(id));;
    }

    public Optional<journalEntry> findById(ObjectId id) {
        return jer.findById(String.valueOf(id));
    }


}
