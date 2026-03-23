package com.lucasramos.jakenotes.domain.folder;

import com.lucasramos.jakenotes.domain.note.Note;
import com.lucasramos.jakenotes.infra.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "folders")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Folder extends BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "parent_id")
    private Long parent;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "parent")
    @Builder.Default
    private List<Folder> children = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "folder")
    @Builder.Default
    private List<Note> notes = new ArrayList<>();
}