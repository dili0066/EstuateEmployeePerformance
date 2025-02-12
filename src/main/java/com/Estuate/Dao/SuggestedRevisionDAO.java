package com.Estuate.Dao;



import com.Estuate.models.SuggestedRevision;
import java.util.List;

public interface SuggestedRevisionDAO {
    void addSuggestedRevision(SuggestedRevision revision);
    SuggestedRevision getSuggestedRevisionById(int id);
    List<SuggestedRevision> getAllSuggestedRevisions();
    void updateSuggestedRevision(SuggestedRevision revision);
    void deleteSuggestedRevision(int id);
}

