package com.dev.gamelistapi.repositories;

import com.dev.gamelistapi.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
