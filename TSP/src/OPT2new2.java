import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;


public class OPT2new2 {
	static int [] T = new int [10];
    public static void main(String[] args) { 
    	test();
    }
    public static int[] flippin(int n2,int n3){
    	
        Global.tourIndexer = new HashMap<Integer, Integer>();
        for (int i = 0; i < T.length; i++) {
        	Global.tourIndexer.put(T[i], i);			
		}
    	//Måste ändra i tourindexer också
    	System.out.println(T[1]);
		int [] tmp = new int[T.length];
		int n2Index = Global.tourIndexer.get(n2);
		int n3Index = Global.tourIndexer.get(n3);
		System.out.println(n2Index);
		for (int o = 0; o < tmp.length; o++) {
			if(T[o]==n2){
				for (int i = 0; i < (n3Index-n2Index+1); i++) {
					System.out.println(Global.tourIndexer.get(n2)+" n2");
					System.out.println(Global.tourIndexer.get(n3)+" n3");
					tmp[n2Index+i]=T[n3Index-i];
					o++;
				
				}
				o--;
			}else{
				System.out.println(T[o]+" here?");
				tmp[o]=T[o];				
			}
			
		}
		
//		for (int i = 0; i < T.length; i++) {
//			if (T[i]==n2){
//				System.out.println("pang");
//				int j = 0;
//				while(T[i+j]!=n3){
//					System.out.println(T[i+j]);
//					tmp[i+j]=T[i-j];
//					j++;
//
//				}
//			}
//		}
		
		return tmp;
	}
	public static void test(){
		int[] test = new int[10];
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < test.length; i++) {
			test[i]=i;
			list.add(i);
		}
		T = new int []{0,8,5,4,3,9,6,2,1,7};
		int [] T2 = {0,8,5,4,3,9,6,2,1,7};
		int n2 = 8;
		int n3 = 4;
		T=flippin(n2,n3);
		
//		Collections.r;
		
				
		for (int i = 0; i < test.length; i++) {
			System.out.println(T[i]+ " "+T2[i]);
//			System.out.println(list.get(i));
		}
	}
}
