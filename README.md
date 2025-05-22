
#  Projeto Agenda de Contatos em Java

##  Visão Geral

Este projeto implementa uma Agenda de Contatos utilizando Java, aplicando conceitos de Programação Orientada a Objetos (POO) como herança, encapsulamento e polimorfismo. A aplicação permite ao usuário cadastrar, buscar, listar e excluir contatos pessoais ou profissionais diretamente pelo terminal.

---

##  Estrutura de Pacotes
O projeto está estruturado da seguinte forma :
```
projeto_sgc_v1_java/
├── src/
│   └── controle/
│       ├── Agenda.java
│   └── modelo/
│       ├── Contato.java
│       ├── ContatoPessoal.java
│       ├── ContatoProfissional.java
│   └── principal/
│       ├── Main.java
├── README.md
```
O diretório ```projeto_sgc_v1_java``` é a raiz do projeto, nele armazena-se o diretório ```sgc```, ao qual destina-se os arquivos de código fonte ```.java```.

---

##  Classes

###  `Contato` 

Representa um contato genérico, sendo a classe base para os demais tipos.

| Atributo     | Tipo     | Descrição                         |
|--------------|----------|-----------------------------------|
| `id`         | `String` | Identificador único do contato    |
| `nome`       | `String` | Nome completo                     |
| `email`      | `String` | E-mail do contato                 |
| `telefone`   | `String` | Telefone                          |

**Métodos:**
- `getId(), setId()`
- `getNome(), setNome()`
- `getEmail(), setEmail()`
- `getTelefone(), setTelefone()`

Os métodos `get` retornam as propriedades da classe, já os métodos `set` visam editar os valores dessas propriedades.

---

###  `ContatoPessoal`

| Atributo           | Tipo     | Descrição                      |
|--------------------|----------|-------------------------------|
| `dataAniversario`  | `String` | Data de nascimento            |
| `endereco`         | `String` | Endereço residencial          |

**Métodos adicionais:**
- `getDataAniversario(), setDataAniversario()`
- `getEndereco(), setEndereco()`

---

###  `ContatoProfissional`

| Atributo   | Tipo     | Descrição                      |
|------------|----------|-------------------------------|
| `empresa`  | `String` | Nome da empresa               |
| `cargo`    | `String` | Cargo na empresa              |

**Métodos adicionais:**
- `getEmpresa(), setEmpresa()`
- `getCargo(), setCargo()`

---

###  `Agenda`

Classe responsável pela definição dos métodos para adicionar, remover, buscar e listar os contatos.

**Atributos:**
- `ArrayList<Contato> listaDeContatos` → Armazena todos os contatos registrados

**Métodos principais:**

| Método | Descrição |
|--------|-----------|
| `adicionarContatos()` | Adiciona um contato na agenda |
| `removerContatos()` | Exclui um contato pelo **ID** |
| `buscarContatos()` | Busca um contato por **nome**, **telefone** ou **e-mail** |
| `listarContatos()` | Exibe os contatos cadastrados |
| `agendaIsEmpty()` | Verifica se a agenda está vazia |

---


## Requisitos para Compilação
-   **Java Development Kit (JDK)** instalado e configurado.        

----------

##  Instruções de Compilação

### 1. Acesse o diretório do projeto:

No terminal ou prompt de comando:

`cd caminho_para/projeto_sgc_v1_java` 

### 2. Compile o programa:

#### Windows:

`javac -d bin src\modelo\*.java src\controle\Agenda.java src\principal\Main.java` 

#### macOS ou Linux:
`javac -d bin src\modelo\*.java src\controle\Agenda.java src\principal\Main.java`

----------

##  Instruções de Execução

Após a compilação bem-sucedida:

### Windows/Linux/macOS:
Estando no terminal ou prompt de comando e no diretório raiz, execute:

`cd bin`

Esse comando muda para o diretório de arquivos compilados.

Em seguida:

`java principal.Main`

Esse comando executa o programa.


