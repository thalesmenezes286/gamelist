package com.dev.gamelistapi.servicies;

import com.dev.gamelistapi.dto.GameDTO;
import com.dev.gamelistapi.dto.GameMinDTO;
import com.dev.gamelistapi.entities.Game;
import com.dev.gamelistapi.projections.GameMinProjection;
import com.dev.gamelistapi.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    /*
     * Retorna uma lista de games
     */
    @Transactional
    public List<GameMinDTO> findAll()
    {
        List<Game> result = gameRepository.findAll();

        //Transforma uma Lista de Games em um Objeto DTO
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();

        return dto;
    }

    /*
     * Retorna uma
     */
    @Transactional(readOnly = true)
    public GameDTO findById(Long id)
    {
        Game result = gameRepository.findById(id).get();

        return new GameDTO(result);
    }

    @Transactional
    public List<GameMinDTO> findByList(Long listId)
    {
        /*
         *  Realiza uma pesquisa por ListId
         *  retorna projection
         */
        List<GameMinProjection> result = gameRepository.searchByList(listId);

        //Transforma uma Lista de Games em um Objeto DTO
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();

        return dto;
    }
}
