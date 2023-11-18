package com.player.player.controllers;

import com.player.player.entities.Song;
import com.player.player.services.servicesImp.SongRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class PlayerPageController {

    private final SongRepositoryImp songRepositoryImp;

    @Autowired
    public PlayerPageController(SongRepositoryImp songRepositoryImp) {
        this.songRepositoryImp= songRepositoryImp;
    }

    @GetMapping("/player")
    public String getPlayerPage(Model model) {
        List<Song> listOfSongs = songRepositoryImp.getAllSongs();

        model.addAttribute("songs", listOfSongs);
        return "PlayerPage";
    }
}