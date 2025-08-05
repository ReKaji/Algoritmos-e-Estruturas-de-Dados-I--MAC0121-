# Exercício

Alice, Beto e Carla encontram um tesouro, constituído de N
 peças. Cada peça tem um valor inteiro xi≥0
 (0≤i<N
). Eles decidem dividir o tesouro entre eles, e querem saber se há uma divisão justa: uma divisão em que cada um recebe um valor total que é pelo menos ⌊S/3⌋
, onde S=∑ixi
 é o valor total do tesouro.

Para tanto, eles podem usar o programa DivideBrute.java, dado abaixo. Por exemplo, se eles encontraram 12
 peças e elas têm custo como no arquivo 12.in, eles podem executar DivideBrute.java assim:

$ java-introcs DivideBrute . < 12.in
There is a solution
Optimal value: 173 (sum: 520 / want: 173 / sum mod 3 = 1)
0: 34 22 60 58 (sum: 174)
1: 27 67 21 40 18 (sum: 173)
2: 69 80 24 (sum: 173)
$ java-introcs DivideBrute . < 12b.in
There is no solution
Optimal value: 371 (sum: 1120 / want: 373 / sum mod 3 = 1)
0: 34 27 167 121 24 (sum: 373)
1: 169 122 80 (sum: 371)
2: 160 58 40 118 (sum: 376)
$

Note que (veja o código de DivideBrute.java), se eles apenas quiserem saber se existe solução ou não, basta eles executarem o programa sem argumento de linha de comando:

$ java-introcs DivideBrute < 12.in
There is a solution
$ java-introcs DivideBrute < 12b.in
There is no solution
$

Acontece que o número de peças N
 que eles encontraram e encontrarão em ocasiões futuras é maior, e eles assim precisam de um programa mais eficiente do que DivideBrute.java. Neste exercício, você deve escrever tal programa. Seu programa deve chamar-se Divide.java.

Seu programa Divide.java.  Assim como DivideBrute.java, seu programa Divide.java deve receber os xi
 na entrada padrão. Sem argumento de linha de comando, seu programa e DivideBrute.java devem ter a mesma saída.

$ java-introcs Divide < 12.in
There is a solution
$ java-introcs Divide < 12b.in
There is no solution
$

Com algum argumento de linha de comando, se há uma solução satisfatória, a saída de seu programa deve ser como a saída de DivideBrute.java, exceto pelo fato que a solução encontrada não precisa ser a mesma. Se não há uma divisão satisfatória e um argumento de linha de comando é dado, Divide.java deve dizer que não há solução e deve apenas imprimir alguma divisão das peças (não necessariamente a melhor possível).

$ java-introcs Divide . < 12.in
There is a solution
0: 34 22 60 40 18 (sum: 174)
1: 27 67 21 58 (sum: 173)
2: 69 80 24 (sum: 173)
Optimal value: 173 (sum: 520 / want: 173 / mod 3 = 1)
$ java-introcs Divide . < 12b.in
There is no solution
0: 34 27 167 169 122 160 121 80 58 40 24 118 (sum: 1120)
1: (sum: 0)
2: (sum: 0)
Best I found (not necessarily optimal): 0 (sum: 1120 / want: 373 / mod 3 = 1)
$

A eficiência de seu programa Divide.java.  Seu programa deve ser mais rápido que DivideBrute.java. Para comparar velocidades, você pode usar o programa RandomInts.java dado abaixo. Seguem alguns exemplos de execução.

$ time java-introcs RandomInts 15 100 121 | java-introcs DivideBrute .
There is a solution
Optimal value: 188 (sum: 565 / want: 188 / sum mod 3 = 1)
0: 34 27 67 22 21 18 (sum: 189)
1: 69 60 40 19 (sum: 188)
2: 80 58 24 12 14 (sum: 188)

real 0m0.565s
user 0m0.544s
sys 0m0.076s
$ time java-introcs RandomInts 18 100 121 | java-introcs DivideBrute .
There is a solution
Optimal value: 247 (sum: 742 / want: 247 / sum mod 3 = 1)
0: 34 27 67 69 18 14 19 (sum: 248)
1: 22 60 21 80 40 24 (sum: 247)
2: 58 12 78 37 62 (sum: 247)

real 0m11.026s
user 0m11.058s
sys 0m0.076s
$ time java-introcs RandomInts 19 100 121 | java-introcs DivideBrute .
There is a solution
Optimal value: 269 (sum: 807 / want: 269 / sum mod 3 = 0)
0: 34 27 67 69 60 12 (sum: 269)
1: 22 21 80 58 18 14 19 37 (sum: 269)
2: 40 24 78 62 65 (sum: 269)

real 0m35.985s
user 0m35.925s
sys 0m0.131s
$ time java-introcs RandomInts 19 100 121 | java-introcs Divide .
There is a solution
0: 34 27 67 22 21 14 19 65 (sum: 269)
1: 69 60 58 40 24 18 (sum: 269)
2: 80 12 78 37 62 (sum: 269)
Optimal value: 269 (sum: 807 / want: 269 / mod 3 = 0)

real 0m0.114s
user 0m0.156s
sys 0m0.049s
$ time java-introcs RandomInts 19 100000 121 | java-introcs DivideBrute .
There is no solution
Optimal value: 305130 (sum: 915407 / want: 305135 / sum mod 3 = 2)
0: 20034 62027 43167 45624 53219 81062 (sum: 305133)
1: 16169 1360 33880 66240 41318 24512 53214 68437 (sum: 305130)
2: 67922 88721 50458 10178 87865 (sum: 305144)

real 0m35.959s
user 0m35.945s
sys 0m0.123s
$ time java-introcs RandomInts 19 100000 121 | java-introcs Divide .
There is no solution
0: 20034 62027 43167 16169 67922 1360 88721 33880 50458 66240 45624 41318 24512 53214 53219 10178 68437 81062 87865 (sum: 915407)
1: (sum: 0)
2: (sum: 0)
Best I found (not necessarily optimal): 0 (sum: 915407 / want: 305135 / mod 3 = 2)

real 0m0.192s
user 0m0.244s
sys 0m0.037s
$ time java-introcs RandomInts 24 100000 121 | java-introcs Divide .
There is a solution
0: 62027 1360 53214 10178 81062 33741 86079 97803 (sum: 425464)
1: 20034 88721 33880 66240 45624 41318 68437 61210 (sum: 425464)
2: 43167 16169 67922 50458 24512 53219 87865 82154 (sum: 425466)
Optimal value: 425464 (sum: 1276394 / want: 425464 / mod 3 = 2)

real 0m5.968s
user 0m5.905s
sys 0m0.095s
$

Mais exemplos de execução. Veja mais alguns exemplos de execução nos arquivos anexos. Os tempos de execução de seu programa devem ser, grosso modo, comparáveis aos tempos nesses exemplos e nos exemplos acima.

Método. Em seu programa, você deve necessariamente usar backtracking.
