package com.player.player.controllers;

import com.player.player.entities.PlayList;
import com.player.player.entities.Song;
import com.player.player.entities.User;
import com.player.player.services.servicesImp.PlayListRepositoryImp;
import com.player.player.services.servicesImp.SongRepositoryImp;
import com.player.player.services.servicesImp.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PlayerPageController {

    private final SongRepositoryImp songRepositoryImp;

    private final PlayListRepositoryImp playListRepositoryImp;

    private final UserServiceImp userServiceImp;

    @GetMapping("/player")
    public String getPlayerPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User user = userServiceImp.findByEmail(username);
        Long userId = user.getId();

        List<Song> listOfSongs = songRepositoryImp.getAllSongs();
        List<PlayList> listOfPlayLists = playListRepositoryImp.getAllPlayLists(userId);
        List<Song> listOfSongInPlayList = songRepositoryImp.getSongsByPlaylistId(userId);

        model.addAttribute("songs_in_liked_play_list", listOfSongInPlayList);
        model.addAttribute("songs", listOfSongs);
        model.addAttribute("play_lists", listOfPlayLists);
        model.addAttribute("userId", userId);

        return "PlayerPage";
    }

    @PostMapping("/player")
    public String addOrRemoveSongFromPlaylist(@RequestParam("playlistId") Long playlistId,
                                              @RequestParam("songId") Long songId,
                                              @RequestParam("action") String action) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        authentication.getPrincipal();

        switch (action){
            case "add" -> playListRepositoryImp.addToPlaylist(playlistId, songId);
            case "remove" -> playListRepositoryImp.removeFromPlaylist(playlistId, songId);
        }

        return "redirect:/player";
    }
}