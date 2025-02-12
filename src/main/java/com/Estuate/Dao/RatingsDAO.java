package com.Estuate.Dao;



import com.Estuate.models.Ratings;
import java.util.List;

public interface RatingsDAO {
    void addRating(Ratings rating);
    Ratings getRatingById(int id);
    List<Ratings> getAllRatings();
    void updateRating(Ratings rating);
    void deleteRating(int id);
}
