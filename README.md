# Project Place

README Project Place - Rodney Victor

## Descrição

Project Place é uma aplicação Spring Boot que permite gerenciar lugares. Este projeto serve como exemplo de como estruturar uma aplicação Spring Boot com boas práticas de design de software.

## Funcionalidades

- Criar novos lugares
- Listar todos os lugares
- Atualizar informações de um lugar
- Deletar um lugar

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Maven
- Docker

## Requisitos

- JDK 17 ou superior
- Maven 3.6.3 ou superior
- Docker

## Como Executar a Aplicação

### Usando Maven

1. Clone o repositório:
   ```sh
   git clone https://github.com/username/project-place.git
   cd project-place

2. Compile e execute a aplicação:

   ./mvnw clean package
   java -jar target/project-place-0.0.1-SNAPSHOT.jar

3. Acesse a aplicação em  http://localhost:8080.

### Usando Docker

1. Construa a imagem Docker:

   docker build -t project-place:latest .

2. Execute o Contêiner:

   docker run --name place-api -p 8080:8080 project-place:latest

3. Acesse a aplicação em  http://localhost:8080.

## Estrutura do Projeto

project-place/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/rodneycom/project_place/
│   │   │       ├── ProjectPlaceApplication.java
│   │   │       ├── app/
│   │   │       │   ├── PlaceRequest.java
│   │   │       │   └── PlaceResponse.java
│   │   │       ├── domain/
│   │   │       │   ├── Place.java
│   │   │       │   └── PlaceRepository.java
│   │   │       ├── service/
│   │   │       │   └── PlaceService.java
│   │   │       ├── web/
│   │   │       │   ├── PlaceController.java
│   │   │       │   └── PlaceMapper.java
│   │   │       └── ioc/
│   │   │           └── PlaceConfig.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── schema.sql
│   └── test/
│       └── java/
│           └── com/rodneycom/project_place/
│               └── ProjectPlaceApplicationTests.java
│
├── Dockerfile
├── HELP.md
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md

## Endpoints da API

### Criar um novo lugar

POST /places

Request Body:
{
   "name": "Praça Central",
   "state": "active"
}

### Listar todos os lugares

GET /places

### Atualizar um lugar

PUT /places/{id}

Request Body:
{
   "name": "Praça Central",
   "state": "blocked"
}

### Deletar um lugar

DELETE /places/{id}

## Licença

Este projeto está licenciado sob a Licença MIT.
