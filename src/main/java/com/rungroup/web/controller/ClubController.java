package com.rungroup.web.controller;


import com.rungroup.web.dto.ClubDTO;
import com.rungroup.web.model.Club;
import com.rungroup.web.service.ClubService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ClubController {

    private ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/clubs")
    public String listClubs(Model model)
    {
        List<ClubDTO> clubs= clubService.findAllClubs();
         model.addAttribute("clubs", clubs);
        return "club-list";
    }
}
