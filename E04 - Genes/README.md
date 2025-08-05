# Exercício

Neste exercício, vamos definir gene como sendo palavras sobre o alfabeto Σ={A,C,T,G}
 que satisfazem os critérios dados/implementados em PotentialGene.java em

https://www.ime.usp.br/~yoshi/2023ii/mac0121/sandbox/2023.11.07/

Assim, s∈Σ∗
 é um gene se o programa PotentialGene.java executado com entrada s
 imprime true. Será mais conveniente chamarmos de gene a palavra s
 toda, incluindo o start codon e o stop codon.

Lembre que na página 43 de

https://www.ime.usp.br/~yoshi/Sedgewick/cos126.2017i/CS.08.ADTs.pdf

é sugerido, em linhas gerais, um algoritmo para encontrar genes em genomas. Uma implementação parcial da ideia lá esboçada é

https://introcs.cs.princeton.edu/java/31datatype/GeneFind.java.html

Note que GeneFind.java considera cada stop codon separadamente. Uma implementação que considera os três stop codons conjuntamente é dado em GeneFindImproved.java abaixo.

Exercício. Um primeiro exercício instrutivo é verificar que se uma palavra s
 faz parte da saída de GeneFindImproved.java, então s
 é um gene, isto é, PotentialGene.java executado com entrada s
 tem saída true.

Algoritmo de força bruta e a não completude de GeneFindImproved.java.  Podemos encontrar todos os genes em uma palavra t∈Σ∗
 executando FindGeneBrute.java, dado abaixo.

Exercício. Dê um exemplo de entrada t
 para GeneFindImproved.java que contém mais genes que GeneFindImproved.java encontra. Isto é, encontre t
 tal que FindGeneBrute.java executado com entrada t
 produz mais saída que GeneFindImproved.java produz quando executado com a mesma entrada t
.

Um programa completo e mais eficiente.  Neste exercício, você deve escrever um programa chamado FindGene.java que encontra todos os genes em uma palavra t∈Σ∗
 dada como entrada. A menos da ordem das palavras na saída, seu programa deve ter a mesma saída que FindGeneBrute.java. A segunda exigência sobre FindGene.java é que ele deve ser bem mais eficiente que FindGeneBrute.java.  

Quando a entrada t
 tem contém muitos genes, o tempo de execução de FindGene.java será afetado pelo tempo de impressão dos genes encontrados.  Para podermos nos focar no tempo gasto para se encontrar os genes, seu programa FindGene.java deverá ter um modo de execução "numérico", em que ele somente imprime o número de genes encontrados.  Para executar seu FindGene.java nesse modo numérico, o usuário fornecerá um argumento de linha de comando qualquer (veja exemplos abaixo).

Eficiência de FindGene.java. Como os exemplos de execução abaixo ilustram, espera-se que FindGene.java tenha tempo de execução grosso modo proporcional ao comprimento da entrada, quando executado no modo numérico.

O programa Generate.java é usado para gerar entradas aleatórias. 

$ java-introcs Generate 500 122 | java-introcs FindGene
ATGAAACCCTTTTGA
ATGTACAAACCTACCGGTGGAACTGAGGTCTTTGTGCGTCCATGGGAAATTTTGTTTGGTTAA
ATGCACATTAGCTGCCTCAAGACAATCCCGCGTATTCGACGGAACTAA
ATGTGA
ATGGACGACCACCATCCAACGCCTATAATATGCACATTAGCTGCCTCAAGACAATCCCGCGTATTCGACGGAACTAAAATGGCTTATAGGCATTGTTCTCGCACTATGTTCCCCATGGGGTACGGGACTAACAGACAATTTGTCCATTCGTTTTAG
ATGGCTTATAGGCATTGTTCTCGCACTATGTTCCCCATGGGGTACGGGACTAACAGACAATTTGTCCATTCGTTTTAG
ATGTTCCCCATGGGGTACGGGACTAACAGACAATTTGTCCATTCGTTTTAG
ATGGGGTACGGGACTAACAGACAATTTGTCCATTCGTTTTAG
ATGGGAAATTTTGTTTGGTTAACATAA
$ java-introcs Generate 500 122 | java-introcs FindGene -
9
$ time java-introcs Generate 2000000 122 | java-introcs FindGene -
31457

real 0m1.519s
user 0m2.123s
sys 0m1.052s
$ time java-introcs Generate 4000000 122 | java-introcs FindGene -
62878

