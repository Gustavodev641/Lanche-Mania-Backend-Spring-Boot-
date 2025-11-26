# 🍽️ Sistema de Cardápio Digital (Backend - Spring Boot)

Esta é a aplicação **backend** responsável por gerenciar os dados e a lógica de negócios de um sistema de cardápio digital. Desenvolvido com **Java** e o framework **Spring Boot**, o projeto expõe uma API REST para que um frontend (ou outros serviços) possa consultar e manipular os itens do menu.

## 🚀 Tecnologias Utilizadas

* **Linguagem:** Java 17+
* **Framework:** Spring Boot
* **Gestor de Dependências:** Maven ou Gradle (Ajuste conforme sua escolha)
* **Banco de Dados:** (Ex: PostgreSQL, MySQL, H2 - **Preencha com o seu DB**)
* **Padrão:** RESTful API

## ✨ Funcionalidades Principais

* **CRUD de Itens:** Gerenciamento completo (Criação, Leitura, Atualização e Deleção) de pratos, bebidas e sobremesas.
* **Endpoints Otimizados:** API RESTful para consulta eficiente do cardápio.
* **Estrutura Escalável:** Base para futuras integrações, como gerenciamento de pedidos e autenticação.

## 🛠️ Pré-requisitos

Para rodar o projeto localmente, você precisará ter instalado:

* **JDK (Java Development Kit):** Versão 17 ou superior.
* **Maven** ou **Gradle** (dependendo da sua escolha).
* **Git Bash** (ou qualquer terminal compatível com Git).
* **IDE:** IntelliJ IDEA (recomendado) ou VS Code.

## ⚙️ Configuração e Execução

Siga os passos abaixo para configurar e iniciar a aplicação no seu ambiente local.

### 1. Clonar o Repositório

Abra o Git Bash (ou terminal) e clone este repositório:

```bash
git clone [https://github.com/Gustavodev641/Lanche-Mania-Backend-Spring-Boot.git](https://github.com/Gustavodev641/Lanche-Mania-Backend-Spring-Boot.git)
cd Lanche-Mania-Backend-Spring-Boot
2. Configurar o Banco de DadosCrie um banco de dados e atualize o arquivo de configuração (src/main/resources/application.properties ou application.yml) com suas credenciais.Propriedades# Exemplo de configuração para PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/cardapio_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
3. Compilar e RodarUse o Maven ou Gradle para construir e executar a aplicação:🔹 Usando o MavenBash# Compila o projeto
mvn clean install

# Executa a aplicação
mvn spring-boot:run
🔹 Usando GradleBash# Executa a aplicação
./gradlew bootRun
A aplicação estará disponível em http://localhost:8080(a porta padrão do Spring Boot).🔗 Endpoints da API (exemplos)MétodoPonto finalDescriçãoGET/api/cardapioRetorna todos os itens do cardápio.POST/api/cardapioCrie um novo item no cardápio.DELETE/api/cardapio/{id}Remover um item pelo ID.🤝 ContribuiçõesContribuições, edições e novas funcionalidades são bem-vindas! Sinta-se à vontade para abrir uma solicitação pull .📧 ContatoGustavo - [Seu Email]
