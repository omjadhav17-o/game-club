package com.rungroup.web.controller;


import com.rungroup.web.dto.ClubDTO;
import com.rungroup.web.model.Club;
import com.rungroup.web.service.ClubService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/clubs/{clubId}")
    public String detailOfClub(@PathVariable("clubId") int clubId,Model model)
    {
        ClubDTO clubDto=clubService.getClubById(clubId);
        model.addAttribute("club",clubDto);
        return "club-details";
    }

    @GetMapping("/clubs/search")
    public String searchClub(@RequestParam(value = "querry") String querry, Model model)
    {
       List<ClubDTO> clubs=clubService.searchClub(querry);
       model.addAttribute("clubs",clubs);
       return "club-list";
    }

    @GetMapping("/clubs/new")
    public String createClubFrom(Model model)
    {
        Club club=new Club();
        model.addAttribute("club",club);
        return "club-create";
    }

    @PostMapping("clubs/new")
    public String saveFrom(@ModelAttribute("club") Club club)
    {
        clubService.saveClub(club);
        return "redirect:/clubs";
    }

    @GetMapping("/clubs/{clubId}/edit")
    public String editForm(@PathVariable("clubId") int clubId,Model model)
    {

        ClubDTO club=clubService.getClubById(clubId);
        model.addAttribute("club",club);
        return "club-edit";
    }

    @PostMapping("/clubs/{clubId}/edit")
    public String editForm(@PathVariable("clubId") int clubId,@ModelAttribute("club") ClubDTO club)
    {
        club.setId(clubId);
        clubService.updateClub(club);
        return "redirect:/clubs";
    }
}
