package problems_61_90;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class LexicographicPermutations {
    public static void main(String[] args) {
        char [] ABC={'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L'};
        int[] index=new int[12];
        //int[]result=new int[12];
        for(int s=0;s<12;s++)index[s]=s+1;
        ArrayList<Integer> list=new ArrayList<Integer>();
        ArrayList<Integer> list1=new ArrayList<Integer>();
        ArrayList<Integer> Ldata=new ArrayList<Integer>();
        ArrayList<Integer> Sdata=new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        int r =sc.nextInt();
        for(int i=0;i<r;i++){
            int next=sc.nextInt();
            Ldata.add(next);
            Sdata.add(next);
        }
        Collections.sort(Sdata);
        int max=Sdata.get(Sdata.size()-1);
        int storage[][]=new int [r][12];
        int count =0;
        int k=0;
            while(k!=max){
                if(k==0&&Sdata.get(0)==0){
                    for(int hh=0;hh<12;hh++){storage[count][hh]=hh+1;}
                    count++;
                }
                for(int j=0;j<index.length-1;j++){
                    if(index[j]<index[j+1]){
                        list.add(j);    
                    }
                }
                Collections.sort(list);
                int n=list.get(list.size()-1);
                for(int j=0;j<index.length;j++){
                    if(index[j]>index[n]){
                        list1.add(j);
                    }
                }
                Collections.sort(list1);
                int nn=list1.get(list1.size()-1);
                int temp;
                temp=index[n];index[n]=index[nn];index[nn]=temp;
                list.clear();
                list1.clear();
                int[]revers=new int [12-n-1];
                for(int j=0;j<12-n-1;j++){
                    revers[j]=index[11-j];    
                }
                for(int j=0;j<12-n-1;j++){
                    index[n+1+j]=revers[j];
                }
                k++;
                for(int h=0;h<Sdata.size();h++){
                    if(k==Sdata.get(h)){
                        for(int hh=0;hh<12;hh++){storage[count][hh]=index[hh];}
                        count++;
                    }
                }
            }
            ArrayList<Integer> F=new ArrayList<Integer>();
            int data1[]=new int[r];
            int data2[]=new int[r];
            for(int i=0;i<r;i++){
                data1[i]=Ldata.get(i);
                data2[i]=Sdata.get(i);
            }
            for (int f=0;f<r;f++){
                for(int j=0;j<r;j++){
                    if(data1[f]==data2[j]){
                        F.add(j);
                    }
                }
            }
            for(int i=0;i<r;i++){
                for(int j=0;j<12;j++){
                    System.out.print(ABC[storage[F.get(i)][j]-1]);
                }
                System.out.print(" ");
            }
        sc.close();
    }
}