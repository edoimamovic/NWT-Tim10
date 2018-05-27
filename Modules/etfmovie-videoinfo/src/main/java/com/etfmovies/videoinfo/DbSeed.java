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
    private VideoImageRepository videoImageRepository;

    @Autowired
    public DbSeed(VideoRepository videoRepository, VideoImageRepository videoImageRepository, EpisodesRepository episodesRepository, CategoryRepository categoryRepository, ShowsRepository showsRepository, VideoDataRepository videoDataRepository, ReviewRepository reviewRepository){
        _videoRepository = videoRepository;
        this.videoImageRepository = videoImageRepository;
        _episodesRepository = episodesRepository;
        _showsRepository = showsRepository;
        _categoryRepository = categoryRepository;
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
            Category category = _categoryRepository.findByCategoryName("Drama");
            String loremIpsum = "The Shawshank Redemption is a highly-acclaimed movie starring Tim Robbins and Morgan Freeman. Andy Dufresne is convicted of the murder of his wife and her lover, and sentenced to life imprisonment at Shawshank prison. Life seems to have taken a turn for the worse, but fortunately Andy befriends some of the other inmates, in particular a character known only as Red. Over time Andy finds ways to live out life with relative ease as one can in a prison, leaving a message for all that while the body may be locked away in a cell, the spirit can never be truly imprisoned.";
            _videoRepository.save( new Video("The Shawshank Redemption" , 1L, new GregorianCalendar(2017,2,4).getTime(), "https://ia.media-imdb.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg", loremIpsum, category));

             loremIpsum = "When the aging head of a famous crime family decides to transfer his position to one of his subalterns, a series of unfortunate events start happening to the family, and a war begins between all the well-known families leading to insolence, deportation, murder and revenge, and ends with the favorable successor being finally chosen.";
            _videoRepository.save( new Video("The Godfather" , 2L, new GregorianCalendar(2017,2,4).getTime(), "https://ia.media-imdb.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SY1000_CR0,0,704,1000_AL_.jpg", loremIpsum, category));

             loremIpsum = "Pulp Fiction is a movie starring John Travolta, Samuel L. Jackson, and Uma Thurman. Vincent Vega (John Travolta) and Jules Winnfield (Samuel L. Jackson) are two hit men on the hunt for a briefcase whose contents were stolen from their boss, Marsellus Wallace. They run into a few unexpected detours along the road. Marsellus is out of town, and he's gotten Vincent to take care of his wife, Mia (Uma Thurman). Things go smoothly until one of them makes a huge error.";
            _videoRepository.save( new Video("Pulp Fiction" , 5L, new GregorianCalendar(2017,2,4).getTime(), "https://ia.media-imdb.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SY1000_CR0,0,686,1000_AL_.jpg", loremIpsum, category));

            loremIpsum = "An insomniac office worker, looking for a way to change his life, crosses paths with a devil-may-care soapmaker, forming an underground fight club that evolves into something much, much more.";
            _videoRepository.save( new Video("Fight Club" , 4L, new GregorianCalendar(2017,2,4).getTime(), "https://ia.media-imdb.com/images/M/MV5BMjM1NzUwMjgtZDMyZC00OTdmLWE2YjYtMzQxOTg5MDY4MTQzXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SY1000_CR0,0,666,1000_AL_.jpg", loremIpsum, category));
            category = _categoryRepository.findByCategoryName("Action");

            loremIpsum = "When the menace known as the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham. The Dark Knight must accept one of the greatest psychological and physical tests of his ability to fight injustice.";
            _videoRepository.save( new Video("The Dark Knight" , 3L, new GregorianCalendar(2017,2,4).getTime(), "https://ia.media-imdb.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_SY1000_CR0,0,675,1000_AL_.jpg", loremIpsum, category));
        }
    }

    private void seedVideoDataTable() {
        List<VideoData> videodata = videoDataRepository.findAll();
        List<VideoImage> images = videoImageRepository.findAll();

        if(videodata == null || videodata.size() <= 0) {
            Video video = _videoRepository.findById(1l).get();
            videoDataRepository.save(new VideoData(142, 1080, "wmv", video,"C:"));
            videoImageRepository.save(new VideoImage(video, "https://ia.media-imdb.com/images/M/MV5BMTkzMTY0MjE5MV5BMl5BanBnXkFtZTcwODMxNDY3Mw@@._V1_SY1000_CR0,0,1526,1000_AL_.jpg"));
            videoImageRepository.save(new VideoImage(video, "https://ia.media-imdb.com/images/M/MV5BNTYxOTYyMzE3NV5BMl5BanBnXkFtZTcwOTMxNDY3Mw@@._V1_SX1480_CR0,0,1480,999_AL_.jpg"));
            videoImageRepository.save(new VideoImage(video, "https://ia.media-imdb.com/images/M/MV5BMTgxMTU1MDkwOV5BMl5BanBnXkFtZTcwMDQxNDY3Mw@@._V1_SY1000_CR0,0,1487,1000_AL_.jpg"));
            videoImageRepository.save(new VideoImage(video, "https://ia.media-imdb.com/images/M/MV5BMTQ5NTI4NDAxMV5BMl5BanBnXkFtZTcwMTQxNDY3Mw@@._V1_SY1000_CR0,0,1496,1000_AL_.jpg"));
            videoImageRepository.save(new VideoImage(video, "https://ia.media-imdb.com/images/M/MV5BMTMxNzAwMzE0Nl5BMl5BanBnXkFtZTcwNDQxNDY3Mw@@._V1_SY1000_CR0,0,1513,1000_AL_.jpg"));

            video = _videoRepository.findById(2l).get();
            videoDataRepository.save(new VideoData(90, 1080, "avi", video,"C:"));
            videoImageRepository.save(new VideoImage(video, "https://ia.media-imdb.com/images/M/MV5BZTg5M2NiNzktZDFkNy00Y2Q5LWIzOWUtYTZkYzkzZTA1NjQwXkEyXkFqcGdeQXVyNjUwNzk3NDc@._V1_.jpg"));
            videoImageRepository.save(new VideoImage(video, "https://ia.media-imdb.com/images/M/MV5BMWM4MWI5NjgtYWFiZC00MWEzLThhNjMtNGUyZjAyYWIxNGZhXkEyXkFqcGdeQXVyNjUwNzk3NDc@._V1_.jpg"));
            videoImageRepository.save(new VideoImage(video, "https://ia.media-imdb.com/images/M/MV5BYzhkOTE2ZDktYWQ2Yy00ZDNmLWIxZDEtMWI4ZGEzNjRmZGE3XkEyXkFqcGdeQXVyNjUwNzk3NDc@._V1_.jpg"));
            videoImageRepository.save(new VideoImage(video, "https://ia.media-imdb.com/images/M/MV5BNzc0YzFmNjYtY2EyMy00ZGEwLWE4YTItMzVhMzlhMmY0MGY0XkEyXkFqcGdeQXVyNjUwNzk3NDc@._V1_.jpg"));

            video = _videoRepository.findById(3l).get();
            videoDataRepository.save(new VideoData(190, 1080, "avi", video,"C:"));
            videoImageRepository.save(new VideoImage(video, "https://ia.media-imdb.com/images/M/MV5BMjE1ODYxOTkxOF5BMl5BanBnXkFtZTgwNTE4OTEwMjE@._V1_SY1000_CR0,0,1463,1000_AL_.jpg"));
            videoImageRepository.save(new VideoImage(video, "https://ia.media-imdb.com/images/M/MV5BMjAyMjUyNzg1Ml5BMl5BanBnXkFtZTgwNzAwMzg5MTE@._V1_SY1000_CR0,0,1506,1000_AL_.jpg"));
            videoImageRepository.save(new VideoImage(video, "https://ia.media-imdb.com/images/M/MV5BMTAwNDE5MzkyNzZeQTJeQWpwZ15BbWU4MDAwMDM4OTEx._V1_SY1000_CR0,0,1501,1000_AL_.jpg"));
            videoImageRepository.save(new VideoImage(video, "https://ia.media-imdb.com/images/M/MV5BNzcyNTQyNzg3OF5BMl5BanBnXkFtZTgwMTAwMzg5MTE@._V1_SY1000_CR0,0,1535,1000_AL_.jpg"));

            video = _videoRepository.findById(4l).get();
            videoDataRepository.save(new VideoData(135, 1080, "mkv", video,"C:"));
            videoImageRepository.save(new VideoImage(video, "http://www.anarresproject.org/wp-content/uploads/2017/02/fight-club.jpg"));
            videoImageRepository.save(new VideoImage(video, "https://ia.media-imdb.com/images/M/MV5BMTgxNzY2NjIxOV5BMl5BanBnXkFtZTcwNzU3ODMzMw@@._V1_SY1000_CR0,0,1413,1000_AL_.jpg"));
            videoImageRepository.save(new VideoImage(video, "https://d3c1jucybpy4ua.cloudfront.net/data/42912/big_picture/Fight_Club.jpg?1456149270"));
            videoImageRepository.save(new VideoImage(video, "http://images.mentalfloss.com/sites/default/files/styles/mf_image_16x9/public/fightclub_1.jpg?itok=m0JPyrl4&resize=1100x619"));

            video = _videoRepository.findById(5l).get();
            videoDataRepository.save(new VideoData(122, 1080, "mkv", video,"C:"));
            videoImageRepository.save(new VideoImage(video, "https://ia.media-imdb.com/images/M/MV5BMTM5NjA1OTYyOV5BMl5BanBnXkFtZTcwMzgzMTk2Mw@@._V1_SX1777_CR0,0,1777,742_AL_.jpg"));
            videoImageRepository.save(new VideoImage(video, "https://ia.media-imdb.com/images/M/MV5BMTM1NTcwMTk4OV5BMl5BanBnXkFtZTcwOTczMTk2Mw@@._V1_SX1777_CR0,0,1777,756_AL_.jpg"));
            videoImageRepository.save(new VideoImage(video, "https://ia.media-imdb.com/images/M/MV5BMTM1Njc5NTE0M15BMl5BanBnXkFtZTcwMDgzMTk2Mw@@._V1_SX1777_CR0,0,1777,756_AL_.jpg"));
            videoImageRepository.save(new VideoImage(video, "https://ia.media-imdb.com/images/M/MV5BMTgzMzkyNjAwOV5BMl5BanBnXkFtZTcwNzgzMTk2Mw@@._V1_SX1777_CR0,0,1777,747_AL_.jpg"));
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
            _categoryRepository.save( new Category("Drama"));
        }
    }

    private void seedReviewsTable(){
        List<Review> reviews = reviewRepository.findAll();

        if(reviews == null || reviews.size() <= 0){
            Video video = _videoRepository.findById(3l).get();
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
