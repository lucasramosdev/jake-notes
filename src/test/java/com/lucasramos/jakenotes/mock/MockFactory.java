package com.lucasramos.jakenotes.mock;

import com.lucasramos.jakenotes.domain.folder.Folder;
import com.lucasramos.jakenotes.domain.note.Note;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MockFactory {

    public Folder buildFolder(String name) {
        return Folder.builder().name(name).build();
    }

    public Note buildNoteForFolder(Long folderId, String name) {
        String title = String.format("Note %s for Folder %d", name, folderId);
        return Note.builder().title(title).folder(folderId).build();
    }

    public Note buildNote(String title) {
        return Note.builder().title(title).build();
    }

    public Note buildNote(String title, List<String> tags) {
        return Note.builder().title(title).tags(tags).build();
    }
}