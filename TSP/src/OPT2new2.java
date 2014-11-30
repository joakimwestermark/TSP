import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class OPT2new2 {
    public static void main(String[] args) { 
    	test();
    }
	public static void test(){
		int[] test = new int[10];
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < test.length; i++) {
			test[i]=i;
			list.add(i);
		}
		
		
//		Collections.r;
		
				
		for (int i = 0; i < test.length; i++) {
			System.out.println(test[i]);
			System.out.println(list.get(i));
		}
	}
}
