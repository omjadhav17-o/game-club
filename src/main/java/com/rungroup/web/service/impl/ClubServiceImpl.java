package com.rungroup.web.service.impl;

import com.rungroup.web.dto.ClubDTO;
import com.rungroup.web.model.Club;
import com.rungroup.web.repository.ClubRepo;
import com.rungroup.web.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.rungroup.web.Mapper.ClubMapper.mapToClub;
import static com.rungroup.web.Mapper.ClubMapper.mapToClubDto;

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

    @Override
    public Club saveClub(Club club) {
        return clubRepo.save(club);
     }

    @Override
    public ClubDTO getClubById(int cludId) {
        Club club= clubRepo.findById(cludId).get();
        return mapToClubDto(club);
    }

    @Override
    public void updateClub(ClubDTO clubDto) {
        Club club=mapToClub(clubDto);
        clubRepo.save(club);
    }

    @Override
    public List<ClubDTO> searchClub(String Querry) {
       List<Club> clublist= clubRepo.searchClubs(Querry);

       return clublist.stream().map(club -> mapToClubDto(club)).collect(Collectors.toList());
    }





}
