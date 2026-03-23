package com.lucasramos.jakenotes.domain.folder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FolderServiceImpl implements FolderService {

    @Autowired
    private FolderRepository folderRepository;

    @Override
    public List<Folder> getTopFiveFolders() {
        return folderRepository.findFirst5ByOrderByNotesCountDesc();
    }

    @Override
    public Folder getFolder(Long id) {
        return folderRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Folder with id " + id + " not found")
        );
    }

}