# Exercício : 

(i) Escreva uma função de assinatura

public static long n_ebfR(int N)

que recebe um inteiro não-negativo N
 e que devolve o número b(N)
 de expressões bem formadas com N
 pares de parênteses. Sua função n_ebfR() deve ser uma implementação direta da recursão que você encontrou para b(N)
 no Exercício T04.

(ii) Escreva uma função de assinatura

public static long n_ebfM(int N)

que recebe um inteiro não-negativo N
 e que devolve o número b(N)
 de expressões bem formadas com N
 pares de parênteses. Sua função n_ebfM() deve ser uma implementação memoizada de n_ebfR().

Coloque suas funções em um arquivo chamado E02.java. Você pode supor que sua função n_ebfM() será executada com argumentos N
 com N≤35
.

Um cliente.  Suas funções podem ser testadas com o programa cliente NEBF.java abaixo. Espera-se que a execução de NEBF.java com suas funções tenha saída semelhante à saída dada a seguir.

$ java-introcs NEBF 21
Versão recursiva memoizada:
b(0) = 1    [0.0s]
b(1) = 1    [0.0s]
b(2) = 2    [0.0s]
b(3) = 5    [0.0s]
b(4) = 14    [0.0s]
b(5) = 42    [0.0s]
b(6) = 132    [0.0s]
b(7) = 429    [0.0s]
b(8) = 1430    [0.0s]
b(9) = 4862    [0.0s]
b(10) = 16796    [0.0s]
b(11) = 58786    [0.0s]
b(12) = 208012    [0.0s]
b(13) = 742900    [0.0s]
b(14) = 2674440    [0.0s]
b(15) = 9694845    [0.0s]
b(16) = 35357670    [0.0s]
b(17) = 129644790    [0.0s]
b(18) = 477638700    [0.0s]
b(19) = 1767263190    [0.0s]
b(20) = 6564120420    [0.0s]
b(21) = 24466267020    [0.0s]

Versão recursiva simples:
b(0) = 1    [0.0s]
b(1) = 1    [0.0s]
b(2) = 2    [0.0s]
b(3) = 5    [0.0s]
b(4) = 14    [0.0s]
b(5) = 42    [0.0s]
b(6) = 132    [0.0s]
b(7) = 429    [0.0s]
b(8) = 1430    [0.0s]
b(9) = 4862    [0.0s]
b(10) = 16796    [0.0s]
b(11) = 58786    [0.001s]
b(12) = 208012    [0.001s]
b(13) = 742900    [0.003s]
b(14) = 2674440    [0.009s]
b(15) = 9694845    [0.026s]
b(16) = 35357670    [0.077s]
b(17) = 129644790    [0.233s]
b(18) = 477638700    [0.697s]
b(19) = 1767263190    [2.086s]
b(20) = 6564120420    [6.268s]
b(21) = 24466267020    [18.806s]
$
