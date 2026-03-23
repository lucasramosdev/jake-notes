package com.lucasramos.jakenotes.domain.folder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;

import java.util.List;

public interface FolderRepository extends JpaRepository<Folder, Long> {

    @NativeQuery(value = "SELECT f.* FROM Folders f " +
    "JOIN Notes n ON f.id = n.folder_id " +
    "GROUP BY f.id " +
    "ORDER BY COUNT(n.folder_id) DESC " +
    "LIMIT 5")
    List<Folder> findFirst5ByOrderByNotesCountDesc();
}