package com.lucasramos.jakenotes.domain.folder;

import java.util.List;

public interface FolderService {

    List<Folder> getTopFiveFolders();

    Folder getFolder(Long id);
}