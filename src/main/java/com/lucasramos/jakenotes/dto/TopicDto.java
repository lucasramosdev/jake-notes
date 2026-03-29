package com.lucasramos.jakenotes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopicDto {

    private Long id;
    private String keyword;
    private String details;

}