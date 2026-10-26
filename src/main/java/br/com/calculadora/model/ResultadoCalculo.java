package br.com.calculadora.model;

public class ResultadoCalculo {
    private double numero1;
    private double numero2;
    private String operacao;
    private Double resultado;
    private String situacao;

    public ResultadoCalculo() {
    }

    public ResultadoCalculo(double numero1, double numero2, String operacao,
                            Double resultado, String situacao) {
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.operacao = operacao;
        this.resultado = resultado;
        this.situacao = situacao;
    }

    public double getNumero1() { return numero1; }
    public void setNumero1(double numero1) { this.numero1 = numero1; }
    public double getNumero2() { return numero2; }
    public void setNumero2(double numero2) { this.numero2 = numero2; }
    public String getOperacao() { return operacao; }
    public void setOperacao(String operacao) { this.operacao = operacao; }
    public Double getResultado() { return resultado; }
    public void setResultado(Double resultado) { this.resultado = resultado; }
    public String getSituacao() { return situacao; }
    public void setSituacao(String situacao) { this.situacao = situacao; }
}
