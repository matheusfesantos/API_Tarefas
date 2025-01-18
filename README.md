# Tarefas API

A **Tarefas API** é uma aplicação Java construída com o framework Spring, que permite adicionar e listar tarefas, com informações como nome da tarefa, prazo de início, prazo de fim e dono da tarefa. A API também fornece informações sobre a quantidade de tarefas associadas a cada dono.

## Estrutura do Projeto

```
src/
├── main/
│   ├── data/tarefas/
│   │   ├── logins.txt
│   │   └── tarefas.txt
│   │
│   ├── java/com/tarefas/demo/
│   │   ├── controller/
│   │   │   └── TarefaController.java
│   │   ├── model/
│   │   │   └── Tarefa.java
│   │   ├── service/
│   │   │   └── TarefaService.java
│   │   ├── TarefasApplication.java
│   │   └── util/
│   │       └── BufferedFileUtil.java
│   │
│   ├── resources/
│   │   └── application.properties
│   │
│   └── test/java/com/tarefas/demo/
│       └── TarefasApplicationTests.java
├── .gitignore
├── README.md
├── mvnw
├── mvnw.cmd
├── pom.xml
└── .gitattributes
```

## Imagem

![Exemplo - Tarefas por Dono](https://drive.google.com/uc?export=view&id=1NXl9cCJ6Lo7KOyJ32vgdz2ZbfBM2__42)

![Exemplo - Tarefas Registradas](https://drive.google.com/uc?export=view&id=1jQi0adj90vZ-H1Mjn5s3RX7FzKTV-ThF)

![Exemplo - Usuário Específico](https://drive.google.com/uc?export=view&id=1s3lY6-R5wLMeb3ojMqhGnfqKLo_C-kuy)

## Funcionalidades

A API permite as seguintes operações:

### 1. Adicionar Tarefa

Adiciona uma nova tarefa ao sistema, com os seguintes parâmetros:
- **nome**: Nome da tarefa.
- **inicio**: Prazo de início da tarefa (formato: `yyyy-MM-dd`).
- **prazo**: Prazo final para a tarefa (formato: `yyyy-MM-dd`).
- **dono**: Nome do responsável pela tarefa.

**Método:** `POST`

**Endpoint:** `/tarefas`

### Exemplo de Requisição para Adicionar Tarefa

Ao adicionar uma tarefa, o corpo da requisição `POST` deve seguir o seguinte formato JSON:

```json
{
  "nome": "Desenvolver API",
  "inicio": "2024-01-20",
  "prazo": "2024-02-01",
  "dono": "Matheus Ferreira"
}
```

- **nome**: Nome da tarefa.
- **inicio**: Data de início da tarefa (formato: `yyyy-MM-dd`).
- **prazo**: Prazo final para a tarefa (formato: `yyyy-MM-dd`).
- **dono**: Nome do responsável pela tarefa.

Esse JSON deve ser enviado para o endpoint `/tarefas` com o método `POST`.

### 2. Listar Tarefas

Retorna uma lista de todas as tarefas, com seus dados como nome, prazo de início, prazo de fim e dono.

**Método:** `GET`

**Endpoint:** `/tarefas`

### 3. Contagem de Tarefas por Dono

Retorna uma lista de todos os donos das tarefas e a quantidade de tarefas que cada um possui.

**Método:** `GET`

**Endpoint:** `/tarefas/donos`

**Exemplo de resposta:**

```json
[
  "Matheus Ferreira: 3",
  "Ana Silva: 2"
]
```

### 4. Informações de um Usuário Específico

Retorna todas as tarefas associadas a um dono específico.

**Método:** `GET`

**Endpoint:** `/tarefas/{dono}`

## Como Executar o Projeto

### 1. Clonar o Repositório

Clone o repositório para sua máquina local:

```bash
git clone https://github.com/usuario/tarefas-api.git
```

### 2. Navegar até o Diretório do Projeto

```bash
cd tarefas-api
```

### 3. Rodar a Aplicação com Maven

Para rodar a aplicação, use o Maven Wrapper:

```bash
./mvnw spring-boot:run
```

Isso iniciará a API na porta padrão `8080`.

## Dependências

O projeto usa as seguintes dependências principais:

- **Spring Boot**: Framework principal utilizado para construir a API.
- **Maven**: Para gerenciamento de dependências.
- **Jackson**: Para serialização e desserialização de objetos JSON.

## Arquivos de Configuração

### 1. `application.properties`

Contém as configurações padrão do Spring Boot. Pode ser alterado conforme necessário para configurar a aplicação.

### 2. `tarefas.txt` e `logins.txt`

Arquivos de dados que armazenam as informações das tarefas e dos logins, respectivamente. Esses arquivos são lidos e escritos utilizando a classe `BufferedFileUtil`.

## Testes

Para rodar os testes unitários, utilize o comando:

```bash
./mvnw test
```
