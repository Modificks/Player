package com.player.player.repositories;

import com.player.player.entities.Song;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface SongRepository extends CrudRepository<Song, Long> {

    List<Song> findAll();

    @Query("SELECT p.playListsMusic FROM PlayList p WHERE p.user.id = :userId")
    List<Song> findSongsByPlaylistId(Long userId);
}