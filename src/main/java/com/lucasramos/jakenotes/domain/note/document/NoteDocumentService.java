package com.lucasramos.jakenotes.domain.note.document;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface NoteDocumentService {

    Page<NoteDocument> searchNotes(String query, Pageable pageable);

}