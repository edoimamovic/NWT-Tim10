package com.etfmovies.users.services;

import com.etfmovies.users.models.Favourite;
import com.etfmovies.users.models.Review;
import com.etfmovies.users.models.UserData;
import com.etfmovies.users.repositories.FavouritesRepository;
import com.etfmovies.users.repositories.ReviewRepository;
import com.etfmovies.users.repositories.UserDataRepository;
import com.etfmovies.users.service_interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserDataRepository userDataRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private FavouritesRepository favouritesRepository;


    @Override
    public UserData registerUser(UserData userData) {
        return userDataRepository.save(userData);
    }


    @Override
    public UserData getUserDataByUserId(Long userId) {
        try{
            return userDataRepository.findById(userId).get();
        }
        catch (NoSuchElementException ex){
            throw new NoSuchElementException("No user with the provided Id.");
        }
    }


    @Override
    public UserData getUserDataByEmail(String email) {
        try{
            List<UserData> allUsers = userDataRepository.findAll();
            return userDataRepository.findByEmail(email);
        }
        catch (NoSuchElementException ex){
            throw new NoSuchElementException("No user with the provided email.");
        }
    }


    @Override
    public UserData updateUserData(UserData userData) {
        UserData oldData = userDataRepository.findById(userData.getId()).get();

        if (userData.getFirstName() != null && !userData.getFirstName().isEmpty()){
            oldData.setFirstName(userData.getFirstName());
        }

        if (userData.getLastName() != null && !userData.getLastName().isEmpty()){
            oldData.setLastName(userData.getLastName());
        }

        if (userData.getEmail() != null && !userData.getEmail().isEmpty()){
            oldData.setEmail(userData.getEmail());
        }

        if (userData.getBirthDate() != null){
            oldData.setBirthDate(userData.getBirthDate());
        }

        return userDataRepository.save(oldData);
    }

    @Override
    public void activateUser(String email) {
        UserData userData = userDataRepository.findByEmail(email);
        userData.setActive(true);
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
