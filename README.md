# Projeto de Cálculo de Impostos de Transações
## Descrição

Este projeto implementa um serviço para calcular impostos sobre transações financeiras, como compra e venda de ativos. O cálculo dos impostos é baseado em certas regras de negócio, onde são considerados lucros e prejuízos nas transações.

## Decisões Técnicas e Arquiteturais

- Linguagem de Programação: O projeto é escrito em Java, uma linguagem de programação amplamente utilizada na indústria.
- Framework Spring: Utiliza o framework Spring para injeção de dependência e configuração do serviço.
- Testes Unitários com JUnit e Mockito: Os testes unitários são implementados com JUnit e Mockito para garantir a qualidade do código.
- REST Template: Utiliza o REST Template do Spring para fazer chamadas HTTP para um servidor local que fornece as transações financeiras.
- Jackson: Utiliza a biblioteca Jackson para conversão de objetos Java para JSON.

## Justificativa para o Uso de Frameworks ou Bibliotecas

- Spring: O Spring facilita a configuração do serviço, além de fornecer recursos como injeção de dependência, que aumentam a modularidade e testabilidade do código.
- JUnit e Mockito: Essas ferramentas são amplamente utilizadas para testes unitários em Java e permitem escrever testes de forma eficaz e confiável.
- Jackson: Jackson é uma biblioteca popular para processamento JSON em Java, facilitando a conversão de objetos Java para JSON e vice-versa.

## Instruções para Compilar e Executar o Projeto

1 - Certifique-se de ter o JDK (Java Development Kit) instalado na sua máquina.

2 - Extraia para sua máquina local.

3 - Navegue até o diretório raiz do projeto.

4 - Execute o comando mvn clean install para compilar o projeto e gerar o arquivo JAR.

5 - Execute o comando java -jar nome_do_arquivo.jar para iniciar o serviço.

## Instruções para Executar os Testes da Solução

1 - Siga as etapas de 1 a 3 das instruções para compilar e executar o projeto.

2 - Execute o comando mvn test para executar os testes unitários.

3 - Após a execução, os resultados dos testes serão exibidos no console.

## Notas Adicionais

- Certifique-se de que o servidor local está em execução, o projeto foi desenvolvido para consumir o dados das transações de um serviço local.
- Os testes unitários são executados automaticamente durante a compilação do projeto usando Maven.