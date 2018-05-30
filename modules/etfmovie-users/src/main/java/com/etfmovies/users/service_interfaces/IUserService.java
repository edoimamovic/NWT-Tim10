package com.etfmovies.users.service_interfaces;

import com.etfmovies.users.models.Favourite;
import com.etfmovies.users.models.Review;
import com.etfmovies.users.models.UserData;

import java.util.List;

public interface IUserService {
    UserData registerUser(UserData userData);
    UserData getUserDataByUserId(Long userId);
    UserData getUserDataByEmail(String email);
    UserData updateUserData(UserData userData);
    void activateUser(String email);

    void AddToFavourites(Long userId, Long videoId);
    void AddReview(Long userId, Long videoId, String review, Integer rating);
    List<Favourite> GetFavouritesByUserId(Long userId);
    List<Review> GetReviewsByUserId(Long userId);
}
