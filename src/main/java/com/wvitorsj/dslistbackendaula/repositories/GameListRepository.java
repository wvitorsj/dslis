package com.wvitorsj.dslistbackendaula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wvitorsj.dslistbackendaula.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {
    
}
