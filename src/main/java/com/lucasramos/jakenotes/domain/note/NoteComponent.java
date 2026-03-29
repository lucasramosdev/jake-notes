package com.lucasramos.jakenotes.domain.note;

import com.lucasramos.jakenotes.domain.note.document.NoteDocument;
import com.lucasramos.jakenotes.domain.note.document.NoteDocumentService;
import com.lucasramos.jakenotes.dto.NoteDto;
import com.lucasramos.jakenotes.dto.covers.NoteCoverDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NoteComponent {

    @Autowired
    private NoteService noteService;

    @Autowired
    private NoteDocumentService noteDocumentService;

    @Autowired
    private NoteMapper noteMapper;

    public List<NoteCoverDto> getRecentNotes() {
        List<Note> notes = noteService.getRecentNotes();
        return notes.stream().map(noteMapper::toNoteCoverDto).toList();
    }

    public Page<NoteCoverDto> searchNotes(String query, int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<NoteDocument> documents = noteDocumentService.searchNotes(query, pageable);
        return new PageImpl<>(documents.stream().map(noteMapper::toNoteCoverDto).toList(), pageable, documents.getTotalElements());
    }

    public List<NoteCoverDto> getNotesByFolderId(Long id) {
        List<Note> notes = noteService.getNotesByFolderId(id);
        return notes.stream().map(noteMapper::toNoteCoverDto).toList();
    }

    public NoteDto getNoteById(Long id) {
        Note note = noteService.getNote(id);
        return noteMapper.toNoteDto(note);
    }
}