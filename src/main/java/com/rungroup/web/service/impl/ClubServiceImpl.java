package com.rungroup.web.service.impl;

import com.rungroup.web.dto.ClubDTO;
import com.rungroup.web.model.Club;
import com.rungroup.web.repository.ClubRepo;
import com.rungroup.web.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {
    private ClubRepo clubRepo;

    @Autowired
    public ClubServiceImpl(ClubRepo clubRepo) {
        this.clubRepo = clubRepo;
    }

    @Override
    public List<ClubDTO> findAllClubs() {
         List<Club> clubs= clubRepo.findAll();
         return clubs.stream().map((club)->mapToClubDto(club)).collect(Collectors.toList());
    }

    //maper that takes club and convert into DTO
    private ClubDTO mapToClubDto(Club club) {
        ClubDTO clubDto= ClubDTO.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdTime(club.getCreatedTime())
                .updatedTime((club.getUpdatedTime()))
                .build();

        return clubDto;
    }



}
