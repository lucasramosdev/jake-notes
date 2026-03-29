package com.lucasramos.jakenotes.domain.topic;

import com.lucasramos.jakenotes.dto.TopicDto;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class TopicMapper {

    public TopicDto toTopicDto(Topic entity) {
        if (isNull(entity)) return null;
        return TopicDto.builder()
                .id(entity.getId())
                .keyword(entity.getKeyword())
                .details(entity.getDetails())
                .build();
    }
}