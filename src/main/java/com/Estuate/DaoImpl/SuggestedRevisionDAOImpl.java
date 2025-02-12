package com.Estuate.DaoImpl;


import com.Estuate.Dao.SuggestedRevisionDAO;

import com.Estuate.models.SuggestedRevision;
import com.Estuate.DbConnection.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SuggestedRevisionDAOImpl implements SuggestedRevisionDAO {

    @Override
    public void addSuggestedRevision(SuggestedRevision suggestedRevision) {
        String sql = "INSERT INTO suggested_revision (emp_id, current_rating, suggested_rating, status, reason) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, suggestedRevision.getEmpId());
            stmt.setString(2, String.valueOf(suggestedRevision.getCurrentRating()));
            stmt.setString(3, String.valueOf(suggestedRevision.getSuggestedRating()));
            stmt.setString(4, suggestedRevision.getStatus());
            stmt.setString(5, suggestedRevision.getReason());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public SuggestedRevision getSuggestedRevisionById(int id) {
        String sql = "SELECT * FROM suggested_revision WHERE id = ?";
        try (Connection conn = DbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new SuggestedRevision(
                        rs.getInt("id"),
                        rs.getInt("emp_id"),
                        rs.getString("current_rating").charAt(0),
                        rs.getString("suggested_rating").charAt(0),
                        rs.getString("status"),
                        rs.getString("reason")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SuggestedRevision> getAllSuggestedRevisions() {
        List<SuggestedRevision> revisions = new ArrayList<>();
        String sql = "SELECT * FROM suggested_revision";
        try (Connection conn = DbConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                revisions.add(new SuggestedRevision(
                        rs.getInt("id"),
                        rs.getInt("emp_id"),
                        rs.getString("current_rating").charAt(0),
                        rs.getString("suggested_rating").charAt(0),
                        rs.getString("status"),
                        rs.getString("reason")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return revisions;
    }

    @Override
    public void updateSuggestedRevision(SuggestedRevision suggestedRevision) {
        String sql = "UPDATE suggested_revision SET emp_id = ?, current_rating = ?, suggested_rating = ?, status = ?, reason = ? WHERE id = ?";
        try (Connection conn = DbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, suggestedRevision.getEmpId());
            stmt.setString(2, String.valueOf(suggestedRevision.getCurrentRating()));
            stmt.setString(3, String.valueOf(suggestedRevision.getSuggestedRating()));
            stmt.setString(4, suggestedRevision.getStatus());
            stmt.setString(5, suggestedRevision.getReason());
            stmt.setInt(6, suggestedRevision.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSuggestedRevision(int id) {
        String sql = "DELETE FROM suggested_revision WHERE id = ?";
        try (Connection conn = DbConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
