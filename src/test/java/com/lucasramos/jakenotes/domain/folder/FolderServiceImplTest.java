package com.lucasramos.jakenotes.domain.folder;


import com.lucasramos.jakenotes.domain.note.Note;
import com.lucasramos.jakenotes.domain.note.NoteRepository;
import com.lucasramos.jakenotes.shared.JakeNotesIntegrationTest;
import com.lucasramos.jakenotes.mock.MockFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FolderServiceImplTest extends JakeNotesIntegrationTest {

    @Autowired
    private MockFactory mockFactory;

    @Autowired
    private FolderRepository folderRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private FolderService folderService;

    private Folder saveFolderWithNotes(String name, int numOfNotes) {
        Folder folder = folderRepository.save(mockFactory.buildFolder(name));
        List<Note> notes = new ArrayList<>();
        for (int i = 0; i < numOfNotes; i++) {
            notes.add(noteRepository.save(mockFactory.buildNoteForFolder(folder.getId(), String.valueOf(i))));
        }
        folder.setNotes(notes);
        return folder;
    }

    @Nested
    class Given_list_of_folders extends JakeNotesIntegrationTest {

        private List<Folder> listOfFolders = new ArrayList<>();

        @Nested
        class When_get_the_top_five_folders_with_more_notes extends JakeNotesIntegrationTest {

            private final int NUMBER_OF_FOLDERS = 5;

            @BeforeEach
            void setUp() {
                listOfFolders.clear();
                folderRepository.deleteAll();
                folderRepository.save(mockFactory.buildFolder("First Folder"));
                saveFolderWithNotes("Second Folder", 3);
                saveFolderWithNotes("Third Folder", 2);
                saveFolderWithNotes("Fourth Folder", 1);
                saveFolderWithNotes("Fifth Folder", 5);
                saveFolderWithNotes("Sixth Folder", 4);
                listOfFolders = folderService.getTopFiveFolders();
            }

            @Test
            void Then_should_return_folders_sorted_by_number_of_notes_desc() {
                assertEquals(5, listOfFolders.getFirst().getNotes().size());
                assertEquals(1, listOfFolders.getLast().getNotes().size());
            }

            @Test
            void Then_should_return_only_five_folders() {
                assertEquals(NUMBER_OF_FOLDERS, listOfFolders.size());
            }

        }
    }

    @Nested
    class Given_a_folder extends JakeNotesIntegrationTest {
        private Folder folder;

        @Nested
        class When_get_folder extends JakeNotesIntegrationTest {

            private Folder folderResponse;

            @BeforeEach
            void setUp() {
                folder = saveFolderWithNotes("Folder to get", 1);
                folderResponse = folderService.getFolder(folder.getId());
            }

            @Test
            void Then_should_return_the_folder() {
                assertEquals(folder.getId(), folderResponse.getId());
                assertEquals(folder.getName(), folderResponse.getName());
                assertEquals(folder.getParent(), folderResponse.getParent());
                assertEquals(folder.getChildren().size(), folderResponse.getChildren().size());
                assertEquals(folder.getNotes().getFirst().getTitle(), folderResponse.getNotes().getFirst().getTitle());
            }

        }

        @Nested
        class When_get_folder_not_exists extends JakeNotesIntegrationTest {

            private Long id = 1L;

            @BeforeEach
            void setUp() {
                folderRepository.deleteAll();
            }

            @Test
            void Then_should_throws_not_such_element_exception() {
                assertThrows(NoSuchElementException.class, () -> folderService.getFolder(id));
            }
        }

    }
}