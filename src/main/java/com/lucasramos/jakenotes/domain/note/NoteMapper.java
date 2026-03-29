package com.lucasramos.jakenotes.domain.note;

import com.lucasramos.jakenotes.domain.note.document.NoteDocument;
import com.lucasramos.jakenotes.dto.covers.NoteCoverDto;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Component
public class NoteMapper {

    public NoteCoverDto toNoteCoverDto(Note entity) {
        if(isNull(entity)) return null;
        String createdAt = HoursForNoteCoverChain.getCreatedAtForNoteCover(entity.getCreatedAt());
        NoteCoverDto noteCover = NoteCoverDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .summary(entity.getSummary())
                .createdAt(createdAt)
                .tags(entity.getTags())
                .build();

        if(nonNull(entity.getFolder())) {
            noteCover.setFolderName(entity.getFolder().getName());
        }

        return noteCover;
    }

    public NoteCoverDto toNoteCoverDto(NoteDocument document) {
        if(isNull(document)) return null;
        String createdAt = HoursForNoteCoverChain.getCreatedAtForNoteCover(document.getCreatedAt());
        NoteCoverDto noteCover = NoteCoverDto.builder()
                .id(document.getId())
                .title(document.getTitle())
                .summary(document.getSummary())
                .folderName(document.getFolderName())
                .createdAt(createdAt)
                .tags(document.getTags())
                .build();

        return noteCover;
    }
}