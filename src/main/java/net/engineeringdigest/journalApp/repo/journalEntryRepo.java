package net.engineeringdigest.journalApp.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import net.engineeringdigest.journalApp.entity.journalEntry;

public interface journalEntryRepo extends MongoRepository<journalEntry, String> {

}
