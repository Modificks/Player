package com.player.player.services.servicesImp;

import com.player.player.entities.PlayList;
import com.player.player.entities.Song;
import com.player.player.entities.User;
import com.player.player.enums.PlayListType;
import com.player.player.repositories.PlayListRepository;
import com.player.player.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayListRepositoryImp {

    private final PlayListRepository playListRepository;

    private final SongRepository songRepository;

    @Autowired
    public PlayListRepositoryImp(PlayListRepository playListRepository, SongRepository songRepository) {
        this.playListRepository = playListRepository;
        this.songRepository = songRepository;
    }

    public PlayList getPlaylistById(Long playlistId) {
        return playListRepository.findById(playlistId).orElse(null);
    }

    public void addToPlaylist(Long playListId, Long songId) {
        PlayList playlist = getPlaylistById(playListId);
        Song song = songRepository.findById(songId).orElse(null);

        if (playlist != null && song != null) {
            playlist.getPlayListsMusic().add(song);
            playListRepository.save(playlist);
        }
    }

    public void createDefaultPlayListsForUser(User user) {
        PlayList mainPlayList = new PlayList();

        mainPlayList.setUser(user);
        mainPlayList.setType(PlayListType.MAIN);

        PlayList likedPlayList = new PlayList();

        likedPlayList.setUser(user);
        likedPlayList.setType(PlayListType.LIKED);

        playListRepository.save(mainPlayList);
        playListRepository.save(likedPlayList);
    }
}