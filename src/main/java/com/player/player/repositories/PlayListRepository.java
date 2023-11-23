package com.player.player.repositories;

import com.player.player.entities.PlayList;
import org.springframework.data.repository.CrudRepository;

public interface PlayListRepository extends CrudRepository<PlayList, Long> {
}