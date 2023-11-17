package com.wvitorsj.dslistbackendaula.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wvitorsj.dslistbackendaula.dto.GameListDTO;
import com.wvitorsj.dslistbackendaula.entities.GameList;
import com.wvitorsj.dslistbackendaula.projections.GameMinProjection;
import com.wvitorsj.dslistbackendaula.repositories.GameListRepository;
import com.wvitorsj.dslistbackendaula.repositories.GameRepository;

@Service
public class GameListService {
    
    @Autowired
    private GameListRepository gameListRepository;
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> resultList = gameListRepository.findAll();

        return resultList.stream().map(x -> new GameListDTO(x)).toList();
    }

    @Transactional
    public void move(Long listId, int sourecIndex, int destinationIndex) {

        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourecIndex);
        list.add(destinationIndex, obj);

        int min = sourecIndex < destinationIndex ? sourecIndex : destinationIndex;
        int max = sourecIndex < destinationIndex ? destinationIndex : sourecIndex;

        for (int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
