package com.player.player.repositories;

import com.player.player.entities.PlayList;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PlayListRepository extends CrudRepository<PlayList, Long> {
    List<PlayList> findByUserId(Long userId);
}