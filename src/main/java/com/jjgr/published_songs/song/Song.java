package com.jjgr.published_songs.song;

import java.sql.Date;
import java.time.Duration;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Song {
    @Id
    @SequenceGenerator(
        name = "song_sequence",
        sequenceName = "song_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "song_sequence"        
    )
    private Long id;
    private String name, artist, album, timeRange;
    private boolean published;
    private Date publicationDate;
    private Duration totalDuration;
    

    // public Song(){}

    // public Song(Long id, String name, String artist, String album, String timeRange, boolean published, Date publicationDate, Duration totalDuration){
    //     this.id = id;
    //     this.name = name;
    //     this.artist = artist;
    //     this.album = album;
    //     this.timeRange = timeRange;
    //     this.published = published;
    //     this.publicationDate = publicationDate;
    //     this.totalDuration = totalDuration;
    // }

    // public Song(String name, String artist, String album, String timeRange, boolean published, Date publicationDate, Duration totalDuration){
    //     this.name = name;
    //     this.artist = artist;
    //     this.album = album;
    //     this.timeRange = timeRange;
    //     this.published = published;
    //     this.publicationDate = publicationDate;
    //     this.totalDuration = totalDuration;
    // }

    
}
