public class E02 
{

    public static long n_ebfR (int N)
    {
        if (N == 0) return 1;
        long a=0;
        if (N%2==0)
        {

            for (int i=1;i<=N/2;i++)
            {
                a+=2*n_ebfR(N-i)*n_ebfR(i-1);
            }
            return a;
        }
        for (int i=1; i<=N/2;i++)
        {
            a+=2*n_ebfR(N-i)*n_ebfR(i-1);
        }
        double b = n_ebfR(N/2);
        b= Math.pow(b,2);
        a+=b;
        return a;
    }

    static long[] exp= new long[36];
    
    public static long n_ebfM (int N)
    {
        if (N==0) return 1;
        if (N%2==0)
        {
            if (exp[N]==0) 
            {
                for (int i=1;i<=N/2;i++)
                {
                    exp[N] +=2*n_ebfM(N-i)*n_ebfM(i-1);
                }
            }
            return exp[N];
        }
        
        if (exp[N]==0) 
        {
            for (int i=1;i<=N/2;i++)
            {
                exp[N] +=2*n_ebfM(N-i)*n_ebfM(i-1);
            }
            double b = n_ebfM(N/2);
            b= Math.pow(b,2);
            exp[N]+=b;
        }
        return exp[N];
        
    } 
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        StdOut.println(n_ebfR(n));
        StdOut.println(n_ebfM(n)); 
    }
}

