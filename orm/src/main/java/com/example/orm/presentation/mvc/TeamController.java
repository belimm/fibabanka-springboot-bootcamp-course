package com.example.orm.presentation.mvc;


import com.example.orm.data.repository.TeamRepository;
import com.example.orm.data.entity.Player;
import com.example.orm.data.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/sports")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/team/insert")
    @ResponseBody
    private String insertTeam(){

        Team teamA = new Team(0L, "Godoro Spor");
        teamA.setPlayerList(new ArrayList<>());

        Player player1 = new Player(0L,"Cem",54.21);
        Player player2 = new Player(1L,"Cem Karaca",12.54);
        Player player3 = new Player(2L,"Toto Karaca",34.61);



        teamA.getPlayerList().add(player1);
        teamA.getPlayerList().add(player2);
        teamA.getPlayerList().add(player3);

        teamRepository.save(teamA);

        return "Eklendi " +"";

    }



}
