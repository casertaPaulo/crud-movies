# Projeto Back-end CRUD de Filmes com Spring Boot

Este é o projeto back-end para um sistema CRUD de filmes, desenvolvido utilizando o framework Spring Boot. O projeto segue a arquitetura MVC (Model-View-Controller) e está integrado com um banco de dados PostgreSQL. Ele também inclui funcionalidades para criar registros no banco através de APIs externas e está configurado para servir como backend para um front-end em Next.js, React.js e PrimeReact.js.

## Tecnologias Utilizadas

- Java
- Spring Boot
- PostgreSQL
- RESTful APIs
- Maven (para gerenciamento de dependências)

## Estrutura do Projeto

O projeto está estruturado da seguinte maneira:

![image](https://github.com/casertaPaulo/crud-movies/assets/126000902/dad019d8-f313-4b3e-8181-601b05e20e09)


## Configuração e Execução

1. **Configuração do Banco de Dados:**
   - Certifique-se de ter um servidor PostgreSQL em execução.
   - Configure as credenciais do banco de dados no arquivo `application.properties` dentro de `src/main/resources`.

2. **Execução do Projeto:**
   - Importe o projeto em sua IDE preferida como um projeto Maven.
   - Execute a classe `MoviesApplication.java` para iniciar o servidor Spring Boot.

3. **Endpoints Disponíveis:**
   - O projeto define endpoints RESTful para realizar operações CRUD (Create, Read, Update, Delete) em filmes. Exemplos de endpoints podem incluir `/movie` para listar todos os filmes, `/movie/{title}` para criar um filme no banco de dados através de uma requisição API (OMDB), entre outros.

## Integração com Front-end

Este projeto back-end está integrado a um projeto front-end em Flutter

## Contribuição

Contribuições são bem-vindas! Se deseja melhorar este projeto, sinta-se à vontade para criar um fork e enviar um pull request. Para problemas ou sugestões, por favor, abra uma issue.




