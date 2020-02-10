package com.proofreader.server.Controller;

import com.proofreader.server.Entity.Calculation;
import com.proofreader.server.Service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/calculations")
public class CalculationController {

    @Autowired
    private CalculationService calculationService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Calculation> getAllCalculations() {
        return calculationService.getAllCalculations();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<Calculation> getCalculation(@PathVariable("id") int id) {
        return calculationService.getCalculationById(id);
    }

    @RequestMapping(value = "/solution/{id}", method = RequestMethod.GET)
    public List<Calculation> getCalculationsBySolution(@PathVariable("id") int solutionId) {
        return calculationService.getCalculationsBySolution(solutionId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCalculationById(@PathVariable("id") int id) {
        calculationService.deleteCalculationById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCalculationById(@RequestBody Calculation calculation) {
        calculationService.updateCalculationById(calculation);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCalculation(@RequestBody Calculation calculation){
        calculationService.addCalculation(calculation);
    }
}
