package com.jjgr.published_songs.song;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("api/songs")
public class SongController {
    private final SongService songService;

    //Constructor
    public SongController(SongService songService){
        this.songService =songService;
    }

    //GET ALL
    @GetMapping("getAll")
    public List<Song> getAll(){
        return songService.getSongs();
    }

    //POST
    @PostMapping("addSong")
    public void addSong(@RequestBody Song song){
        songService.addSong(song);
    }

    //DELETE BY ID
    @DeleteMapping(path = "{songId}")
    public void deleteSong(@PathVariable("songId")Long songId){
        songService.deleteSong(songId);
    }

    //DELETE BY NAME
    @DeleteMapping(path = "{songName}")
    public void deleteSong(@PathVariable("songName") String songName){
        songService.deleteSong(songName);
    }

    //PUT BY ID
    @PutMapping(path = "{songId}")
    public Song updateSong(@PathVariable("songId") Long songId, @RequestBody Song updatedSong){
        return songService.updateSong(songId, updatedSong);
    }

    //PUT BY NAME
    @PutMapping(path = "{songName}")
    public Song updatedSong(@PathVariable("songName") String songName, @RequestBody Song updatedSong){
        return songService.updateSong(songName, updatedSong);
    }
}
