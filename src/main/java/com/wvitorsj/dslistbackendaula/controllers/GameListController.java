package com.wvitorsj.dslistbackendaula.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;

import com.wvitorsj.dslistbackendaula.dto.GameListDTO;
import com.wvitorsj.dslistbackendaula.dto.GameMinDTO;
import com.wvitorsj.dslistbackendaula.dto.ReplacementDTO;
import com.wvitorsj.dslistbackendaula.services.GameListService;
import com.wvitorsj.dslistbackendaula.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;

    
    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListService.findAll();

        return result;
    }
    
    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        List<GameMinDTO> result = gameService.findByList(listId);

        return result;
    }
    
    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {

        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());

    }
    
}
