package com.Estuate.DaoImpl;



import com.Estuate.Dao.RatingsDAO;
import com.Estuate.models.Ratings;
import com.Estuate.DbConnection.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RatingDAOImpl implements RatingsDAO {

    @Override
    public void addRating(Ratings rating) {
        String sql = "INSERT INTO ratings (emp_id, previous_rating, new_rating, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = DbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, rating.getEmpId());
            stmt.setString(2, String.valueOf(rating.getPreviousRating()));
            stmt.setString(3, String.valueOf(rating.getNewRating()));
            stmt.setString(4, rating.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Ratings getRatingById(int id) {
        String sql = "SELECT * FROM ratings WHERE id = ?";
        try (Connection conn = DbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Ratings(rs.getInt("id"), rs.getInt("emp_id"),
                        rs.getString("previous_rating").charAt(0),
                        rs.getString("new_rating").charAt(0),
                        rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Ratings> getAllRatings() {
        List<Ratings> ratings = new ArrayList<>();
        String sql = "SELECT * FROM ratings";
        try (Connection conn = DbConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ratings.add(new Ratings(rs.getInt("id"), rs.getInt("emp_id"),
                        rs.getString("previous_rating").charAt(0),
                        rs.getString("new_rating").charAt(0),
                        rs.getString("status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ratings;
    }

    @Override
    public void updateRating(Ratings rating) {
        String sql = "UPDATE ratings SET previous_rating = ?, new_rating = ?, status = ? WHERE id = ?";
        try (Connection conn = DbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, String.valueOf(rating.getPreviousRating()));
            stmt.setString(2, String.valueOf(rating.getNewRating()));
            stmt.setString(3, rating.getStatus());
            stmt.setInt(4, rating.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRating(int id) {
        String sql = "DELETE FROM ratings WHERE id = ?";
        try (Connection conn = DbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
