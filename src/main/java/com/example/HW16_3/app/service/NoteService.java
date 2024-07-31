package com.example.HW16_3.app.service;

import com.example.HW16_3.app.exception.BadRequestException;
import com.example.HW16_3.app.mapper.NoteMapper;
import com.example.HW16_3.app.model.Note;
import com.example.HW16_3.app.model.NoteResponse;
import com.example.HW16_3.app.model.NoteUpdateRequest;
import com.example.HW16_3.app.repositopy.NoteRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    private final NoteMapper noteMapper;
/*
    public NoteService(@Qualifier(value = "paymentClient") RestTemplate client, NoteRepository customerRepository,
                       NoteMapper customerMapper) {
        this.noteRepository = customerRepository;
        this.noteMapper = customerMapper;
    }
*/
    public NoteService(NoteRepository noteRepository, NoteMapper noteMapper) {
        this.noteRepository = noteRepository;
        this.noteMapper = noteMapper;
    }

    public NoteResponse getById(Integer id) {
         return noteMapper.toNoteResponse(
                noteRepository.findById(id)
                        .orElseThrow(BadRequestException::new)
        );
    }

    public NoteResponse getByTitle(String title) {
          return noteMapper.toNoteResponse(noteRepository.getNotesByTitle(title)
                .orElseThrow(BadRequestException::new));
    }
/*
    public void getByTitle() {
        noteRepository.getNotesByTitleOrContent("shop", "buy bread")
                .forEach(System.out::println);
    }
*/
    public void deleteById(Integer id) {
        noteRepository.deleteById(id);
    }

    public List<Note> findAll() {
        return (List<Note>) noteRepository.findAll();
    }

 /*   public Note create(Note note) {
        return noteRepository.save(note);
    }
/*
    @Transactional
    public NoteResponse update(Long id, NoteUpdateRequest request) {
        Note note = noteRepository.findById(id).orElseThrow();
        note.setTitle(request.getTitle());
        note.setContent(request.getContext());
        return noteMapper.toNoteResponse(note);
    }
*/
}
