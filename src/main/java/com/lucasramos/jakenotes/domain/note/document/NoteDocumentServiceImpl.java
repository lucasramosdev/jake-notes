package com.lucasramos.jakenotes.domain.note.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class NoteDocumentServiceImpl implements NoteDocumentService{

    @Autowired
    private NoteDocumentRepository noteDocumentRepository;

    @Override
    public Page<NoteDocument> searchNotes(String query, Pageable pageable) {
        return noteDocumentRepository.search(query, pageable);
    }

}