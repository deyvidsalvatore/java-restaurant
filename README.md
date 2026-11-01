# 🍔 Sistema de Restaurante

Projeto desenvolvido como **avaliação prática do programa ElasTech — Java + IA**, com o objetivo de aplicar conceitos de Programação Orientada a Objetos, padrões de projeto, estruturas de dados e testes automatizados utilizando Java.

A aplicação simula o gerenciamento de um restaurante, permitindo cadastrar pedidos, personalizar lanches, adicionar itens aos pedidos, editar e cancelar pedidos, além de realizar o fechamento do dia.

O desenvolvimento foi realizado em etapas, acompanhando os requisitos propostos pela avaliação.

## 🚀 Funcionalidades

- Cadastro de pedidos com identificação do cliente.
- Numeração sequencial dos pedidos.
- Cardápio com três opções de lanches:
    - X-Burger — R$ 16,00
    - X-Salada — R$ 18,00
    - X-Bacon — R$ 22,00
- Personalização dos lanches, permitindo retirar ingredientes:
    - Queijo
    - Alface
    - Tomate
    - Cebola
- Implementação de adicionais:
    - Cheddar — acréscimo de R$ 4,00.
    - Bacon extra — acréscimo de R$ 6,00.
- Listagem dos pedidos registrados.
- Remoção de lanches de um pedido.
- Adição de lanches a pedidos existentes.
- Cancelamento de pedidos.
- Cálculo do total de vendas do dia.
- Identificação de lanches diferentes por descrição.
- Validação de entradas numéricas e respostas do usuário.

## 🛠️ Tecnologias utilizadas

- Java 21
- Maven
- JUnit 5
- Git e GitHub
- IntelliJ IDEA

## 🧠 Conceitos aplicados

Durante o desenvolvimento, foram trabalhados conceitos importantes da programação orientada a objetos e padrões de projeto:

| Conceito | Aplicação no projeto |
|---|---|
| Encapsulamento | Controle de acesso aos atributos das classes. |
| Interfaces | Contrato `ItemCardapio`, implementado pelos itens do cardápio. |
| Factory | Criação dos lanches por meio da classe `LancheFactory`. |
| Decorator | Adição dinâmica de cheddar e bacon extra aos lanches. |
| Facade | Centralização do acesso às operações do restaurante. |
| Collections | Utilização de `ArrayList`, `HashMap`, `HashSet` e `Set`. |
| Tratamento de exceções | Validação de entradas e dados inválidos. |
| Testes automatizados | Testes unitários com JUnit 5. |

## 📂 Estrutura do projeto

```text
java-restaurant/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/wylianedamaso/restaurant/
│   │           ├── app/
│   │           │   ├── Main.java
│   │           │   ├── MenuConsole.java
│   │           │   └── RestauranteFacade.java
│   │           ├── cardapio/
│   │           │   ├── ItemCardapio.java
│   │           │   ├── Lanche.java
│   │           │   ├── LancheFactory.java
│   │           │   └── adicionais/
│   │           │       ├── ComBaconExtra.java
│   │           │       └── ComCheddar.java
│   │           └── pedido/
│   │               ├── Pedido.java
│   │               └── GerenciadorPedidos.java
│   └── test/
│       └── java/
│           └── com/wylianedamaso/restaurant/
│               ├── cardapio/
│               │   └── LancheTest.java
│               ├── adicionais/
│               │   └── AdicionaisTest.java
│               └── pedido/
│                   ├── PedidoTest.java
│                   └── GerenciadorPedidosTest.java
```

## ▶️ Como executar o projeto

### Pré-requisitos

- JDK 21 ou superior.
- Maven instalado.
- IntelliJ IDEA ou outra IDE compatível com Java.

### 1. Clonar o repositório

```bash
git clone https://github.com/wylianedamaso/java-restaurant.git
```

### 2. Acessar a pasta do projeto

```bash
cd java-restaurant
```

### 3. Executar os testes

```bash
mvn test
```

### 4. Executar a aplicação

Abra o projeto no IntelliJ IDEA e execute a classe `Main.java`, localizada no pacote `app`.

## 🧪 Testes automatizados

O projeto possui testes unitários desenvolvidos com JUnit 5, organizados por responsabilidade:

- **LancheTest:** validação dos dados e personalização dos ingredientes.
- **AdicionaisTest:** cálculo dos valores e composição das descrições dos adicionais.
- **PedidoTest:** criação, validação, inclusão de itens e cálculo do total.
- **GerenciadorPedidosTest:** numeração sequencial, busca de pedidos e cálculo do total diário.

Para executar todos os testes:

```bash
mvn test
```

## 📚 Aprendizados

Este projeto proporcionou a oportunidade de colocar em prática conceitos estudados durante o programa ElasTech — Java + IA, exercitando a organização de código, a separação de responsabilidades, a aplicação de padrões de projeto e a criação de testes automatizados.

Também foi uma oportunidade de desenvolver o raciocínio lógico e compreender melhor como diferentes classes e componentes trabalham juntos para construir uma aplicação.

---

**Desenvolvido como parte da avaliação prática do programa ElasTech — Java + IA.**

**Autora:** [Wyliane Damaso](https://github.com/wylianedamaso)