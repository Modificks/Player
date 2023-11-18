package com.player.player.services.servicesImp;

import com.player.player.entities.Song;
import com.player.player.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SongRepositoryImp {

    private final SongRepository songRepository;

    @Autowired
    public SongRepositoryImp(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }
}