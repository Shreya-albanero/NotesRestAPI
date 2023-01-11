package com.example.demo.controller;

import com.example.demo.entity.Notes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repository.NotesRepo;

import java.util.List;

@RestController
public class NotesController {
    @Autowired
    private NotesRepo notesRepo;

    @PostMapping("/addNotes")
    public String addNotes(@RequestBody Notes notes) {
        notesRepo.save(notes);
        return "added successfully";
    }

    /*@GetMapping("/getNotes")
    public List<Notes> getNotes() {
        List<Notes> notesList = notesRepo.findAll();
        System.out.println(notesList);
        return notesList;
    }*/

    @DeleteMapping("/{id}")
    public String deleteNotes(@PathVariable int id) {
        notesRepo.deleteById(id);
        return "deleted successfully";
    }

    @PutMapping("/updateNotes/{id}")
    public Notes updateNotes(@RequestBody Notes notes, @PathVariable int id) {
        Notes n=new Notes();
        n.setDescription(notes.getDescription());
        return notesRepo.save(notes);
    }
}
