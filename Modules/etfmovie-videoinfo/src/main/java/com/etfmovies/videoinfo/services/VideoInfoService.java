package com.etfmovies.videoinfo.services;

import com.etfmovies.videoinfo.models.Video;
import com.etfmovies.videoinfo.repositories.VideoRepository;
import com.etfmovies.videoinfo.service_interfaces.IVideoInfoService;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public Video getInfo(Long videoId) {
        try {
            Video video = videoRepository.findById(videoId).get();
            //List<ServiceInstance> streamServices = this.discoveryClient.getInstances("video-stream-service-client");
            //ServiceInstance service = streamServices.get(0);
            //String uri = service.getHost();
            String videoStreamUrl = "http://localhost:8082/video/getUrl?id=" + videoId;

            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<String> response = restTemplate.getForEntity(videoStreamUrl, String.class);

            video.setUrl(response.getBody());

            return video;
        }
        catch (EmptyResultDataAccessException ex) {
            throw new EmptyResultDataAccessException("No video with provided Id.", 1);
        }
    }
}

