package com.wvitorsj.dslistbackendaula.dto;

import com.wvitorsj.dslistbackendaula.entities.GameList;

public class GameListDTO {
    private Long id;
    private String name;

    public GameListDTO() {        
    }

    public GameListDTO(GameList entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }    
}
