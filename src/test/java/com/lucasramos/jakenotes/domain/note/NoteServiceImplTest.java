package com.lucasramos.jakenotes.domain.note;

import com.lucasramos.jakenotes.mock.MockFactory;
import com.lucasramos.jakenotes.shared.JakeNotesIntegrationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class NoteServiceImplTest extends JakeNotesIntegrationTest {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private NoteService noteService;

    @Autowired
    private MockFactory mockFactory;


    @Nested
    class Given_a_note extends JakeNotesIntegrationTest {
        private Note note;

        @Nested
        class When_get_a_note extends JakeNotesIntegrationTest {
            private final String noteName = "Note to save";
            private Note savedNote;
            @BeforeEach
            void setUp() {
                noteRepository.deleteAll();
                savedNote= noteRepository.save(mockFactory.buildNote(noteName));
                note = noteService.getNote(savedNote.getId());
            }

            @Test
            void Should_return_the_note() {
                assertEquals(savedNote.getId(), note.getId());
                assertEquals(noteName, note.getTitle());
            }
        }

        @Nested
        class When_get_a_note_not_exists extends JakeNotesIntegrationTest {

            private Long id = 1L;

            @BeforeEach
            void setUp() {
                noteRepository.deleteAll();
            }

            @Test
            void Then_should_throws_not_such_element_exception() {
                assertThrows(NoSuchElementException.class, () -> noteService.getNote(id));
            }
        }

        @Nested
        class When_save_a_note extends JakeNotesIntegrationTest {
            private final String noteName = "Note saved";
            private Note noteToSave;
            @BeforeEach
            void setUp() {
                noteRepository.deleteAll();
                noteToSave = mockFactory.buildNote(noteName);
                note = noteService.saveNote(noteToSave);
            }

            @Test
            void Should_return_saved_note() {
                assertEquals(noteName, note.getTitle());
            }
        }

        @Nested
        class When_save_a_note_with_tags extends JakeNotesIntegrationTest {
            private final String noteName = "Note saved";
            private final List<String> tags = List.of("Tag1", "Tag2");
            private Note noteToSave;
            @BeforeEach
            void setUp() {
                noteRepository.deleteAll();
                noteToSave = mockFactory.buildNote(noteName, tags);
                note = noteService.saveNote(noteToSave);
            }

            @Test
            void Should_return_saved_note() {
                assertEquals(noteName, note.getTitle());
                assertEquals(tags.size(), note.getTags().size());
                assertTrue(note.getTags().contains(tags.getFirst()));
                assertTrue(note.getTags().contains(tags.getLast()));
            }
        }
    }

    @Nested
    class Given_a_list_of_notes extends JakeNotesIntegrationTest {
        private List<Note> notes;

        @Nested
        class When_get_recent_notes extends JakeNotesIntegrationTest {

        }
    }
}