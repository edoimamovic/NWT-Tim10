package com.etfmovies.videoinfo;


import com.etfmovies.videoinfo.models.*;
import com.etfmovies.videoinfo.repositories.VideoRepository;
import com.etfmovies.videoinfo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.GregorianCalendar;

@Component
public class DbSeed {

    private VideoRepository _videoRepository;
    private EpisodesRepository _episodesRepository;
    private ShowsRepository _showsRepository;
    private CategoryRepository _categoryRepository;

    @Autowired
    public DbSeed(VideoRepository videoRepository, EpisodesRepository episodesRepository, CategoryRepository categoryRepository, ShowsRepository showsRepository){
        _videoRepository =videoRepository;
        _episodesRepository=episodesRepository;
        _showsRepository=showsRepository;
        _categoryRepository=categoryRepository;
    }

    @EventListener
    public void Seed(ContextRefreshedEvent event){
        seedCategoryTable();
        seedVideosTable();
        seedShowsTable();
        seedEpisodesTable();
    }

    private void seedVideosTable(){
        List<Video> videos =_videoRepository.findAll();
         if(videos == null || videos.size() <= 0){
             _videoRepository.save( new Video("title1" , 1L, new GregorianCalendar(2017,2,4).getTime(), "http://seanpaune.com/wp-content/uploads/2016/11/Fantastic-Beasts-and-Where-To-Find-Them-banner-200x200.jpg"));
             _videoRepository.save( new Video("title2" , 2L, new GregorianCalendar(2017,2,4).getTime(), "http://seanpaune.com/wp-content/uploads/2016/11/Kong-Skull-Island-trailer-2-200x200.jpg"));
             _videoRepository.save( new Video("title3" , 3L, new GregorianCalendar(2017,2,4).getTime(), "http://seanpaune.com/wp-content/uploads/2016/11/Moana-banner-200x200.jpg"));
             _videoRepository.save( new Video("title4" , 4L, new GregorianCalendar(2017,2,4).getTime(), "http://seanpaune.com/wp-content/uploads/2016/11/Valerian-and-the-City-of-a-Thousand-Planets-01-200x200.jpg"));
             _videoRepository.save( new Video("title5" , 5L, new GregorianCalendar(2017,2,4).getTime(), "http://seanpaune.com/wp-content/uploads/2016/11/Vampire-Lestat-200x200.jpg"));


         }
    }
    private void seedCategoryTable(){
        List<Category> categories =_categoryRepository.findAll();
        if(categories== null || categories.size() <= 0){
            _categoryRepository.save( new Category("Comedy"));
            _categoryRepository.save( new Category("Action"));
            _categoryRepository.save( new Category("Thriller"));
            _categoryRepository.save( new Category("Horror"));
            _categoryRepository.save( new Category("Romance"));
            _categoryRepository.save( new Category("Adventure"));
            _categoryRepository.save( new Category("Fantasy"));
        }}

    private void seedShowsTable(){
        List<Show> shows = _showsRepository.findAll();
        if(shows== null || shows.size() <= 0){
            _showsRepository.save( new Show("title1"));
            _showsRepository.save( new Show("title2"));
            _showsRepository.save( new Show("title3"));
            _showsRepository.save( new Show("title4"));
            }
    }

    private void seedEpisodesTable() {
        List<Episode> episodes =  _episodesRepository.findAllByShowTitle("title1");
        if (episodes == null || episodes.size() <= 0) {
            Show s = _showsRepository.findByTitle("title1");
            Video v = _videoRepository.findAll().get(0);
            _episodesRepository.save(new Episode(1, 1, "title od episode 1", s, v));
            _episodesRepository.save(new Episode(1, 2, "title od episode 2", s, v));
            _episodesRepository.save(new Episode(1, 3, "title od episode 3", s, v));
        }
    }
}




