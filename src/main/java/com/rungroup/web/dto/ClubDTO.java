package com.rungroup.web.dto;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ClubDTO {
    private int id;
    private String title;
    private String photoUrl;
    private String content;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private List<EventDto> events;
}
