
/******************************************************************************
 *
 * MAC0121 ALGORITMOS E ESTRUTURAS DE DADOS I
 * Aluno: Renan Ryu Kajihara
 * Numero USP: 14605762
 * Tarefa: E06
 * Data: 10/12/2023
 * 
 * DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS 
 * PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO  
 * PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE, 
 * FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS 
 * AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 * DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/

public class SubsequencesQ3
{
    public static long noOccurrencesFast(int[] s, int[] t) {
       int M= t.length;
       int N = s.length;
       int [][] matriz= new int [M][N];

        if (s[0]==t[0]) matriz[0][0]=1;
        else matriz[0][0]=0;

        for (int i=1; i<M;i++){
            if (s[0]==t[i])matriz[i][0]= matriz [i-1][0]+1;
            else matriz [i][0]= matriz[i-1][0];
        }
      

        for (int i=1; i< M; i++){
            for (int j=1; j<N; j++){
                if (t[i]==s[j]) matriz[i][j]=matriz[i-1][j-1]+matriz[i-1][j];
                else matriz [i][j]=matriz[i-1][j];
            }
        }
       return matriz [M-1][N-1];
    }

    public static void main(String[] args)
    {
        int[] t = StdIn.readAllInts();

        int M = Integer.parseInt(args[0]);
        int[] s = new int[M];
        for (int i = 0; i < M; i++)
            s[i] = t[i];

        Stopwatch sw = new Stopwatch();
        StdOut.println(noOccurrencesFast(s, t) 
                       + " [" + sw.elapsedTime()+ " seconds]");
        sw = new Stopwatch();
        StdOut.println(SubsequenceMod2.noOccurrences(s, t)  
                       + " [" + sw.elapsedTime()+ " seconds]");
    }
}
