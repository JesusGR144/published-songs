package com.jjgr.published_songs.song;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SongService {
    private final SongRepository songRepository;

    public SongService(SongRepository songRepository){
        this.songRepository = songRepository;
    }

    public List<Song> getSongs(){
        return songRepository.findAll();
    }
}
