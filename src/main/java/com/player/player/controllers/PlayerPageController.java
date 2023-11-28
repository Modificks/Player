package com.player.player.controllers;

import com.player.player.entities.PlayList;
import com.player.player.entities.Song;
import com.player.player.services.servicesImp.PlayListRepositoryImp;
import com.player.player.services.servicesImp.SongRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class PlayerPageController {

    private final SongRepositoryImp songRepositoryImp;

    private final PlayListRepositoryImp playListRepositoryImp;

    @Autowired
    public PlayerPageController(SongRepositoryImp songRepositoryImp, PlayListRepositoryImp playListRepositoryImp) {
        this.songRepositoryImp= songRepositoryImp;
        this.playListRepositoryImp = playListRepositoryImp;
    }

    @GetMapping("/player/{userId}")
    public String getPlayerPage(@PathVariable Long userId, Model model) {
        List<Song> listOfSongs = songRepositoryImp.getAllSongs();
        List<PlayList> listOfPlayLists = playListRepositoryImp.getAllPlayLists(userId);

        model.addAttribute("songs", listOfSongs);
        model.addAttribute("play_lists", listOfPlayLists);

        return "PlayerPage";
    }

    @PostMapping("/player/{userId}")
    public String addSongToPlayList(@RequestParam("playlistId") Long playlistId,
                                    @RequestParam("songId") Long songId,
                                    @PathVariable Long userId) {
        playListRepositoryImp.addToPlaylist(playlistId, songId);
        return "PlayerPage";
    }
}