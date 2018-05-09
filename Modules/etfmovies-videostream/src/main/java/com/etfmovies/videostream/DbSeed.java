package com.etfmovies.videostream;


import com.etfmovies.videostream.models.Video;
import com.etfmovies.videostream.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class DbSeed {
    private VideoRepository videoRepository;

    @Autowired
    public DbSeed(VideoRepository videoRepository){
        this.videoRepository = videoRepository;
    }

    @EventListener
    public void Seed(ContextRefreshedEvent event){
        seedVideoTable();
    }

    private void seedVideoTable(){
        List<Video> videos = videoRepository.findAll();

        if(videos == null || videos.size() <= 0){
            videoRepository.save (new Video("http//"));
            }
    }


}
