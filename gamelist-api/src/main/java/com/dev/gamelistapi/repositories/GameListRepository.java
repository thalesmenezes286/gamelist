package com.dev.gamelistapi.repositories;

import com.dev.gamelistapi.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
