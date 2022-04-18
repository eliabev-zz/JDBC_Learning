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
