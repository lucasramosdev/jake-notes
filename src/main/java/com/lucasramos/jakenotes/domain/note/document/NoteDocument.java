package com.lucasramos.jakenotes.domain.note.document;

import com.lucasramos.jakenotes.domain.topic.Topic;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NoteDocument {

    @Id
    private Long id;
    private String folderName;
    private String title;
    private String summary;

    @Builder.Default
    private List<String> tags = new ArrayList<>();

    @Builder.Default
    private List<Topic> topics = new ArrayList<>();

    private OffsetDateTime createdAt;
}