package com.proofreader.server.Service;

import com.proofreader.server.Dao.CalculationDao;
import com.proofreader.server.Entity.Calculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculationService {

    @Autowired
    private CalculationDao dao;

    public List<Calculation> getAllCalculations() {
        return this.dao.getAllCalculations();
    }

    public List<Calculation> getCalculationById(int id) {
        return this.dao.getCalculationById(id);
    }

    public List<Calculation> getCalculationsBySolution(int solutionId) { return this.dao.getCalculationsBySolution(solutionId); }

    public void deleteCalculationById(int id) {
        this.dao.deleteCalculationById(id);
    }

    public void updateCalculationById(Calculation calculation) {
        this.dao.updateCalculationById(calculation);
    }

    public void addCalculation(Calculation calculation) {
        this.dao.addCalculation(calculation);
    }
}
