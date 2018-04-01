package com.etfmovies.users.services;

import com.etfmovies.users.models.Favourite;
import com.etfmovies.users.models.Review;
import com.etfmovies.users.models.UserData;
import com.etfmovies.users.repositories.FavouritesRepository;
import com.etfmovies.users.repositories.ReviewRepository;
import com.etfmovies.users.repositories.UserDataRepository;
import com.etfmovies.users.service_interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserDataRepository userDataRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private FavouritesRepository favouritesRepository;


    @Override
    public void registerUser(UserData userData) {
        userDataRepository.save(userData);
    }

    @Override
    public UserData getUserDataByUserId(Long userId) {
        return userDataRepository.findById(userId).get();
    }

    @Override
    public void updateUserData(UserData userData) {
        userDataRepository.save(userData);
    }

    @Override
    public void activateUser(String email) {
        UserData userData = userDataRepository.findByEmail(email);
        userData.setActive(true);
        userDataRepository.save(userData);
    }

    @Override
    public void changePassword(String email, String password) {
        UserData userData = userDataRepository.findByEmail(email);
        userData.setPassword(password);
        userDataRepository.save(userData);
    }

    @Override
    public void AddToFavourites(Long userId, Long videoId) {
        Favourite newFavourite = new Favourite(videoId, userId);
        favouritesRepository.save(newFavourite);
    }

    @Override
    public void AddReview(Long userId, Long videoId, String review, Integer rating) {
        Review newReview = new Review(review, rating, userId);
        reviewRepository.save(newReview);
    }

    @Override
    public List<Favourite> GetFavouritesByUserId(Long userId) {
        UserData userData = userDataRepository.findById(userId).get();
        return userData.getFavourites();
    }

    @Override
    public List<Review> GetReviewsByUserId(Long userId) {
        UserData userData = userDataRepository.findById(userId).get();
        return userData.getReviews();
    }
}
