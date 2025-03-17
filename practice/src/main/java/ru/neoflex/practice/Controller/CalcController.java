package ru.neoflex.practice.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.practice.Model.Calculation;
import ru.neoflex.practice.Service.CalcService;

import java.util.List;

@RestController
@Tag(name = "Калькулятор")
public class CalcController {

    private final CalcService calcService;

    public CalcController(CalcService calcService) {
        this.calcService = calcService;
    }

    @Operation(summary = "Сложение")
    @GetMapping("/plus/{a}/{b}")
    public String plus(
            @Parameter(description = "First number") @PathVariable("a") Integer a,
            @Parameter(description = "Second number") @PathVariable("b") Integer b) {
        return calcService.calculate("plus", a, b);
    }

    @Operation(summary = "Вычитание")
    @GetMapping("/minus/{a}/{b}")

    public String minus(
            @Parameter(description = "First number") @PathVariable("a") Integer a,
            @Parameter(description = "Second number") @PathVariable("b") Integer b) {
        return calcService.calculate("minus", a, b);
    }

    @Operation(summary = "Вывод результата")
    @GetMapping("/history")
    public List<Calculation> history() {
        return calcService.getAllCalculations();
    }
}
