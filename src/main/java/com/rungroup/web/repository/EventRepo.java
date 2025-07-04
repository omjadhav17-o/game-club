package com.rungroup.web.repository;

import com.rungroup.web.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<Event,Long> {

}
