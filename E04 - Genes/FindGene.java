
/******************************************************************************
 *
 * MAC0121 ALGORITMOS E ESTRUTURAS DE DADOS I
 * Aluno: Renan Ryu Kajihara
 * Numero USP: 14605762
 * Tarefa: E04
 * Data: 22/11/2023
 * 
 * DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS 
 * PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO  
 * PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE, 
 * FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS 
 * AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 * DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/

public class FindGene {


    public static void main (String[] args)
    {
        String genoma = StdIn.readString();
        int argumentos = args.length;
        int N = genoma.length();
        int contador = 0;

        int i=0;
        int k=N-5;
        int l= N-2;
        while (i<k){
            if (genoma.substring(i,i+3).equals("ATG")){
                int j = i+3;
                while (j<l){
                    String c= genoma.substring(j,j+3);
                    if (c.equals("TAA") || c.equals("TAG") || c.equals("TGA")){
                        contador++;
                        if (argumentos!=1) StdOut.println (genoma.substring(i, j+3));
                        break;
                    }
                    j+=3;
                }
                i+=3;
            }
            else{
                i++;
            }
        }
        if (argumentos == 1) StdOut.println(contador);
    }
}

