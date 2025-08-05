public class Hanoi4
{
    static int mov=0; //conta o número de movimentos necessários
    static int[] pas=new int [100000000];//guarda os passos necessários
    static int ind = 0;//guarda o índice dos passos necessários

    //lista que controla quantos discos a mais o hanoi4 terá a mais que o hanoi3 na função recursiva (hanoi4)
    public static long[] lista (){ 
	long list[]=new long [10000];

    for (int i=0;i<10000;i++){
        if (i==0) list[i]=9;
        else if (i!=0){
            list[i]=list[i-1]+(3);
        }
    }
    return list;
    }

    //função que resolve recursivamente o hanoi de 3 torres. Nessa função: n=número de discos; from= local de começo; to= local de destino; temp = variavel temporaria;
    //z= se tiver fazendo um hanoi de 3 discos com os discos de tamanho 5,6,7, na funçao principal, por exemplo, z=4, pois 1+4=5, 2+4=6 e 3+4=7
    public static void hanoi3(int n, int from, int to, int temp, int z) {
        
		if (n == 0) return;
		hanoi3(n-1, from, temp, to, z);
		int h= n+z;
        pas[ind]=h;
        ind+=1;
        pas[ind]=to;
        ind+=1;
        mov+=1;
		
		hanoi3(n-1,  temp, to,from,z);
	}
    //funçao que resolve recursivamente o hanoi de 4 torres. Nessa funçao: a=número de discos, b=número do maior disco; t=local de destino; fr=local de começo;
    //tempo4=variavel temporaria necessaria pelo hanoi4 ; tempo3=variavel temporaria necessaria para o hanoi3

    //Para resolver o hanoi com 4 discos, essa função realiza os seguintes passos recursivamente:
    //1) faz o hanoi4 com um numero x de discos para a torre 3;
    //2) faz o hanoi 3 com a-x-1 discos para a torre 2;
    //3) poe o maior disco na torre 1;
    //4) faz o hanoi 3 com os a-x-1 discos para a torre 1;
    //5) faz o hanoi 4 com os x discos para a torre 1;
	public static void hanoi4 (int a, int b, int t, int fr, int tempo4, int tempo3) 
	{
		if (a==0) return;
		if (a==1)
		{
            pas[ind]=b;//disco
            ind+=1;
            pas[ind]=t;//local de chegada do disco
            ind+=1;
            mov+=1;;
			return;
		}
		if (a==2)
		{
			int d=b-1;
            pas[ind]=d;//disco
            ind+=1;
            pas[ind]=2;//local de chegada do disco
            ind+=1;
            pas[ind]=b;//disco
            ind+=1;
            pas[ind]=t;//local de chegada do disco
            ind+=1;
            pas[ind]=d;//disco
            ind+=1;
            pas[ind]=t;//local de chegada do disco
            ind+=1;
            mov+=1;
            mov+=1;
            mov+=1;
			return;
		}
		if (a%2==1)
		{
            if (a>8){
                long lista[]=new long [10000];
                lista=lista();
                int var=0;
                for (int i = 0;a>=lista[i] && i<10000 ; i++)  var=i;             
			    int e=(a-1)/2;
                int qua= e+1+var;//qua= numero de discos que irao realizar o hanoi4
                int tre= e-1-var; //tre=numero de discos que irao realizar o hanoi3
			    hanoi4(qua,qua,tempo4,fr,t, tempo3);
			    hanoi3(tre,fr, tempo3, t,qua);
                pas[ind]=b;//maior disco
                ind+=1;
                pas[ind]=t;//torre 1 (local de chegada do maior disco)
                ind+=1;
                mov+=1;
			    hanoi3(tre,tempo3, t, fr, qua);
			    hanoi4(qua,qua,t,tempo4, fr, tempo3);
			return;}
            
            else{
                int e=(a-1)/2;
			    hanoi4(e,e,tempo4,fr,t, tempo3);
			    hanoi3(e,fr, tempo3, t,e);
			    pas[ind]=b;//maior disco
                ind+=1;
                pas[ind]=t;//torre de chegada do maior disco (torre 1)
                ind+=1;
                mov+=1;
			    hanoi3(e,tempo3, t, fr, e);
			    hanoi4(e,e,t,tempo4, fr, tempo3);
			return;
            }
		}
		if (a%2==0)
		{
            if(a>9){
            long lista[]=new long [10000];
            lista=lista();
            int var=0;
            for (int i = 0;a>=lista[i] && i<10000; i++)  var=i;
            int e=((a-1)/2);
            int qua= e+2+var; //qua= numero de discos que irao realizar o hanoi4
            int tre= e-1-var; //tre=numero de discos que irao realizar o hanoi3
			hanoi4(qua,qua,tempo4,fr,t, tempo3);
			hanoi3(tre,fr, tempo3, t,qua);
            pas[ind]=b;//maior disco
            ind+=1;
            pas[ind]=t;//torre de chegada do maior disco (torre1)
            ind+=1;
            mov+=1;
			hanoi3(tre,tempo3, t, fr, qua);
			hanoi4(qua,qua,t,tempo4, fr, tempo3);
			return;


            }
			int f= (((a-1)/2)+1);
			int g= ((a-1)/2);
			hanoi4(f,f,tempo4,fr,t, tempo3);
			hanoi3(g,fr, tempo3,t,f);
			pas[ind]=b;//maior disco
            ind+=1;
            pas[ind]=t;//torre de chegada do maior disco
            ind+=1;
            mov+=1;
			hanoi3(g,tempo3,t,fr, f);
			hanoi4(f,f,t, tempo4,fr,tempo3);	
		}
	}
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]); 
        hanoi4(N,N,1,0,3, 2);
        //imprime o numero de movimentos se um segundo argumento for passado
        if (args.length ==2){ 
            StdOut.print(mov+ " moves");
            StdOut.println();}
        //imprime os movimentos
        for(int i=0; pas[i]!=0;i+=2){
            StdOut.print(pas[i]+" "+pas[i+1]+"  ");}
        StdOut.println();
        
}
}
