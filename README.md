# API de Eventos 📅

Uma API desenvolvida com Spring Boot para gerenciamento de eventos, participantes e inscrições. O sistema permite a criação de eventos, cadastro de participantes e a realização de inscrições, com controle de vagas e tratamento de exceções.

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **Spring Data JPA** (Persistência de dados)
- **MySQL** (Banco de dados)
- **Lombok** (Redução de boilerplate)
- **SpringDoc OpenAPI (Swagger)** (Documentação da API)
- **Maven** (Gerenciador de dependências)

## 🛠️ Pré-requisitos

Antes de iniciar, você precisará ter instalado em sua máquina:

- **JDK 21** ou superior
- **Maven**
- **MySQL Server**

## 📦 Instalação e Execução

1. **Clonar o repositório:**
   ```bash
   git clone <url-do-repositorio>
   cd api_eventos
   ```

2. **Configurar o Banco de Dados:**
   Crie um banco de dados MySQL chamado `apiEventos` ou altere as configurações no arquivo `src/main/resources/application.yaml`.
   
   Configurações padrão:
   - **URL:** `jdbc:mysql://localhost:3306/apiEventos`
   - **Usuário:** `root`
   - **Senha:** `root`

3. **Executar a aplicação:**
   ```bash
   ./mvnw spring-boot:run
   ```

## 📖 Documentação da API (Swagger)

Após iniciar a aplicação, você pode acessar a documentação interativa do Swagger para testar os endpoints:

👉 `http://localhost:8080/swagger-ui/index.html`

## 🛣️ Endpoints Principais

### Eventos (`/evento`)
- `POST /evento` - Cria um novo evento.
- `GET /evento` - Lista todos os eventos.
- `GET /evento/{id}` - Busca um evento por seu ID.

### Participantes (`/api/participante`)
- `POST /api/participante` - Cadastra um novo participante.
- `GET /api/participante` - Lista todos os participantes.

### Inscrições (`/inscricoes`)
- `POST /inscricoes` - Realiza a inscrição de um participante em um evento.
- `GET /inscricoes/pessoas/{id}` - Lista todas as inscrições de um participante específico.

## 🏗️ Arquitetura

O projeto segue o padrão de camadas:
- **Controller**: Camada de exposição da API, lidando com as requisições HTTP.
- **Service**: Camada de negócio, onde reside a lógica de validação (ex: controle de vagas).
- **Repository**: Camada de acesso a dados via Spring Data JPA.
- **Model/DTO**: Definições de entidades de banco de dados e objetos de transferência de dados.
- **Config**: Tratamento global de exceções (`GlobalExceptionHandler`) e exceções customizadas.

## ⚠️ Tratamento de Erros

A API possui um tratamento global de exceções para garantir respostas consistentes:
- `RecursoNaoEncontradoException`: Retornada quando um recurso solicitado não existe.
- `RecursoDuplicadoException`: Retornada quando tenta-se criar um recurso que já existe.
- `LimiteVagaException`: Retornada quando um evento não possui mais vagas disponíveis para inscrição.
