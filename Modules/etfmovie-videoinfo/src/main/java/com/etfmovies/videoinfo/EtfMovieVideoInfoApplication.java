package com.etfmovies.videoinfo;

import com.etfmovies.videoinfo.models.Category;
import com.etfmovies.videoinfo.repositories.CategoryRepository;
import com.etfmovies.videoinfo.repositories.VideoRepository;
import com.etfmovies.videoinfo.repositories.ShowsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

@EnableDiscoveryClient
@SpringBootApplication
public class EtfMovieVideoInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtfMovieVideoInfoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(VideoRepository videoRepository, ShowsRepository showsRepository, CategoryRepository categoryRepository) {
		return (args) -> {
		    // save a couple of categories
			/*categoryRepository.save(new Category("Comedy"));
			categoryRepository.save(new Category("Drama"));
			categoryRepository.save(new Category("Thriller"));
			categoryRepository.save(new Category("Animated"));
			categoryRepository.save(new Category("Horror"));*/
		};
	}
}
