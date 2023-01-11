package com.example.demo.repository;

import com.example.demo.entity.Notes;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NotesRepo extends MongoRepository <Notes, Integer> {

    List<Notes> findAll();
}
