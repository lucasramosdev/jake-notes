package com.lucasramos.jakenotes.domain.note;

import java.util.List;

public interface NoteService {

    Note saveNote(Note note);

    Note getNote(Long id);

    List<Note> getRecentNotes();

}