
/******************************************************************************
 *
 * MAC0121 ALGORITMOS E ESTRUTURAS DE DADOS I
 * Aluno: Renan Ryu Kajihara
 * Numero USP: 14605762
 * Tarefa: E07
 * Data: 22/12/2023
 * 
 * DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS 
 * PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO  
 * PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE, 
 * FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS 
 * AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 * DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/

import java.util.Arrays;

public class ThreeSumQuad {


    public static int count(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        int count = 0;
        int x;
        int lo;
        int hi;
        int lo_ant;
        int hi_ant;
        for (int i=0; i<n-2; i++){
            lo = i+1;
            hi = n - 1;
            x= - a[i];
            while (lo < hi) {
                if (a[hi] + a[lo] == x) {
                    count++;
                    lo_ant=lo;
                    hi_ant=hi;
                    while (a[hi]+a[lo]==x && lo<hi){
                        lo++;
                        if (a[hi]+a[lo]==x && lo<hi) count++;
                    }
                    lo=lo_ant;
                    while (a[hi]+a[lo]==x && lo<hi){
                        hi--;
                        if (a[hi]+a[lo]==x && lo<hi) count++;
                    }
                    hi=hi_ant;
                    lo++; hi--;
                }
                else if (a[hi] + a[lo] < x) lo++;
                else if (a[hi] + a[lo] > x) hi--; 
            }
        }
        return count;
    } 

    public static void main(String[] args)  { 
        int[] a = StdIn.readAllInts();
	    int count = count(a);
        StdOut.println(count);
    }
} 
