# Easy Payroll

# Sobre o projeto
Easy Payroll é uma aplicação back end construida com arquitetura de microsserviços. A aplicação disponibiliza uma simples forma de calcular pagamentos de funcionarios.

# Tecnologias utilizadas
- Java
- Spring Boot
- Spring Cloud
- JPA / Hibernate
- H2
- Maven

# Como executar o projeto

Pré-requisitos: Java 11

```bash
# clonar repositório
Gnomos ainda estão pensando em como startar todas a aplicações de forma facil...
```

# Como utilizar a API

**Gnomos ainda estão trabalhando nisso...**

# Authenticação
Para fazer as requisições é necessario que você tenha um token jwt de autenticação. 
Para conseguir seu token é necessario fazer login com as credenciais de um "user". 
O seguinte SQL é executado durante o start da aplicação. Esse SQL cria dois usuarios e os vincula aos seus respectivos acessos.
Para fins de estudo o password padrão dos usuarios será 123456.

```sql
INSERT INTO user (name, email, password) VALUES ('Charlie Brown', 'charlie@gmail.com', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu');
INSERT INTO user (name, email, password) VALUES ('Cryier', 'cryier@gmail.com', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu');

INSERT INTO role (name) VALUES ('ROLE_OPERATOR');
INSERT INTO role (name) VALUES ('ROLE_ADMIN');

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);
```
## Requisição
```http
POST http://localhost:8765/hr-oauth/oauth/token
```
```javascript
{
  "username": "cryier@gmail.com",
  "password": "123456",
  "grant_type": "password"
}
```
## Resposta

| Status Code | Descrição |
| :--- | :--- |
| 200 | `OK` |
```javascript
{
  "access_token": "token_jwt",
  "token_type": "bearer",
  "expires_in": 86399,
  "scope": "read write",
  "jti": "jwt_id"
}
```

# Payroll API
Microserviço que faz o calculo dos pagamentos.

## Requisição
```http
GET http://localhost:8765/hr-payroll/api/v1/payments/{workerId}/days/{days}
```
| Variavel | Tipo | Descrição |
| :--- | :--- | :--- |
| `workerId` | `long` | **Obrigatório**. Id do trabalhador |
| `days` | `integer` | **Obrigatório**. Quantidade de dias trabalhados |

## Resposta

| Status Code | Descrição |
| :--- | :--- |
| 200 | `OK` |
```javascript
{
  "name": "Porthos",
  "dailyIncome": 300.0,
  "days": 15,
  "total": 4500.0
}
```

# Worker API
Microserviço que fornece informações sobre os trabalhadores.

## Requisição All Worker's
```http
GET http://localhost:8765/hr-worker/api/v1/workers    
```

## Resposta All Worker's

| Status Code | Descrição |
| :--- | :--- |
| 200 | `OK` |
```javascript
[
  {
    "id": 1,
    "name": "Athos",
    "dailyIncome": 200.0
  },
  {
    "id": 2,
    "name": "Porthos",
    "dailyIncome": 300.0
  },
  {
    "id": 3,
    "name": "Aramis",
    "dailyIncome": 250.0
  }
]
```

## Requisição Get Worker
```http
GET http://localhost:8765/hr-worker/api/v1/workers/{workerId}    
```
| Variavel | Tipo | Descrição |
| :--- | :--- | :--- |
| `workerId` | `long` | **Obrigatório**. Id do trabalhador |

## Resposta Get Worker

| Status Code | Descrição |
| :--- | :--- |
| 200 | `OK` |
```javascript
{
  "id": 1,
  "name": "Athos",
  "dailyIncome": 200.0
}
```

# Autor

Fabio Vital Lucena da Silva

https://www.linkedin.com/in/fabio-vital-7b98b1233/