real 0m2.678s
user 0m4.148s
sys 0m1.333s
$ time java-introcs Generate 8000000 122 | java-introcs FindGene -
125476

real 0m5.213s
user 0m8.260s
sys 0m2.260s
$ time java-introcs Generate 16000000 122 | java-introcs FindGene -
251043

real 0m10.066s
user 0m16.454s
sys 0m3.506s
$

Note que FindGeneBrute.java comporta-se bem pior conforme o tamanho da entrada aumenta (FindGeneBrute.java também admite o modo numérico de execução):

$ time java-introcs Generate 2500 122 | java-introcs FindGeneBrute -
42

real 0m0.403s
user 0m0.367s
sys 0m0.142s
$ time java-introcs Generate 5000 122 | java-introcs FindGeneBrute -
78

real 0m1.231s
user 0m1.236s
sys 0m0.183s
$ time java-introcs Generate 10000 122 | java-introcs FindGeneBrute -
152

real 0m8.068s
user 0m8.236s
sys 0m0.305s
$ time java-introcs Generate 20000 122 | java-introcs FindGeneBrute -
330

real 1m12.067s
user 1m12.638s
sys 0m1.619s
$

Comparação das saídas de FindGene.java e FindGeneBrute.java.  Para comparar as saídas de seu FindGene.java e FindGeneBrute.java, você pode ordenar as saídas usando o programa sort:

$ java-introcs Generate 400 122 | java-introcs FindGeneBrute | sort
ATGAAACCCTTTTGA
ATGCACATTAGCTGCCTCAAGACAATCCCGCGTATTCGACGGAACTAA
ATGGACGACCACCATCCAACGCCTATAATATGCACATTAGCTGCCTCAAGACAATCCCGCGTATTCGACGGAACTAAAATGGCTTATAGGCATTGTTCTCGCACTATGTTCCCCATGGGGTACGGGACTAACAGACAATTTGTCCATTCGTTTTAG
ATGGCTTATAGGCATTGTTCTCGCACTATGTTCCCCATGGGGTACGGGACTAACAGACAATTTGTCCATTCGTTTTAG
ATGGGGTACGGGACTAACAGACAATTTGTCCATTCGTTTTAG
ATGTGA
ATGTTCCCCATGGGGTACGGGACTAACAGACAATTTGTCCATTCGTTTTAG
$ java-introcs Generate 400 122 | java-introcs FindGene | sort
ATGAAACCCTTTTGA
ATGCACATTAGCTGCCTCAAGACAATCCCGCGTATTCGACGGAACTAA
ATGGACGACCACCATCCAACGCCTATAATATGCACATTAGCTGCCTCAAGACAATCCCGCGTATTCGACGGAACTAAAATGGCTTATAGGCATTGTTCTCGCACTATGTTCCCCATGGGGTACGGGACTAACAGACAATTTGTCCATTCGTTTTAG
ATGGCTTATAGGCATTGTTCTCGCACTATGTTCCCCATGGGGTACGGGACTAACAGACAATTTGTCCATTCGTTTTAG
ATGGGGTACGGGACTAACAGACAATTTGTCCATTCGTTTTAG
ATGTGA
ATGTTCCCCATGGGGTACGGGACTAACAGACAATTTGTCCATTCGTTTTAG
$

Você ainda pode usar o programa md5sum (ou md5 no macOS) para verificar se as saídas coincidem:

$ java-introcs Generate 400 122 | java-introcs FindGeneBrute | sort | md5
2680cad2595e448a6868216d27eeffc7
$ java-introcs Generate 400 122 | java-introcs FindGene | sort | md5
2680cad2595e448a6868216d27eeffc7
$

O fato que as saídas produzidas por md5 nas execuções acima coincidem significa que, muito provavelmente, as saídas produzidas por sort coincidem. Se as saídas de md5 fossem diferentes, teríamos certeza de que as saídas de sort foram diferentes.

Por exemplo, o seguinte mostra que GeneFindImproved.java produz uma saída diferente:

$ java-introcs Generate 400 122 | java-introcs GeneFindImproved | sort | md5
547ec4b519798bfccc5bfa46fd9c13f2
$

Mais exemplos de execução.  Veja alguns exemplos de execução no arquivo experiments.txt abaixo. Os tempos de execução de seu programa devem ser, grosso modo, comparáveis aos tempos nesses exemplos.

O arquivo E04.tar.gz tem o mesmo conteúdo que E04.

Entrega. Entregue apenas seu programa FindGene.java.
