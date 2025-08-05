public class Divide {

    static int A= 0;
    static int B=0;
    static int C=0;
    static boolean parada = false;
    static int argumentos = 0;

    public static void printavetor (int[] array){
        for (int i=0; i<array.length;i++){
            if (array[i]!=0){
                StdOut.print(array[i]+" ");
            }
        }
        return;
    }
    
    public static void perm(int []pecas, int[]a, int[]b, int []c, int div, int k,int soma,int mod){
        int max= Math.max(A, Math.max(B,C));
        if (parada==true) return;
        if (max>div+1) return;
        if (mod==0 && max>(div-1)) return;
        if (mod==1 && ((max>div)||(A>(div-1) && B>(div-1))|| (B>(div-1) && C>(div-1))||(A>(div-1) && C>(div-1)))) return;
        if (k>=a.length){
            parada =true;
            StdOut.println("There is a solution");
            if (argumentos >= 1){
                int sum=A+B+C;
                int opt =div-1;
                StdOut.println("Optimal value: " + opt + " (sum: " +  sum + " / want: " +opt+ " / sum mod 3 = "+ sum%3+")");
                StdOut.print("0: "); printavetor (a); StdOut.println ("(sum: "+A+")");
                StdOut.print("1: "); printavetor (b); StdOut.println ("(sum: "+B+")");
                StdOut.print("2: "); printavetor (c); StdOut.println ("(sum: "+C+")");
            }
            return;}
        a[k]=pecas[k];
        A= A+pecas[k];
        perm (pecas, a, b, c, div, k+1,soma,mod);
        A=A-pecas[k];
        a[k]= 0;
    
        b[k]= pecas[k];
        B= B+pecas[k];
        perm (pecas, a, b,c,div, k+1,soma,mod);
        B=B-pecas[k];
        b[k]= 0;
    
        c[k]= pecas [k];
        C= C+pecas[k];
        perm (pecas, a, b, c, div, k+1,soma,mod);
        C=C-pecas[k];
        c[k]=0;
    }
    
    public static void divide(int[] pecas)
    {
        int soma=0;
        for (int i=0; i<pecas.length;i++) soma= soma+pecas[i];
        int div=(soma/3);
        int mod = soma %3;
        int[] a = new int [pecas.length];
        int [] b= new int[pecas.length];
        int [] c = new int [pecas.length];
        b[0]= pecas [0];
        B=pecas[0];
        perm(pecas,a,b,c,div+1, 1,soma,mod);
        if (parada == false){
            StdOut.println("There is no solution");
            if (argumentos >= 1){
                StdOut.print("0: "); printavetor (pecas); StdOut.println ( "(sum: "+soma+")");
                StdOut.println("1: (sum=0)");
                StdOut.println("2: (sum=0)");
                StdOut.println("Best I found (not necessarily optimal): 0 (sum: " + soma+ " / want: " +div +" / mod 3 = "+soma%3+")");
            }}
    }
    
    
    public static void main(String[] args)
    {
        int[] pecas =StdIn.readAllInts();
        argumentos =args.length;
        divide (pecas);
    }
    }
    