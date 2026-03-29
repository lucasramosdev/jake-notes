package com.lucasramos.jakenotes.domain.note.document;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meilisearch.sdk.Client;
import com.meilisearch.sdk.Index;
import com.meilisearch.sdk.SearchRequest;
import com.meilisearch.sdk.model.SearchResultPaginated;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class NoteDocumentRepository {

    @Autowired
    final Client meilisearchClient;

    @Autowired
    final ObjectMapper objectMapper;


    public Page<NoteDocument> search(String query, Pageable pageable) {
        List<NoteDocument> notes = new ArrayList<>();

        Index index = meilisearchClient.index("notes");

        SearchRequest searchRequest = SearchRequest.builder()
                .q(query)
                .page(pageable.getPageNumber() + 1)
                .hitsPerPage(pageable.getPageSize())
                .offset(pageable.getPageSize() * pageable.getPageNumber())
                .build();

        SearchResultPaginated response = (SearchResultPaginated) index.search(searchRequest);

        response.getHits().forEach(hit -> {
            NoteDocument note = objectMapper.convertValue(hit, NoteDocument.class);
            notes.add(note);
        });

        return new PageImpl<>(notes, pageable, response.getTotalHits());
    }
}