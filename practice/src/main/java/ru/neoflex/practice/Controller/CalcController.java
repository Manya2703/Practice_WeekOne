package ru.neoflex.practice.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.practice.Operation.Calc_Operation;

@RestController
@Tag(name = "Калькулятор")
public class CalcController
{
    @Operation(summary = "Сложение")
    @GetMapping("/add/{x}/{y}")
    public Calc_Operation add(@PathVariable double x, @PathVariable double y)
    {
        double result = x + y;
        return new Calc_Operation("Сложение", x, y, result);
    }

    @Operation(summary = "Вычитание")
    @GetMapping("/subtract/{x}/{y}")
    public Calc_Operation subtract(@PathVariable double x, @PathVariable double y)
    {
        double result = x - y;
        return new Calc_Operation("Вычитание", x, y, result);
    }
}
