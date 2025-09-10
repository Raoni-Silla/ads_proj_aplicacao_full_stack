# 🚀 Controle de Gastos com Spring Boot e HTMX

**Versão:** v2.1  

Bem-vindo ao **Controle de Gastos**, uma aplicação para registrar receitas e despesas de forma prática, utilizando **Spring Boot** no backend e **HTMX + Thymeleaf** no frontend.  
O deploy é feito com **Docker** e **Render**, usando **H2 em desenvolvimento** e **PostgreSQL no Neon em produção**.

---

## ⚙️ Tecnologias Utilizadas

- **Backend:** Java 21, Spring Boot, Spring Data JPA  
- **Frontend:** Thymeleaf + HTMX  
- **Banco de Dados:** H2 (Dev), PostgreSQL (Prod - Neon)  
- **Deploy:** Docker, Render  

---

## 📐 Arquitetura (MVC)

A aplicação segue o padrão **Model-View-Controller**, garantindo organização e manutenção facilitada.

```mermaid
graph TD
    subgraph Browser
        A[👨‍💻 Usuário]
    end

    subgraph "Aplicação Spring Boot (Docker)"
        C[LancamentoController] --> D{LancamentoRepository}
        D --> E[Lancamento - Entidade]
        C --> B[View: Thymeleaf + HTMX]
    end

    subgraph "Banco de Dados (Neon)"
        F[(PostgreSQL)]
    end

    A <-->|Requisições HTTP| B
    B -- via HTMX --> C
    E --> F

⚡ Como o HTMX funciona

HTMX permite que o HTML interaja diretamente com o servidor, sem precisar escrever muito JavaScript.
Ele responde a 4 perguntas principais:

    O que aciona? → hx-trigger (ex: clique, submit, etc.)

    Qual requisição fazer? → hx-get, hx-post, hx-put, hx-delete

    Qual o alvo da atualização? → hx-target (seletor CSS)

    Como atualizar? → hx-swap (innerHTML, outerHTML, etc.)

📂 Estrutura Final do Projeto

controle-de-gastos/
├── src/
│   ├── main/
│   │   ├── java/br/com/controledegastos/
│   │   │   ├── ControleDeGastosApplication.java
│   │   │   ├── controller/LancamentoController.java
│   │   │   ├── model/
│   │   │   │   ├── Lancamento.java
│   │   │   │   └── TipoLancamento.java
│   │   │   └── repository/LancamentoRepository.java
│   │   └── resources/
│   │       ├── templates/index.html
│   │       ├── application.properties
│   │       └── application-prod.properties
├── Dockerfile
├── pom.xml
└── mvnw

🚀 Executando Localmente
1. Clonar o repositório

git clone https://github.com/seu-usuario/controle-de-gastos.git
cd controle-de-gastos

2. Garantir permissão de execução no mvnw

git update-index --chmod=+x mvnw

3. Rodar a aplicação (H2 Database)

./mvnw spring-boot:run

➡ Acesse em: http://localhost:8080
🐳 Executando com Docker
1. Construir a imagem

docker build -t controle-de-gastos .

2. Rodar o container

docker run -p 8080:8080 controle-de-gastos

➡ Acesse em: http://localhost:8080
☁️ Deploy no Render (Produção)

    Criar banco no Neon e obter credenciais.

    No Render, criar um New Web Service → conectar o repositório.

    Escolher Docker Runtime.

    Configurar Environment Variables:

        SPRING_PROFILES_ACTIVE=prod

        DB_URL=jdbc:postgresql://...

        DB_USERNAME=...

        DB_PASSWORD=...

    Criar o serviço e aguardar o deploy.

🛠 Problemas Comuns
❌ Erro Permission denied (mvnw)

✅ Solução:

git update-index --chmod=+x mvnw
git commit -m "fix: adiciona permissão de execução ao mvnw"
git push origin main

❌ Erro de Codificação (MalformedInputException)

✅ Solução:

    Garanta que os arquivos .properties estão salvos em UTF-8.

    Confirme que o pom.xml contém:

<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>

✅ Conclusão

Com esse guia, você consegue:

    Criar um CRUD completo de lançamentos financeiros

    Usar Spring Boot + HTMX para interações dinâmicas

    Rodar a aplicação em Docker

    Fazer deploy em produção com Render

👨‍💻 Autor: [Seu Nome]
📌 Licença: MIT
