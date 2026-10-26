package br.com.calculadora.service;

import br.com.calculadora.model.ResultadoCalculo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraServiceTest {
    private CalculadoraService service;

    @BeforeEach
    void configurar() {
        service = new CalculadoraService();
    }

    @Test
    void deveSomar() {
        ResultadoCalculo r = service.calcular(5, 3, "adicao");
        assertEquals(8.0, r.getResultado());
        assertEquals("sucesso", r.getSituacao());
    }

    @Test
    void deveSubtrair() {
        ResultadoCalculo r = service.calcular(9, 4, "subtracao");
        assertEquals(5.0, r.getResultado());
    }

    @Test
    void deveMultiplicar() {
        ResultadoCalculo r = service.calcular(6, 7, "multiplicacao");
        assertEquals(42.0, r.getResultado());
    }

    @Test
    void deveDividir() {
        ResultadoCalculo r = service.calcular(8, 2, "divisao");
        assertEquals(4.0, r.getResultado());
    }

    @Test
    void deveCalcularPotencia() {
        ResultadoCalculo r = service.calcular(2, 3, "exponenciacao");
        assertEquals(8.0, r.getResultado());
    }

    @Test
    void deveInformarErroAoDividirPorZero() {
        ResultadoCalculo r = service.calcular(8, 0, "/");
        assertNull(r.getResultado());
        assertTrue(r.getSituacao().contains("divisão por zero"));
    }

    @Test
    void deveInformarOperacaoInvalida() {
        ResultadoCalculo r = service.calcular(8, 2, "raiz");
        assertNull(r.getResultado());
        assertTrue(r.getSituacao().contains("operação inválida"));
    }

    @Test
    void deveInformarOperacaoVazia() {
        ResultadoCalculo r = service.calcular(8, 2, " ");
        assertNull(r.getResultado());
        assertTrue(r.getSituacao().contains("operação não informada"));
    }

    @Test
    void deveAceitarSimboloDeAdicao() {
        ResultadoCalculo r = service.calcular(2.5, 1.5, "+");
        assertEquals(4.0, r.getResultado());
    }

    @Test
    void deveGuardarOsNumerosDeEntrada() {
        ResultadoCalculo r = service.calcular(12, 5, "-");
        assertEquals(12.0, r.getNumero1());
        assertEquals(5.0, r.getNumero2());
        assertEquals("-", r.getOperacao());
    }

    @Test
    void deveAceitarOperacaoComMaiusculas() {
        ResultadoCalculo r = service.calcular(3, 2, "MULTIPLICACAO");
        assertEquals(6.0, r.getResultado());
    }

    @Test
    void deveInformarResultadoNaoFinitoComoErro() {
        ResultadoCalculo r = service.calcular(10, 10000, "^");
        assertNull(r.getResultado());
        assertTrue(r.getSituacao().startsWith("erro"));
    }
}
