package com.jjgr.published_songs.song;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService {
    private final SongRepository songRepository;

    @Autowired
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    // GET all
    public List<Song> getSongs() {
        return songRepository.findAll();
    }

    // POST
    public void addSong(Song song) {
        Optional<Song> songIsPresent = songRepository.findByName(song.getName());

        if (songIsPresent.isPresent()) {
            throw new IllegalStateException("El nombre " + song.getName() + " ya esta registrado");
        }
        songRepository.save(song);
    }

    // DELETE BY ID
    public void deleteSong(Long id) {
        boolean songExists = songRepository.existsById(id);
        if (songExists) {
            throw new IllegalStateException("La canción con id " + id + " no existe");
        }
        songRepository.deleteById(id);
    }

    // DELETE BY NAME
    public void deleteSong(String name) {
        Optional<Song> songOptional = songRepository.findByName(name);
        if (!songOptional.isPresent()) {
            throw new IllegalStateException("La canción con el nombre " + name + " no existe");
        }
        songRepository.deleteByName(name);
    }

    // UPDATE BY ID
    public Song updateSong(Long id, Song updatedSong) {
        return songRepository.findById(id)
                .map(existingSong -> {
                    if (updatedSong.getName() != null)
                        existingSong.setName(updatedSong.getName());
                    if (updatedSong.getArtist() != null)
                        existingSong.setArtist(updatedSong.getArtist());
                    if (updatedSong.getAlbum() != null)
                        existingSong.setAlbum(updatedSong.getAlbum());
                    if (updatedSong.getTimeRange() != null)
                        existingSong.setTimeRange(updatedSong.getTimeRange());
                    if (updatedSong.getPublicationDate() != null)
                        existingSong.setPublicationDate(updatedSong.getPublicationDate());
                    if (updatedSong.getTotalDuration() != null)
                        existingSong.setTotalDuration(updatedSong.getTotalDuration());
                    existingSong.setPublished(updatedSong.isPublished());
                    return songRepository.save(existingSong);
                })
                .orElseThrow(() -> new IllegalStateException("Canción con ID " + id + " no existe"));
    }

    // UPDATE BY NAME
    public Song updateSong(String name, Song updatedSong) {
        return songRepository.findByName(name)
                .map(existingSong -> {
                    if (updatedSong.getName() != null)
                        existingSong.setName(updatedSong.getName());
                    if (updatedSong.getArtist() != null)
                        existingSong.setArtist(updatedSong.getArtist());
                    if (updatedSong.getAlbum() != null)
                        existingSong.setAlbum(updatedSong.getAlbum());
                    if (updatedSong.getTimeRange() != null)
                        existingSong.setTimeRange(updatedSong.getTimeRange());
                    if (updatedSong.getPublicationDate() != null)
                        existingSong.setPublicationDate(updatedSong.getPublicationDate());
                    if (updatedSong.getTotalDuration() != null)
                        existingSong.setTotalDuration(updatedSong.getTotalDuration());
                    existingSong.setPublished(updatedSong.isPublished());
                    return songRepository.save(existingSong);
                })
                .orElseThrow(() -> new IllegalStateException("Canción con nombre " + name + " no existe"));
    }

}

// @PutMapping(path = "{id}")
// public Song updateSong(
// @PathVariable("id") Long id,
// @RequestBody Song updatedSong) {
// return songService.updateSong(id, updatedSong);
// }
