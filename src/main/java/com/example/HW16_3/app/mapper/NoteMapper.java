package com.example.HW16_3.app.mapper;

import com.example.HW16_3.app.model.Note;
import com.example.HW16_3.app.model.NoteResponse;
import com.example.HW16_3.app.model.NoteUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface NoteMapper {

    NoteResponse toNoteResponse(Note note);

    Note toEntity(NoteUpdateRequest request);
}

