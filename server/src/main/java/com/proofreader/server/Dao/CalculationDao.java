package com.proofreader.server.Dao;

import com.proofreader.server.Entity.Calculation;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@Repository
public class CalculationDao {

    public static Map<Integer, Calculation> calculations;

    static {
        calculations = new HashMap<Integer, Calculation>() {
            {
                put(1, new Calculation("x*y", "multiply", 1, 1, 1));
                put(2, new Calculation("x/y", "divide", 1, 2, 2));
                put(3, new Calculation("x-y", "subtract", 2, 2, 3));
                put(4, new Calculation("x+y", "add", 2, 1, 4));
            }
        };
    }

    public Collection<Calculation> getAllCalculations() {
        return this.calculations.values();
    }

    public Calculation getCalculationById(int id) {
        return this.calculations.get(id);
    }

    public Collection<Calculation> getCalculationsBySolution(int solutionId) {
        Collection<Calculation> calcRaw = calculations.values();
        Collection<Calculation> calcParse = new LinkedList<Calculation>();
        for(Calculation i : calcRaw ) {
            if(i.getSolutionId() == solutionId) {
                calcParse.add(i);
            }
        }
        return calcParse;
    }

    public void deleteCalculationById(int id) {
        this.calculations.remove(id);
    }

    public void updateCalculationById(Calculation calculation) {
        Calculation calculationToUpdate = calculations.get(calculation.getId());
        calculationToUpdate.setComment(calculation.getComment());
        calculationToUpdate.setExpression(calculation.getExpression());
        calculationToUpdate.setId(calculation.getId());
        calculationToUpdate.setSolutionId(calculation.getSolutionId());
        calculations.put(calculation.getId(), calculation);
    }

    public void addCalculation(Calculation calculation) {
        calculations.put(calculation.getId(), calculation);

    }
}
