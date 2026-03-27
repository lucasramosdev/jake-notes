package com.lucasramos.jakenotes.domain.note;

import com.lucasramos.jakenotes.dto.NoteCoverDto;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Component
public class NoteMapper {

    public NoteCoverDto toNoteCoverDto(Note entity) {
        if(isNull(entity)) return null;
        NoteCoverDto noteCover = NoteCoverDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .build();

        if(nonNull(entity.getFolder())) {
            noteCover.setFolderName(entity.getFolder().getName());
        }

        return noteCover;
    }
}