package com.dev.gamelistapi.servicies;

import com.dev.gamelistapi.dto.GameMinDTO;
import com.dev.gamelistapi.entities.Game;
import com.dev.gamelistapi.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    public List<GameMinDTO> findAll(){
        List<Game> result = repository.findAll();

        return result.stream().map(GameMinDTO::new).toList();
    }
}
