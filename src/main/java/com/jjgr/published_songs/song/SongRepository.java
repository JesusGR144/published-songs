package com.jjgr.published_songs.song;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long>{
    @Query("SELECT s FROM Song s WHERE s.name = ?1")
    Optional<Song> findByName(String name);

    void deleteByName(String name);
}
