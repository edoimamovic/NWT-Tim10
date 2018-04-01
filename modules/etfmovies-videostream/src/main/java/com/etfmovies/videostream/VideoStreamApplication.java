package com.etfmovies.videostream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class VideoStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoStreamApplication.class, args);
	}
}
