package com.wvitorsj.dslistbackendaula.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wvitorsj.dslistbackendaula.dto.GameListDTO;
import com.wvitorsj.dslistbackendaula.entities.GameList;
import com.wvitorsj.dslistbackendaula.repositories.GameListRepository;

@Service
public class GameListService {
    
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> resultList = gameListRepository.findAll();

        return resultList.stream().map(x -> new GameListDTO(x)).toList();
    }
}
