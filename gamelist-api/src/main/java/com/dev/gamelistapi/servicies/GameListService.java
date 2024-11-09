package com.dev.gamelistapi.servicies;

import com.dev.gamelistapi.dto.GameListDTO;
import com.dev.gamelistapi.entities.GameList;
import com.dev.gamelistapi.repositories.GameListRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    /*
     * Retorna uma lista de games
     */
    @Transactional
    public List<GameListDTO> findAll()
    {
        List<GameList> result = gameListRepository.findAll();

        //Transforma uma Lista de Games em um Objeto DTO
        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();

        return dto;
    }
}
