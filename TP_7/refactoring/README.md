# Exercise 1:
Na classe orderLine, os atributos estavam como *private*, pelo que procedi ao seu encapsulamento (Encapsulate Field).

Implementando o método:

`
public double getTotal() {
    return this.product.getPrice() * this.quantity;
}`

conseguimos evitar a repetição de código dentro da classe Order (Extract Method e Inline).

Na classe OrderLine, podemos implementar o método toString, para simplificar o código do método printOrder da classe Order.

#Exercise 2:
Temos adicionar 2 classes derivadas da classe Shape, Circle e Rectangle (Extract Subclass).

#Exercise 3:
Temos que transformar a classe Discount numa classe abstrata ou interface e criar três classes que a implementem: FixedDiscount, PertentageDiscount
e NullDiscount (Extract Subclass).