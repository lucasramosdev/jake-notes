package com.lucasramos.jakenotes.domain.note;

import com.lucasramos.jakenotes.dto.NoteCoverDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NoteComponent {

    @Autowired
    private NoteService noteService;

    @Autowired
    private NoteMapper noteMapper;

    public List<NoteCoverDto> getRecentNotes() {
        List<Note> notes = noteService.getRecentNotes();
        return notes.stream().map(noteMapper::toNoteCoverDto).toList();
    }

}
