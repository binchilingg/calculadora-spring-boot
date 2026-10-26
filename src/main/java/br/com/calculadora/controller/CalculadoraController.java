package br.com.calculadora.controller;

import br.com.calculadora.model.ResultadoCalculo;
import br.com.calculadora.service.CalculadoraService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculadora")
public class CalculadoraController {
    private final CalculadoraService calculadoraService;

    public CalculadoraController(CalculadoraService calculadoraService) {
        this.calculadoraService = calculadoraService;
    }

    @GetMapping("/calcular")
    public ResultadoCalculo calcular(
            @RequestParam double numero1,
            @RequestParam double numero2,
            @RequestParam String operacao) {
        return calculadoraService.calcular(numero1, numero2, operacao);
    }
}
