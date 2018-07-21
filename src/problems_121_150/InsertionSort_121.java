package problems_121_150;

import java.util.Scanner;

public class InsertionSort_121 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r=sc.nextInt();
        int v1[]=new int [r];
        int v2[]=new int [r];
        for(int i=0;i<r;i++){ 
            v1[i]=sc.nextInt(); 
        }
        System.out.println("\n\n");
        for(int i=0;i<r;i++){
            int t=0;
            if(i==0){v2[i]=v1[i];
            continue;}
            if(i==1){
                if(v1[i]>v2[0]) {v2[i]=v1[i];System.out.print("0"+" ");continue;}
                if(v1[i]<v2[0]) {t=v2[0];v2[0]=v1[i];v2[i]=t;System.out.print("1"+" ");
                continue;}
            }
            for(int j=0;j<i;j++){
                if(v1[i]>v2[i-1]){v2[i]=v1[i];System.out.print("0"+" ");break;}
                if(v1[i]<v2[0]) {
                    for(int s=i;s>=1;s--){v2[s]=v2[s-1];}
                    v2[0]=v1[i];
                    System.out.print((i)+" ");
                    break;
                }
                if(v1[i]>v2[j]&&v1[i]<=v2[j+1]){
                    for(int e=i;e>j;e--){v2[e]=v2[e-1];}
                    v2[j+1]=v1[i];
                    System.out.print((i-j-1)+" ");
                }
            }
        }
        sc.close();
    }
}