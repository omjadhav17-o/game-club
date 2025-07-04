package com.rungroup.web.service;

import com.rungroup.web.dto.ClubDTO;
import com.rungroup.web.model.Club;

import java.util.List;

public interface ClubService {
    List<ClubDTO> findAllClubs();

    Club saveClub(Club club);

    ClubDTO getClubById(int clubId);

    void updateClub(ClubDTO club);

    List<ClubDTO> searchClub(String Querry);
}
