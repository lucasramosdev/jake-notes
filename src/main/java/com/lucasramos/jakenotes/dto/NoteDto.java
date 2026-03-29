package com.lucasramos.jakenotes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteDto {

    private Long id;
    private String title;
    private String summary;
    private List<String> tags = new ArrayList<>();
    private List<TopicDto> topics = new ArrayList<>();

}