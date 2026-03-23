package com.lucasramos.jakenotes.domain.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class NoteServiceImpl implements NoteService {

    private final int MAX_HOME_SCREEN_NOTES = 10;

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note getNote(Long id) {
        return noteRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Note with id " + id + " not found")
        );
    }

    @Override
    public List<Note> getRecentNotes() {
        PageRequest pageable = PageRequest.of(0, MAX_HOME_SCREEN_NOTES, Sort.by(Sort.Direction.DESC, "createdAt"));
        return noteRepository.findAll(pageable).stream().toList();
    }
}