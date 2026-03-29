package com.lucasramos.jakenotes.domain.note;

import com.lucasramos.jakenotes.domain.note.document.NoteDocument;
import com.lucasramos.jakenotes.domain.topic.TopicMapper;
import com.lucasramos.jakenotes.dto.NoteDto;
import com.lucasramos.jakenotes.dto.TopicDto;
import com.lucasramos.jakenotes.dto.covers.NoteCoverDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Component
public class NoteMapper {

    @Autowired
    private TopicMapper topicMapper;

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

    public NoteDto toNoteDto(Note entity) {
        if(isNull(entity)) return null;
        List<TopicDto> topics = entity.getTopics().stream().map(topicMapper::toTopicDto).toList();
        return NoteDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .topics(topics)
                .tags(entity.getTags())
                .summary(entity.getSummary())
                .build();
    }
}