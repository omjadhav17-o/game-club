package com.rungroup.web.service;

import com.rungroup.web.dto.ClubDTO;

import java.util.List;

public interface ClubService {
    List<ClubDTO> findAllClubs();
}
