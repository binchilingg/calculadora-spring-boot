package br.com.calculadora.service;

import br.com.calculadora.model.ResultadoCalculo;
import org.springframework.stereotype.Service;
import java.util.Locale;

@Service
public class CalculadoraService {

    public ResultadoCalculo calcular(double numero1, double numero2, String operacao) {
        if (operacao == null || operacao.trim().isEmpty()) {
            return new ResultadoCalculo(numero1, numero2, operacao, null,
                    "erro: operação não informada");
        }

        String op = operacao.trim().toLowerCase(Locale.ROOT);
        double resultado;

        try {
            switch (op) {
                case "adicao":
                case "adição":
                case "+":
                    resultado = numero1 + numero2;
                    break;
                case "subtracao":
                case "subtração":
                case "-":
                    resultado = numero1 - numero2;
                    break;
                case "multiplicacao":
                case "multiplicação":
                case "*":
                case "x":
                    resultado = numero1 * numero2;
                    break;
                case "divisao":
                case "divisão":
                case "/":
                    if (numero2 == 0.0) {
                        return new ResultadoCalculo(numero1, numero2, operacao, null,
                                "erro: divisão por zero");
                    }
                    resultado = numero1 / numero2;
                    break;
                case "exponenciacao":
                case "exponenciação":
                case "^":
                    resultado = Math.pow(numero1, numero2);
                    break;
                default:
                    return new ResultadoCalculo(numero1, numero2, operacao, null,
                            "erro: operação inválida");
            }
            if (!Double.isFinite(resultado)) {
                return new ResultadoCalculo(numero1, numero2, operacao, null,
                        "erro: resultado matemático inválido");
            }
            return new ResultadoCalculo(numero1, numero2, operacao, resultado, "sucesso");
        } catch (ArithmeticException e) {
            return new ResultadoCalculo(numero1, numero2, operacao, null,
                    "erro: não foi possível realizar o cálculo");
        }
    }
}
