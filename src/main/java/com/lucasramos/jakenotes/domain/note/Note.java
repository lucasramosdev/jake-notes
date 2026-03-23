package com.lucasramos.jakenotes.domain.note;

import com.lucasramos.jakenotes.domain.topic.Topic;
import com.lucasramos.jakenotes.infra.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "notes")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Note extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "folder_id")
    private Long folder;

    @Column(nullable = false)
    private String title;

    @Column
    private String summary;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "notes_tags", joinColumns = @JoinColumn(name = "note_id"))
    @Column(name = "tag_value", nullable = false)
    @Builder.Default
    private List<String> tags = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "note")
    @Builder.Default
    private List<Topic> topics = new ArrayList<>();
}