package com.player.player.services.servicesImp;

import com.player.player.entities.PlayList;
import com.player.player.entities.Song;
import com.player.player.entities.User;
import com.player.player.enums.PlayListType;
import com.player.player.repositories.PlayListRepository;
import com.player.player.repositories.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PlayListRepositoryImp {

    private final PlayListRepository playListRepository;

    private final SongRepository songRepository;

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

    public void removeFromPlaylist(Long playlistId, Long songId) {
        PlayList playlist = playListRepository.findById(playlistId).orElse(null);
        Song song = songRepository.findById(songId).orElse(null);

        if (playlist != null && song != null) {
            Set<Song> songsInPlaylist = playlist.getPlayListsMusic();
            if (songsInPlaylist.contains(song)) {
                songsInPlaylist.remove(song);
                playlist.setPlayListsMusic(songsInPlaylist);
                playListRepository.save(playlist);
            }
        }
    }

    public void createDefaultPlayListsForUser(User user) {
//        PlayList mainPlayList = new PlayList();
//
//        mainPlayList.setUser(user);
//        mainPlayList.setType(PlayListType.MAIN);

        PlayList likedPlayList = new PlayList();

        likedPlayList.setUser(user);
        likedPlayList.setType(PlayListType.LIKED);

//        playListRepository.save(mainPlayList);
        playListRepository.save(likedPlayList);
    }

    public List<PlayList> getAllPlayLists(Long userId) {
        return playListRepository.findByUserId(userId);
    }
}