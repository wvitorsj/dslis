package com.wvitorsj.dslistbackendaula.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wvitorsj.dslistbackendaula.dto.GameMinDTO;
import com.wvitorsj.dslistbackendaula.entities.Game;
import com.wvitorsj.dslistbackendaula.repositories.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
       List<Game> result = gameRepository.findAll();
       
       return result.stream().map(x -> new GameMinDTO(x)).toList();

    }
    
}
