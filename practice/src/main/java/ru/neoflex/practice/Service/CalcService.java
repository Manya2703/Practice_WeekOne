package ru.neoflex.practice.Service;

import ru.neoflex.practice.Model.Calculation;
import ru.neoflex.practice.Repository.CalcRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalcService {
    private final CalcRepository calculationRepository;

    public CalcService(CalcRepository calculationRepository) {
        this.calculationRepository = calculationRepository;
    }

    public String calculate(String operation, Integer a, Integer b) {
        Integer result = null;
        switch (operation) {
            case "plus":
                result = a + b;
                break;
            case "minus":
                result = a - b;
                break;
        }

        if (result != null) {
            Calculation calculation = new Calculation();
            calculation.setOperation(operation);
            calculation.setNum1(a);
            calculation.setNum2(b);
            calculation.setResult(result.toString());
            calculationRepository.save(calculation);
            return String.valueOf(result);
        } else {
            return "Неправильная операция";
        }
    }

    public List<Calculation> getAllCalculations() {
        return calculationRepository.findAll();
    }
}
