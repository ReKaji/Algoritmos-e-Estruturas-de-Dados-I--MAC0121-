
/******************************************************************************
 *
 * MAC0121 ALGORITMOS E ESTRUTURAS DE DADOS I
 * Aluno: Renan Ryu Kajihara
 * Numero USP: 14605762
 * Tarefa: E05
 * Data: 03/12/2023
 * 
 * DECLARO QUE SOU O ÚNICO AUTOR E RESPONSÁVEL POR ESTE PROGRAMA.  TODAS AS 
 * PARTES DO PROGRAMA, EXCETO AS QUE SÃO BASEADAS EM MATERIAL FORNECIDO  
 * PELO PROFESSOR OU COPIADAS DO LIVRO OU DAS BIBLIOTECAS DE SEDGEWICK & WAYNE, 
 * FORAM DESENVOLVIDAS POR MIM.  DECLARO TAMBÉM QUE SOU RESPONSÁVEL POR TODAS 
 * AS CÓPIAS DESTE PROGRAMA E QUE NÃO DISTRIBUÍ NEM FACILITEI A DISTRIBUIÇÃO
 * DE CÓPIAS DESTA PROGRAMA.
 *
 ******************************************************************************/

public class TokenFinder{
    private String linha;
    private int indice = 0;
    private enum Aspas {IN,OUT};
    public TokenFinder(String s) {
        this.linha = s;
    }

    public String nextToken() {
        StringBuilder saida = new StringBuilder();
        String word = null;
        Aspas aspas = Aspas.OUT;
        while (indice < linha.length()){
            char c = linha.charAt(indice);
        
            if (c=='"'){
                if (aspas == Aspas.OUT) aspas = Aspas.IN;
                else aspas=Aspas.OUT;
                if (linha.charAt(indice+1)=='"'){
                    saida.append(c);
                    indice++;}
                else indice+=1;                
            }
            else{
                if (c==',' && aspas==Aspas.OUT) {
                    if (linha.charAt(indice-1)==','){
                        indice++;
                        return " ";
                    }
                    else{
                    indice+=1;
                    break;}
                }
                else{
                    saida.append(c);
                    indice+=1;
                    }
            }}
            
        if (indice > linha.length()) indice = 0;
        if (saida.toString().isEmpty()) {
            return null;}
        else {word=saida.toString();
        return word;}
    }
}