package com.rungroup.web.Mapper;

import com.rungroup.web.dto.ClubDTO;
import com.rungroup.web.model.Club;

import java.util.stream.Collectors;

import static com.rungroup.web.Mapper.EventMapper.mapToEventDto;

public class ClubMapper {
    public static Club mapToClub(ClubDTO club) {
        Club clubDto = Club.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdTime(club.getCreatedTime())
                .updatedTime(club.getUpdatedTime())
                .build();
        return  clubDto;
    }

    public static ClubDTO mapToClubDto(Club club) {
        ClubDTO clubDto= ClubDTO.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdTime(club.getCreatedTime())
                .updatedTime((club.getUpdatedTime()))
                .events(club.getEvents().stream().map((event) -> mapToEventDto(event)).collect(Collectors.toList()))
                .build();

        return clubDto;
    }
}