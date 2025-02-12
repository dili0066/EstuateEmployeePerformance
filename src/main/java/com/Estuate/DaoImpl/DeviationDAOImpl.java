package com.Estuate.DaoImpl;



import com.Estuate.Dao.DeviationDAO;
import com.Estuate.models.Deviation;
import com.Estuate.DbConnection.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeviationDAOImpl implements DeviationDAO {

    @Override
    public void addDeviation(Deviation deviation) {
        String sql = "INSERT INTO deviation (category, standard_percentage, actual_percentage, deviation, suggested_change) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, deviation.getRatingCategory());
            stmt.setDouble(2, deviation.getStandardPercentage());
            stmt.setDouble(3, deviation.getActualPercentage());
            stmt.setDouble(4, deviation.getDeviation());
            stmt.setString(5, deviation.getSuggestedChange());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

    @Override
    public List<Deviation> getAllDeviations() {
        List<Deviation> deviations = new ArrayList<>();
        String sql = "SELECT * FROM deviation";
        try (Connection conn = DbConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                deviations.add(new Deviation(
                        rs.getString("category"),
                        rs.getDouble("standard_percentage"),
                        rs.getDouble("actual_percentage"),
                        rs.getDouble("deviation"),
                        rs.getString("suggested_change")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deviations;
    }

    @Override
    public void updateDeviation(Deviation deviation) {
        String sql = "UPDATE deviation SET actual_percentage = ?, deviation = ?, suggested_change = ? WHERE id = ?";
        try (Connection conn = DbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, deviation.getRatingCategory());
            stmt.setDouble(2, deviation.getStandardPercentage());
            stmt.setDouble(3, deviation.getActualPercentage());
            stmt.setDouble(4, deviation.getDeviation());
            stmt.setString(5, deviation.getSuggestedChange());
            stmt.setInt(6, deviation.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDeviation(int id) {
        String sql = "DELETE FROM deviation WHERE id = ?";
        try (Connection conn = DbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
