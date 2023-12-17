package com.player.player.services.servicesImp;

import com.player.player.entities.Song;
import com.player.player.repositories.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SongRepositoryImp {

    private final SongRepository songRepository;

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public List<Song> getSongsByPlaylistId(Long userId) {
        return songRepository.findSongsByPlaylistId(userId);
    }
}