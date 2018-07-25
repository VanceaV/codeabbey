package problems_91_120;

import java.util.Scanner;
public class NecklaceCount_111{
    
    Scanner sc;
    int B,N;
    NecklaceCount_111(){
        sc = new Scanner(System.in);
    }
    void count(){
        int number;
        int iter = sc.nextInt();
        for(int i=0;i<iter;i++){
            number=0;
            B=sc.nextInt();
            N=sc.nextInt();
            for(int j=1;j<=N;j++){
                int g = GCD(j,N);
                number+=(int)Math.pow(B, g);
            }
            System.out.print(number/N+" ");
        }
    }
    int GCD( int t,int k){
        while(k!=t){
            if(t>k)
            t=t-k;
            else k=k-t; 
        }
        return t;
    }
    public static void main (final String[] args) {
        NecklaceCount_111 NC = new NecklaceCount_111();
        NC.count(); 
    }   
}
