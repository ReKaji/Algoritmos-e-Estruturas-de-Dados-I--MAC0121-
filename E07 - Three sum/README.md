# Descrição:

Considere o Problema 3SUM: dada uma sequência de números (ai)0≤i<N
, determinar o número de triplas (i,j,k)
 com i<j<k
 e ai+aj+ak=0
. Um algoritmo elementar para resolver 3SUM é implementado no programa ThreeSum.java que vimos (também dado abaixo). Esse algoritmo tem complexidade de tempo Θ(N3)
.

Vimos como resolver 3SUM de forma consideravelmente mais eficiente, usando busca binária. É fácil ver que o algoritmo resultante tem complexidade de pior caso O(N2logN)
. Também não é muito difícil ver que sua complexidade de pior caso é Ω(N2logN)
. Assim, o programa ThreeSumBinary.java, que implementa esse algoritmo, tem complexidade de pior caso Θ(N2logN)
.

Comentamos em sala que existe um algoritmo de complexidade de tempo Θ(N2)
 para 3SUM. Neste exercício, você implementará tal algoritmo. Seu programa deve chamar-se ThreeSumQuad.java. O main() de seu programa ThreeSumQuad.java deve ser igual ao main() de ThreeSum.java e ThreeSumBinary.java. Você deve implementar seu algoritmo quadrático na função count() de seu programa ThreeSumQuad.java.

O algoritmo quadrático.  Para conceber o algoritmo quadrático para 3SUM, lembre-se do Exercício Teórico T09 Busca em A + A. Com aquele exercício em mente, será fácil desenvolver um algoritmo quadrático para 3SUM.

Elementos repetidos.  É necessário que valha uma hipótese importante para o funcionamento correto de ThreeSumBinary.java: a entrada de ThreeSumBinary.java não deve conter elementos repetidos; com entradas com repetição, ThreeSumBinary.java pode ter saída incorreta (por quê?).

Importante.  Seu programa quadrático ThreeSumQuad.java deve funcionar corretamente mesmo que haja repetições na entrada.

Integer overflow.  Tanto no programa ThreeSum.java como em ThreeSumBinary.java, não nos preocupamos com integer overflow. Da mesma forma, você não precisa se preocupar com integer overflow em seu programa ThreeSumQuad.java.

Gerador de entradas.  Para gerar entradas com as quais experimentar seu programa ThreeSumQuad.java, você pode usar os programas RandomInts.java e RandomIntsPlain.java. O programa RandomInts.java gera sequências sem repetição, enquanto que RandomIntsPlain.java gera sequências sem restrição quanto a repetições.

$ java-introcs RandomInts 10 20 121
-17 -8 -4 5 7 8 9 11 12 17
$ java-introcs RandomIntsPlain 10 20 121
-8 17 7 9 17 -17 8 11 12 -4
$

Nos exemplos acima, 10 indica que queremos 10 inteiros e 20 indica que queremos números aleatórios uniformemente distribuídos no intervalo [−20,20]
. Esses programas recebem no terceiro argumento uma semente para o gerador de números aleatórios.

Observação.  O programa RandomInts.java usa o tipo de dado SET<Integer>, que ainda não estudamos.

Exemplos de execução

$ java-introcs RandomInts 10 20 121 | java-introcs ThreeSum
3
-17 5 12
-17 8 9
-8 -4 12
$ java-introcs RandomInts 10 20 121 | java-introcs ThreeSumBinary
3
-17 5 12
-17 8 9
-8 -4 12
$ java-introcs RandomInts 10 20 121 | java-introcs ThreeSumQuad
3
-17 8 9
-17 5 12
-8 -4 12
$

ThreeSumBinary.java pode ter saída incorreta quando há elementos repetidos:

$ java-introcs RandomIntsPlain 6 3 2023
-1 -2 3 2 2 0
$ java-introcs RandomIntsPlain 6 3 2023 | java-introcs ThreeSum
3
-1 -2 3
-2 2 0
-2 2 0
$ java-introcs RandomIntsPlain 6 3 2023 | java-introcs ThreeSumBinary
2
-2 -1 3
-2 0 2
$

O programa ThreeSumBinaryDups.java é uma versão de ThreeSumBinary.java que permite elementos repetidos:

$ java-introcs RandomIntsPlain 6 3 2023 | java-introcs ThreeSumBinaryDups
3
-2 -1 3
-2 0 2
-2 0 2
$

Desempenho.  Seu programa ThreeSumQuad.java deve ser muito mais rápido que ThreeSum.java:

$ java-introcs RandomIntsPlain 5000 100000 121 > tmp.txt ; time java-introcs ThreeSum < tmp.txt
79379

real 0m18.197s
user 0m18.186s
sys 0m0.044s
$ java-introcs RandomIntsPlain 5000 100000 121 > tmp.txt ; time java-introcs ThreeSumQuad < tmp.txt
79379

real 0m0.137s
user 0m0.178s
sys 0m0.013s
$

Provavelmente seu ThreeSumQuad.java será um tanto mais rápido que ThreeSumBinaryDups.java:

$ java-introcs RandomIntsPlain 20000 100000 121 > tmp.txt ; time java-introcs ThreeSumQuad < tmp.txt
5006256

real 0m0.643s
user 0m0.705s
sys 0m0.018s
$ java-introcs RandomIntsPlain 20000 100000 121 > tmp.txt ; time java-introcs ThreeSumBinaryDups < tmp.txt
5006256

real 0m8.760s
user 0m8.798s
sys 0m0.031s
$

Doubling test.  Usando o doubling test é possível ter uma ideia da complexidade dos vários algoritmos (veja o código do programa DoublingTest.java para interpretar as saídas abaixo):

$ java-introcs DoublingTest 0 512 2023
Algorithm: N^3
   size    time  ratio
    512    0.02   0.81
   1024    0.16   7.67
   2048    1.27   7.86
   4096   10.11   7.99
   8192   80.53   7.97
[...]
$ java-introcs DoublingTest 1 512 2023
Algorithm: N^2\log N
   size    time ratio
    512    0.00  0.40
   1024    0.01  4.50
   2048    0.05  5.33
   4096    0.21  4.35
   8192    1.00  4.77
  16384    3.98  3.99
  32768   15.43  3.88
  65536   62.60  4.06
[...]
$ java-introcs DoublingTest 2 512 2023
Algorithm: N^2\log N (allowing duplicates)
   size   time  ratio
    512   0.00   0.43
   1024   0.01   4.33
   2048   0.05   3.77
   4096   0.22   4.49
   8192   1.07   4.86
  16384   5.02   4.70
  32768  22.04   4.39
  65536  96.42   4.38
 131072 408.71   4.24
[...]
$ java-introcs DoublingTest 3 512 2023
Algorithm: N^2
   size   time  ratio
    512   0.00   0.50
   1024   0.00   3.00
   2048   0.01   2.67
   4096   0.03   3.13
   8192   0.10   3.96
  16384   0.38   3.80
  32768   1.53   4.06
  65536   6.16   4.03
 131072  24.82   4.03
[...]
$
