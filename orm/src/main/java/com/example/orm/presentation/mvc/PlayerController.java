package com.example.orm.presentation.mvc;

import com.example.orm.configuration.MyBean;
import com.example.orm.data.repository.PlayerRepository;
import com.example.orm.data.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sports")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private MyBean myBean;

    @GetMapping("/players/byteam/{teamId}")
    @ResponseBody
    public String getPlayersByTeam(@PathVariable("teamId") Long teamId){


        System.out.println(myBean.getMyString());

        List<Player> players = playerRepository.findAllByTeamId(teamId);
        double totalScore =0;

        for(Player p:players){
            totalScore+=p.getAverageScore();
            System.out.println(p);
        }
        double averageScore = 0;
        if(players.size()>0){
            averageScore =totalScore/players.size();
        }
        return "Ortalama "+averageScore;
    }
}
