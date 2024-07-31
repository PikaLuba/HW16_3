package com.example.HW16_3.app.controller;

import com.example.HW16_3.app.model.Note;
import com.example.HW16_3.app.model.NoteResponse;
import com.example.HW16_3.app.model.NoteUpdateRequest;
import com.example.HW16_3.app.service.NoteService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;
    private final Note note;

 /*   @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Note create(@RequestBody Note note) {
        return noteService.create(note);
    }
*/
    @GetMapping("/edit/{id}")
    public NoteResponse findById(@PathVariable Integer id) {
        return noteService.getById(id);
    }

    @GetMapping
    public NoteResponse findByTitle(@RequestParam String title) {
        return noteService.getByTitle(title);
    }
/*
    @PutMapping("/{id}")
    public NoteResponse updateNote(@PathVariable Long id, @RequestBody NoteUpdateRequest request) {
        return noteService.update(id, request);
    }
*/
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        try {
            noteService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            //Bad practice
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/findAll")
    public List<Note> findAll() {
        return noteService.findAll();
    }
}

