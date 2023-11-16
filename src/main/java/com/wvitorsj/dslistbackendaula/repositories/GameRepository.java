package com.wvitorsj.dslistbackendaula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wvitorsj.dslistbackendaula.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
    
}
