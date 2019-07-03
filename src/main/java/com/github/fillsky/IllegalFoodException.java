package com.github.fillsky;

public class IllegalFoodException extends RuntimeException {

    //Jeżeli wyjąktu nie da się uniknąć stosując ify robimy cheked. Np sprawdzamy czy jest plik, ok jest ale w miedzyczasie można usunąć ten plik i tego nie jesteśmy w stanie sprawdzić.
    ///Handle or Declare - tylko cheked, hadle -try/catch, albo throws.
    //W przecwinym razie robimy uncheked.
}
