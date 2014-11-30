import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class OPT2new2 {
    public static void main(String[] args) { 
    	test();
    }
    public static void reverse(int array[], int start, int end)
    {
        int length = end - start;
        if(length < 0)
            length += array.length;
        length = length / 2 + 1;
        for(int l = 0; l < length; l++)
        {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            if(++start >= array.length)
                start = 0;
            if(--end < 0)
                end = array.length-1;
        }

    }
	public static void test(){
		int[] test = new int[10];
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < test.length; i++) {
			test[i]=i;
			list.add(i);
		}
		int [] test2 = {0,8,5,4,3,9,6,2,1,7};
//		reverse(test2,,);
		
//		Collections.reverse(list);
//		Collections.reverse(Arrays.asList(test));
		
		
		
				
//		for (int i = 0; i < test.length; i++) {
//			System.out.println(list.get(i));
//		}

		for (int i = 0; i < test.length; i++) {
			System.out.println(test2[i]);
		}
		
		
		
	}
}
