package problems_171_200;

import java.util.Scanner;

public class dsd {
	
	
	int cases;
	Scanner sc;
	int [] data;
	
	public dsd(){
		sc = new Scanner(System.in);
		cases = sc.nextInt();
		sc.nextLine();
	}
	
	
	void ReadData(){
		System.out.println();
		String st;
		String [] A;
		int Ir;
		for(int i=0;i<cases;i++){
			st=sc.nextLine();
			A = st.split(" ");
			data = new int[A.length];
			for(int j=0;j<A.length;j++)
				data[j]=Integer.parseInt(A[j]);
			int [] NewData=initArray(data);
			Ir = result(NewData,true);
			System.out.print(Ir+" ");
		}
	}
	int[] initArray(int [] start){
		
		int [] newArray;
		
		int sum =0,count =0;
		for(int i:start) sum+=i;
		newArray = new int[sum+start.length-1];
		for(int i=0;i<start.length;i++){
			for(int j=0;j<start[i];j++){
				newArray[count++] = 1;
			}
			if(i!=start.length-1)
			newArray[count++]=0;
		}
		return newArray;
	}
	
	int [] CopyArray(int [] CopyArray){
		
		int [] newArray = new int[CopyArray.length];
		for(int i=0;i<CopyArray.length;i++)
			newArray[i]=CopyArray[i];
		return newArray;
	}
	
	boolean CheckForZero(int [] zero){
		int sum=0;
		for(int i=0;i<zero.length;i++)
			sum+=zero[i];
		return sum == 0;
	}
	
	public static void main(String[] args) {
		dsd SGS = new dsd();
		SGS.ReadData();

	}
	
	int result(int [] array,boolean move){
		if(move){
			move=!move;  // first player to move
			int I_res;
			for(int i=0;i<array.length;i++){
				if(array[i]==1){
					int [] newArray = CopyArray(array);
					newArray[i]=0;
					if(CheckForZero(newArray)) return 0;
					I_res = result(newArray,move);
					if(I_res==1) return 1;
					if(i<array.length-1 && array[i+1]==1){
						newArray[i+1]=0;
						if(CheckForZero(newArray)) return 0;
						I_res = result(newArray,move);
						if(I_res==1) return 1;	
					}
				}
			}
			return 0;
					
		}else{	// second player to move
			move=!move;
			int I_res;
			for(int i=0;i<array.length;i++){
				if(array[i]==1){
					int [] newArray = CopyArray(array);
					newArray[i]=0;
					if(CheckForZero(newArray)) return 1;
					I_res = result(newArray,move);
					if(I_res==0) return 0;
					if(i<array.length-1 && array[i+1]==1){
						newArray[i+1]=0;
						if(CheckForZero(newArray)) return 1;
						I_res = result(newArray,move);
						if(I_res==0) return 0;	
					}	
				}
			}
			return 1;		
		}
	}
}