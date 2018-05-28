package com.etfmovies.videoinfo.services;

import com.etfmovies.videoinfo.models.Review;
import com.etfmovies.videoinfo.models.Video;
import com.etfmovies.videoinfo.models.VideoImage;
import com.etfmovies.videoinfo.repositories.ReviewRepository;
import com.etfmovies.videoinfo.repositories.VideoImageRepository;
import com.etfmovies.videoinfo.repositories.VideoRepository;
import com.etfmovies.videoinfo.service_interfaces.IVideoInfoService;
import com.etfmovies.videoinfo.utils.VideoInfoResponseObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.discovery.converters.Auto;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class VideoInfoService implements IVideoInfoService {
    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Override
    public List<Video> searchVideos(String query) {
        return videoRepository.findByTitleContaining(query);
    }

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    VideoImageRepository videoImageRepository;

    @Override
    public Boolean deleteVideo(Long videoId) {
        try {
            videoRepository.deleteById(videoId);
        } catch (EmptyResultDataAccessException ex) {
            throw new EmptyResultDataAccessException("No video with provided Id.", 1);
        }
        return true;
    }

    @Override
    public List<Video> getUsersVideos(Long userId) {
        try {
            String userServiceUrl = "http://localhost:8081/user/get-info?id=" + userId;

            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<String> response = restTemplate.getForEntity(userServiceUrl, String.class);
            if (response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR){
                ObjectMapper mapper = new ObjectMapper();
                throw new EmptyResultDataAccessException(mapper.readTree(response.getBody()).path("message").asText(), 1);
            }

            return videoRepository.findVideosByUploadedBy(userId);
        } catch (Exception ex) {
            return new ArrayList<>();
        }
    }

    @Override
    public Long getVideoRating(Long id) {
        List<Review> reviews = reviewRepository.getAllByVideoId(id);
        Integer scoreSum = reviews.stream().map(Review::getReviewRating).mapToInt(Integer::intValue).sum();
        Double score = scoreSum*1.0/reviews.size();
        return score.longValue();
    }

    @Override
    public List<VideoImage> getVideoImages(Long videoId) {
        Video v = videoRepository.findById(videoId).get();
        return videoImageRepository.findByVideo(v);
    }

    @Override
    public VideoInfoResponseObject getInfo(Long videoId) {
        try {
            Video video = videoRepository.findById(videoId).get();
            //List<ServiceInstance> streamServices = this.discoveryClient.getInstances("video-stream-service-client");
            //ServiceInstance service = streamServices.get(0);
            //String uri = service.getHost();
            String videoStreamUrl = "http://localhost:8082/video/getUrl?id=" + videoId;

            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<String> response = restTemplate.getForEntity(videoStreamUrl, String.class);
            String userServiceUrl = "http://localhost:8081/user/get-info?id=" + video.getUploadedBy();
            restTemplate = new RestTemplate();

            video.setUrl(response.getBody());

            VideoInfoResponseObject responseObject = new VideoInfoResponseObject(video.getId(),
                    video.getTitle(), video.getDescription(), video.getUploadedBy(),
                    video.getUploadedByUser(), video.getUploadDate(), video.getVideoData(), video.getCategory(),
                    video.getUrl(), video.getThumbnailUrl(), getVideoRating(videoId)*10, getVideoImages(videoId));

            return responseObject;
        }
        catch (EmptyResultDataAccessException ex) {
            throw new EmptyResultDataAccessException("No video with provided Id.", 1);
        }
    }
}

