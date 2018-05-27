package com.etfmovies.videoinfo;


import com.etfmovies.videoinfo.models.*;
import com.etfmovies.videoinfo.repositories.VideoRepository;
import com.etfmovies.videoinfo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.GregorianCalendar;

@Component
public class DbSeed {

    private VideoRepository _videoRepository;
    private EpisodesRepository _episodesRepository;
    private ShowsRepository _showsRepository;
    private CategoryRepository _categoryRepository;
    private VideoDataRepository videoDataRepository;
    private ReviewRepository reviewRepository;

    @Autowired
    public DbSeed(VideoRepository videoRepository, EpisodesRepository episodesRepository, CategoryRepository categoryRepository, ShowsRepository showsRepository, VideoDataRepository videoDataRepository, ReviewRepository reviewRepository){
        _videoRepository =videoRepository;
        _episodesRepository=episodesRepository;
        _showsRepository=showsRepository;
        _categoryRepository=categoryRepository;
        this.videoDataRepository = videoDataRepository;
        this.reviewRepository = reviewRepository;
    }

    @EventListener
    public void Seed(ContextRefreshedEvent event){
        seedCategoryTable();
        seedVideosTable();
        seedVideoDataTable();
        seedReviewsTable();
        seedShowsTable();
        seedEpisodesTable();
    }

    private void seedVideosTable(){
        List<Video> videos =_videoRepository.findAll();
        if(videos == null || videos.size() <= 0){
             Category category = _categoryRepository.findByCategoryName("Action");
             String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis finibus laoreet luctus. Donec tempus, turpis a ornare blandit, sapien justo volutpat enim, ac vehicula ante massa ut magna. Mauris id condimentum magna, ut faucibus tortor. Phasellus nec risus ut mi placerat commodo. Vivamus blandit viverra dolor vel luctus. Mauris eu mollis leo,";
             _videoRepository.save( new Video("Title1" , 1L, new GregorianCalendar(2017,2,4).getTime(), "http://seanpaune.com/wp-content/uploads/2016/11/Fantastic-Beasts-and-Where-To-Find-Them-banner-200x200.jpg", loremIpsum, category, Collections.emptyList()));
             _videoRepository.save( new Video("Title2" , 2L, new GregorianCalendar(2017,2,4).getTime(), "http://seanpaune.com/wp-content/uploads/2016/11/Kong-Skull-Island-trailer-2-200x200.jpg", loremIpsum, category, Collections.emptyList()));

             category = _categoryRepository.findByCategoryName("Comedy");
             _videoRepository.save( new Video("Title3" , 3L, new GregorianCalendar(2017,2,4).getTime(), "http://seanpaune.com/wp-content/uploads/2016/11/Moana-banner-200x200.jpg", loremIpsum, category, Collections.emptyList()));
             _videoRepository.save( new Video("Title4" , 4L, new GregorianCalendar(2017,2,4).getTime(), "http://seanpaune.com/wp-content/uploads/2016/11/Valerian-and-the-City-of-a-Thousand-Planets-01-200x200.jpg", loremIpsum, category, Collections.emptyList()));
             _videoRepository.save( new Video("Title5" , 5L, new GregorianCalendar(2017,2,4).getTime(), "http://seanpaune.com/wp-content/uploads/2016/11/Vampire-Lestat-200x200.jpg", loremIpsum, category, Collections.emptyList()));
        }
    }

    private void seedVideoDataTable() {
        List<VideoData> videodata = videoDataRepository.findAll();

        if(videodata == null || videodata.size() <= 0) {
            Video video = _videoRepository.findById(1l).get();
            videoDataRepository.save(new VideoData(120, 1080, "wmv", video,"C:"));

            video = _videoRepository.findById(2l).get();
            videoDataRepository.save(new VideoData(90, 1080, "avi", video,"C:"));

            video = _videoRepository.findById(3l).get();
            videoDataRepository.save(new VideoData(190, 1080, "avi", video,"C:"));

            video = _videoRepository.findById(4l).get();
            videoDataRepository.save(new VideoData(135, 1080, "mkv", video,"C:"));

            video = _videoRepository.findById(5l).get();
            videoDataRepository.save(new VideoData(122, 1080, "mkv", video,"C:"));
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
        }
    }

    private void seedReviewsTable(){
        List<Review> reviews = reviewRepository.findAll();

        if(reviews == null || reviews.size() <= 0){
            Video video = _videoRepository.findByTitle("Title5");
            reviewRepository.save(new Review("Good", new GregorianCalendar(2017,2,4).getTime(), 1l, 8, video));
        }
    }

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




