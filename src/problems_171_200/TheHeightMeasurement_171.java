package problems_171_200;

import java.util.Scanner;

public class TheHeightMeasurement_171 {

    public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
        int r=sc.nextInt();
        for(int i=0;i<r;i++){
            double d=sc.nextDouble();
            double b=sc.nextDouble();
            Height(d,b);
        }
        sc.close();
    }
    static void Height(double d,double b){
        
        final  double PI = Math.PI;
        
        double rad=((b-90)*PI)/180.0;
        
        int HG=(int)Math.round(d*Math.tan(rad));
        
        System.out.print(HG+" ");
        
    }   
}