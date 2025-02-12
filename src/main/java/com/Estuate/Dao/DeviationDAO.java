package com.Estuate.Dao;



import com.Estuate.models.Deviation;
import java.util.List;

public interface DeviationDAO {
    void addDeviation(Deviation deviation);
    List<Deviation> getAllDeviations();
    void updateDeviation(Deviation deviation);
    void deleteDeviation(int id);
}
