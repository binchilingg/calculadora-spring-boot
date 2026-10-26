# Calculadora Spring Boot

Projeto da Atividade 07: calculadora REST com operações e testes automatizados.

## Requisitos
- Java 17 ou superior
- Maven 3.8+ (ou usar o Maven integrado da IDE)

## Executar os testes
Na pasta do projeto, execute:

```bash
mvn test
```

## Executar a aplicação
```bash
mvn spring-boot:run
```

## Endpoint
`GET http://localhost:8080/api/calculadora/calcular`

Parâmetros obrigatórios: `numero1`, `numero2` e `operacao`.

Exemplo:
`http://localhost:8080/api/calculadora/calcular?numero1=10&numero2=5&operacao=adicao`

Operações aceitas:
- `adicao` ou `+`
- `subtracao` ou `-`
- `multiplicacao`, `*` ou `x`
- `divisao` ou `/`
- `exponenciacao` ou `^`

A resposta JSON contém os números de entrada, a operação, o resultado e a situação.

## TDD
Para aplicar TDD em uma evolução do projeto:
1. Escreva primeiro um teste para uma nova regra.
2. Execute `mvn test` e confirme que o teste falha.
3. Implemente o comportamento mínimo para passar.
4. Execute os testes novamente.
5. Refatore mantendo todos os testes passando.

Os testes incluídos cobrem operações matemáticas, entradas inválidas e divisão por zero.
