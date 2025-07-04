package com.rungroup.web.repository;

import com.rungroup.web.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClubRepo extends JpaRepository<Club,Long> {

    Optional<Club> findById(int aint);

    @Query("SELECT c from Club c WHERE c.title LIKE CONCAT('%', :query, '%')")
    List<Club> searchClubs(String query);

}

