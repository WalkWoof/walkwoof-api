# WalkWoof API

![Kotlin Badge](https://img.shields.io/badge/Kotlin-7F52FF?logo=kotlin&logoColor=fff&style=for-the-badge)
![Spring Boot Badge](https://img.shields.io/badge/Spring%20Boot-6DB33F?logo=springboot&logoColor=fff&style=for-the-badge)
![Spring Security Badge](https://img.shields.io/badge/Spring%20Security-6DB33F?logo=springsecurity&logoColor=fff&style=for-the-badge)
![JUnit5 Badge](https://img.shields.io/badge/JUnit5-25A162?logo=junit5&logoColor=fff&style=for-the-badge)
![MySQL Badge](https://img.shields.io/badge/MySQL-4479A1?logo=mysql&logoColor=fff&style=for-the-badge)
![Flyway Badge](https://img.shields.io/badge/Flyway-CC0200?logo=flyway&logoColor=fff&style=for-the-badge)
![Docker Badge](https://img.shields.io/badge/Docker-2496ED?logo=docker&logoColor=fff&style=for-the-badge)
![Jira Badge](https://img.shields.io/badge/Jira-0052CC?logo=jira&logoColor=fff&style=for-the-badge)

WalkWoof is a platform designed to connect dog owners with trusted dog walkers, providing a convenient and secure way to manage pet care. The API offers endpoints to schedule, monitor, and manage dog walking appointments, ensuring pet well-being through an accessible digital platform.

## Table of Contents

- [Project Overview](#project-overview)
- [Features](#targeted-features)
- [Installation](#installation)
- [API Endpoints](#api-endpoints)
- [Technologies](#technologies)

## Project Overview

WalkWoof was created to address the needs of dog owners in urban settings who often face challenges in walking with them or finding reliable people to do it and ensure their pets get adequate exercise. The application not only facilitates scheduling but also allows real-time tracking of pet activities, offering peace of mind to pet owners.

The project is built using **Spring Boot** with **Kotlin** for the backend, and follows Agile methodologies, particularly **Scrum**, for iterative development and continuous improvement.

## Targeted Features

- **Dog Walker Matching**: Connects pet owners with verified dog walkers.
- **Secure Scheduling**: Users can book, modify, and cancel walks easily.
- **Real-time Tracking**: Monitor pet activities in real time during walks.
- **User Authentication**: Secure login and registration using JWT tokens.
- **Feedback System**: Rate and review walkers to ensure quality service.
- **Sustainable Practices**: Encourages eco-friendly, on-foot mobility options for pet care.

## Installation

To run the WalkWoof API locally, follow these steps:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/WalkWoof/walkwoof-api.git
   cd walkwoof-api
   ```

2. **Run docker-compose.yml**:
   ```bash
   docker-compose up --build -d
   ```

3. **Build and Run the Project**:
   ```bash
   ./gradlew build
   ./gradlew bootRun
   ```
or run `WalkwoofApiApplication.kt`

   The API will be accessible at `http://localhost:8080`.

## API Endpoints

| Endpoint                  | Method | Description                    |
|---------------------------|--------|--------------------------------|
| `/api/auth/register`      | POST   | Register a new Owner or Walker |
| `/api/auth/login`         | POST   | Login and receive a JWT token  |
| `/api/activities/active`  | GET    | Get all in progress walks      |
| `/api/activities/history` | GET    | Get all activities history     |
| `/api/user/profile`       | GET    | Get user profile info          |
| `/api/notifications`      | GET    | Get all app notifications      |
| `/api/hello`              | GET    | Hello, World!                  |

## Technologies

- **Backend**: Kotlin (JDK 21), Spring Boot, Spring Security, JPA, MySQL (containered on Docker), Flyway
- **Mobile App**: Flutter (for future implementation)
- **Project Management**: Jira, Scrum methodology
- **Testing**: JUnit, Mockito for unit and integration testing

---

Developed by **Kauê Felippe Tiburcio**, **Lucas Rocha Sahdo**, **Gabriel dos Santos Campelo**, and **João Paulo de Oliveira Pereira** as part of the **Análise e Desenvolvimento de Sistemas** course at **Centro Universitário Facens**.

---

# WalkWoof API

![Kotlin Badge](https://img.shields.io/badge/Kotlin-7F52FF?logo=kotlin&logoColor=fff&style=for-the-badge)
![Spring Boot Badge](https://img.shields.io/badge/Spring%20Boot-6DB33F?logo=springboot&logoColor=fff&style=for-the-badge)
![Spring Security Badge](https://img.shields.io/badge/Spring%20Security-6DB33F?logo=springsecurity&logoColor=fff&style=for-the-badge)
![JUnit5 Badge](https://img.shields.io/badge/JUnit5-25A162?logo=junit5&logoColor=fff&style=for-the-badge)
![MySQL Badge](https://img.shields.io/badge/MySQL-4479A1?logo=mysql&logoColor=fff&style=for-the-badge)
![Flyway Badge](https://img.shields.io/badge/Flyway-CC0200?logo=flyway&logoColor=fff&style=for-the-badge)
![Docker Badge](https://img.shields.io/badge/Docker-2496ED?logo=docker&logoColor=fff&style=for-the-badge)
![Jira Badge](https://img.shields.io/badge/Jira-0052CC?logo=jira&logoColor=fff&style=for-the-badge)

**WalkWoof** é uma plataforma projetada para conectar donos de cães com passeadores de cães confiáveis, oferecendo uma maneira conveniente e segura de gerenciar os cuidados com os animais. A API oferece endpoints para agendar, monitorar e gerenciar os compromissos de passeios com cães, garantindo o bem-estar dos pets por meio de uma plataforma digital acessível.

## Índice

- [Visão Geral do Projeto](#visão-geral-do-projeto)
- [Funcionalidades](#funcionalidades-objetivadas)
- [Instalação](#instalação)
- [Endpoints da API](#endpoints-da-api)
- [Tecnologias](#tecnologias)

## Visão Geral do Projeto

O **WalkWoof** foi criado para atender às necessidades de donos de cães em ambientes urbanos, que frequentemente enfrentam desafios para passear ou encontrar passeadores confiáveis e garantir que seus pets recebam o exercício adequado. A aplicação facilita não apenas o agendamento, mas também permite o monitoramento em tempo real das atividades dos pets, oferecendo tranquilidade aos donos.

O projeto é desenvolvido utilizando **Spring Boot** com **Kotlin** no backend e segue metodologias ágeis, especialmente **Scrum**, para desenvolvimento iterativo e melhoria contínua.

## Funcionalidades Objetivadas

- **Match de Passeadores de Cães**: Conecta donos de pets com passeadores de cães verificados.
- **Agendamento Seguro**: Usuários podem agendar, modificar e cancelar passeios facilmente.
- **Monitoramento em Tempo Real**: Acompanhe as atividades do pet em tempo real durante os passeios.
- **Autenticação de Usuário**: Login e registro seguros usando tokens JWT.
- **Sistema de Feedback**: Avalie e faça comentários sobre os passeadores para garantir um serviço de qualidade.
- **Práticas Sustentáveis**: Incentiva opções ecológicas de mobilidade a pé para o cuidado dos animais.

## Instalação

Para rodar a API WalkWoof localmente, siga os seguintes passos:

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/WalkWoof/walkwoof-api.git
   cd walkwoof-api
   ```

2. **Execute o docker-compose.yml**:
   ```bash
   docker-compose up --build -d
   ```

3. **Construa e execute o projeto**:
   ```bash
   ./gradlew build
   ./gradlew bootRun
   ```
   ou execute `WalkwoofApiApplication.kt`.

   A API estará acessível em `http://localhost:8080`.

## Endpoints da API

| Endpoint                  | Método | Descrição                                 |
|---------------------------|--------|-------------------------------------------|
| `/api/auth/register`      | POST   | Registrar um novo dono ou Walker          |
| `/api/auth/login`         | POST   | Login e obtenção de um token JWT          |
| `/api/activities/active`  | GET    | Obter todos os passeios em andamento      |
| `/api/activities/history` | GET    | Obter o histórico de todas as atividades  |
| `/api/user/profile`       | GET    | Obter informações do perfil do usuário    |
| `/api/notifications`      | GET    | Obter todas as notificações do aplicativo |
| `/api/hello`              | GET    | Hello, World!                             |

## Tecnologias

- **Backend**: Kotlin (JDK 21), Spring Boot, Spring Security, JPA, MySQL (conteinerizado com Docker), Flyway
- **App Mobile**: Flutter (para implementação futura)
- **Gestão de Projetos**: Jira, metodologia Scrum
- **Testes**: JUnit, Mockito para testes unitários e de integração

---

Desenvolvido por **Kauê Felippe Tiburcio**, **Lucas Rocha Sahdo**, **Gabriel dos Santos Campelo** e **João Paulo de Oliveira Pereira** como parte do curso de **Análise e Desenvolvimento de Sistemas** no **Centro Universitário Facens**.

--- 
