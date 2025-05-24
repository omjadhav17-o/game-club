package com.rungroup.web.repository;

import com.rungroup.web.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClubRepo extends JpaRepository<Club,Long> {

    Optional<Club> findById(int aint);
}

