# JDBC - Linkedin Learning
CRUD - Acrônimo para as 4 principais operações feitas num banco de dados: CREATE, READ, UPDATE e DELETE.
É parte do **DML** (Data Manipulation Language). A maioria das declarações/comandos SQL são derivados desses quatro comandos.

Pontos chaves para aprender SQL:
* aprender o próprio SQL (como funciona e como o otimizar);
* aprender Álgebra Relacional ([1](https://www.ic.unicamp.br/~geovane/mo410-091/Ch04a-AlgR_pt.pdf) e [2](https://pt.wikipedia.org/wiki/%C3%81lgebra_relacional)).

### CREATE
Feita por meio da declaração INSERT. Deve respeitar as restrições definidas no schema. O INSERT, por padrão, não é indepotente - i.e., cada vez que o comando for executado, um resultado diferetente, ou adicional, será observado.

### READ
Declaração SELECT. As restrições não são tão importantes, até que se façam operações JOIN. É uma operação sempre indepotente.

### UPDATE
Declaração UPDATE. As restrições podem complicar sua operação e pode ser que você deseje se livrar delas. A operação vai ser indepotente após a primeira ação.

### DELETE
Declaração DELETE. As restrições podem causar anomalias ou erros. Se torna indepotente após a primeira execução.


O **DAO** provê uma abstração entre JDBC e o resto do código. Pode ser tanto uma abstração quanto um verdadeiro objeto. Os **DTOs**(Data Transfer Objects) costumam ser usados com os DAOs. DTO é um objeto completamente encapsulado que pode possuir sub objetos. Geralmente isso pode ser entendido como tabelas mães e filhas. A entrada e saída de um DAO deve ser um DTO e suas tabelas filhas. DAO deve conter os dados de um único domínio, i.e., os dados de endereço, telefone e e-mail de um usuário devem estar em um único DAO. Mas ele suporta múltiplas tabelas; afinal, se trabalhamos com uma única tabela, devemos estar montando um repositório.

O DAO pode aproveitar os métodos de OO para criar um Factory de DAO, permitindo o uso de caminhos comuns de operações de CRUD.

Deve haver uma classe *DAO* com todas as queries do SQL. Essa classe é que deve ser acessada para alterar o objeto que está sendo persistido no banco de dados. A classe DAO deve conter uma query que contemple todas as alterações possíveis.

>UPDATE customer SET first_name = ?, " +
            "last_name = ?, email = ?, phone = ?, address = ?, city = ?, state = ?, zipcode = ? WHERE customer_id = ?";

Entretanto, não vai ser necessário usar todas essas alterações possíveis. Pode ser feita apenas uma mudança de email, por exemplo, sem se preocupar com as demais.
