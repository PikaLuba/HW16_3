package com.example.HW16_3.app.repositopy;

import com.example.HW16_3.app.model.Note;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends CrudRepository<Note, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM note c WHERE c.title = :title")
    Optional<Note> getNotesByTitle(@Param("title")String title);


    List<Note> getNotesByTitleOrContent(String title, String content);

    List<Note> findByTitle(String Title);

    Optional<Note> findById(Integer id);

    Iterable<Note> findAll();

    }
