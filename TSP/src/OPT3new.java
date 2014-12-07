import java.util.Arrays;
import java.util.Scanner;



public class OPT3new {

	public static int getNext(int n){
		int next = Global.newTour[n];
		return next;
	}
	public static void flipper3(int n1, int n2, int n3, int n4, int n5, int n6){
		int tmp [] = new int [Global.length];
		int empty [] = new int [Global.length];
		Arrays.fill(empty, -1);;
		System.arraycopy(Global.newTour, 0, tmp, 0, Global.length);
//		System.out.println("n1: "+n1+"    n2: "+n2+"    n3: "+n3+"    n4: "+n4+"    n5: "+n5+"    n6: "+n6);
//		System.arraycopy(empty, 0, Global.newTour, 0, Global.length);

		
//		double distOne = Global.distanceMatrix[n1][n4] + Global.distanceMatrix[n5][n2] + Global.distanceMatrix[n3][n6];		
//		double distTwo = Global.distanceMatrix[n1][n5] + Global.distanceMatrix[n4][n2] + Global.distanceMatrix[n3][n6];		
//		double distThree = Global.distanceMatrix[n1][n3] + Global.distanceMatrix[n2][n5] + Global.distanceMatrix[n4][n6];		
//		double distFour = Global.distanceMatrix[n1][n4] + Global.distanceMatrix[n5][n3] + Global.distanceMatrix[n2][n6];		
			
		
//		double distOne = Global.distanceMatrix[n1][n5] + Global.distanceMatrix[n4][n2] + Global.distanceMatrix[n3][n6];		
		
		flipper(n1,n2,n3,n4);
//		int tour = 0;
//		for (int i = 0; i < Global.length; i++) {
//			System.out.println(Global.newTour[tour]);
//			tour = Global.newTour[tour];
//		}
		if(getNext(n3)==n1 && getNext(n6)==n5){
			flipper(n3,n1,n6,n5);			
		}else if(getNext(n3)==n1 && getNext(n5)==n6){
			flipper(n3,n1,n5,n6);
		}else if(getNext(n1)==n3 && getNext(n6)==n5){
			flipper(n1,n3,n6,n5);
		}else if(getNext(n1)==n3 && getNext(n5)==n6){
			flipper(n1,n3,n5,n6);
		}
//		System.out.println("");
//		tour = 0;
//		for (int i = 0; i < Global.length; i++) {
//			System.out.println(Global.newTour[tour]);
//			tour = Global.newTour[tour];
//		}
//		while(true);
		
//		Scanner user_in = new Scanner( System.in );
//		String first_na = user_in.next();
//		int value1 = 0;
//		int value2 = 0;
//		int value3 = 0;
//		int check1 = 0;
//		int check2 = 0;
//		int check3 = 0;
//		if(Global.smallestIndex==1){
//			System.out.println("1 swap");
//			Global.newTour[n4]=n1;
//			Global.newTour[n5]=n2;
//			Global.newTour[n6]=n3;
//			
//			System.out.println("after 3 first swaps");
//			int tour = 0;
//			for (int i = 0; i < Global.length; i++) {
//				System.out.println(Global.newTour[i]);
////				tour = Global.newTour[tour];
//			}
//			
//			int pos = 0;
//			int value = n6;
//			for (int i = 0; i < Global.length; i++) {	 //kan råka reversa åt fel håll, dvs 99% istället för 1%
//				
//				pos = tmp[value];
//				Global.newTour[pos] = value;
//				value = pos;
//				if(pos==n1){
//					break;
//				}
//			}
//			System.out.println("after first reverse");
//			tour = 0;
//			for (int i = 0; i < Global.length; i++) {
//				System.out.println(Global.newTour[i]);
////				tour = Global.newTour[tour];
//			}
//			
//			pos = 0;
//			value = n4;
//			for (int i = 0; i < Global.length; i++) {	 //kan råka reversa åt fel håll, dvs 99% istället för 1%
//				
//				pos = tmp[value];
//				Global.newTour[pos] = value;
//				value = pos;
//				if(pos==n5){
//					break;
//				}
//			}
//			
//			System.out.println("after second reverse");
//			tour = 0;
//			for (int i = 0; i < Global.length; i++) {
//				System.out.println(Global.newTour[i]);
////				tour = Global.newTour[tour];
//			}
//			
//			pos = 0;
//			value = n2;
//			for (int i = 0; i < Global.length; i++) {	 //kan råka reversa åt fel håll, dvs 99% istället för 1%
//				
//				pos = tmp[value];
//				Global.newTour[pos] = value;
//				value = pos;
//				if(pos==n3){
//					break;
//				}
//			}
//			System.out.println("after third reverse");
//			tour = 0;
//			for (int i = 0; i < Global.length; i++) {
//				System.out.println(Global.newTour[i]);
////				tour = Global.newTour[tour];
//			}
//		}else if(Global.smallestIndex==2){
////			System.out.println("2");
//			Global.newTour[n6]=n1;
//			Global.newTour[n3]=n2;
//			Global.newTour[n5]=n4;
//		}else if(Global.smallestIndex==3){
////			System.out.println("3");
//			Global.newTour[n4]=n1;
//			Global.newTour[n6]=n2;
//			Global.newTour[n5]=n3;
//		}else if(Global.smallestIndex==4){
////			System.out.println("4");
//			Global.newTour[n3]=n1;
//			Global.newTour[n5]=n2;
//			Global.newTour[n6]=n4;
//		}
////		int pos = 0;
////		int value = value1;
////		for (int i = 0; i < Global.length; i++) {	 //kan råka reversa åt fel håll, dvs 99% istället för 1%
////			System.out.println(Arrays.toString(Global.newTour));
////			pos = tmp[value];
////			Global.newTour[pos] = value;
////			value = pos;
////			if(pos==check1){
////				break;
////			}
////		}
//		
//		int tour = 0;
//		for (int i = 0; i < Global.length; i++) {
//			System.out.println(Global.newTour[tour]);
//			tour = Global.newTour[tour];
//		}
//		while(true);

	}
	
	public static void flipper(int n1, int n2, int n3, int n4){
		int tmp [] = new int [Global.length];
		System.arraycopy(Global.newTour, 0, tmp, 0, Global.length);
		Global.newTour[n3]=n1;
		Global.newTour[n4]=n2;
		int pos = 0;
		int value = n4;
		for (int i = 0; i < Global.length; i++) {	 //kan råka reversa åt fel håll, dvs 99% istället för 1%

			pos = tmp[value];
			Global.newTour[pos] = value;
			value = pos;
			if(pos==n1){
				break;
			}
		}	
	}
	
	public static void replaceEdge2(){
		boolean noChange = true;
		boolean breaker = false;
			while(noChange){
				
				noChange = false;				
				for (int i = 0; i < Global.length; i++) {
					
					int n1 = Global.newTour[i];
					int n2 = getNext(n1);
					for (int j = 0; j < Global.length; j++) {
					
						int n3 = Global.newTour[j];
						int n4 = getNext(n3);
						
						for (int k = 0; k < Global.length; k++) {
							int n5 = Global.newTour[k];
							int n6 = getNext(n5);
							
								if(n1!=n3 && n1!=n5 && n1!=n4 && n1!=n6 && n2!=n3 && n2!=n4 && n2!=n5 && n2!= n6 && n3!=n5 && n3!=n6 && n4!=n5 && n4!=n6 && getNext(n4)!=n1 && getNext(n6)!=n1 && getNext(n4)!=n5 && getNext(n6)!=n3 && getNext(n2)!=n3 && getNext(n2)!=n5){ //byt plats på denna ifsatsen och compute
									if(compute(n1,n2,n3,n4,n5,n6)){
//										System.out.println("yeah");
									flipper3(n1,n2,n3,n4,n5,n6);
									noChange=true;
									breaker = true;
								}
								if(breaker){
									break;
								}
							}
							if(noChange){
								break;
							}
						}
						if(breaker){
							break;
						}
					}
				}
				if(breaker){
					break;
				}
			}
			
	}
	


				

	public static boolean compute(int n1, int n2, int n3, int n4, int n5, int n6){
		
		double oldDistance = Global.distanceMatrix[n1][n2] + Global.distanceMatrix[n3][n4] + Global.distanceMatrix[n5][n6];
		
//		double distOne = Global.distanceMatrix[n1][n3] + Global.distanceMatrix[n2][n6] + Global.distanceMatrix[n4][n5];		
//		double distTwo = Global.distanceMatrix[n1][n6] + Global.distanceMatrix[n2][n3] + Global.distanceMatrix[n4][n5];		
//		double distThree = Global.distanceMatrix[n1][n4] + Global.distanceMatrix[n2][n6] + Global.distanceMatrix[n3][n5];		
//		double distFour = Global.distanceMatrix[n1][n3] + Global.distanceMatrix[n2][n5] + Global.distanceMatrix[n4][n6];		
		
//		double distOne = Global.distanceMatrix[n1][n4] + Global.distanceMatrix[n5][n2] + Global.distanceMatrix[n3][n6];		
//		double distTwo = Global.distanceMatrix[n1][n5] + Global.distanceMatrix[n4][n2] + Global.distanceMatrix[n3][n6];		
//		double distThree = Global.distanceMatrix[n1][n3] + Global.distanceMatrix[n2][n5] + Global.distanceMatrix[n4][n6];		
//		double distFour = Global.distanceMatrix[n1][n4] + Global.distanceMatrix[n5][n3] + Global.distanceMatrix[n2][n6];		
////		
		double distOne = Global.distanceMatrix[n1][n5] + Global.distanceMatrix[n4][n2] + Global.distanceMatrix[n3][n6];		
		double distTwo = Global.distanceMatrix[n1][n5] + Global.distanceMatrix[n4][n2] + Global.distanceMatrix[n3][n6];		
		double distThree = Global.distanceMatrix[n1][n3] + Global.distanceMatrix[n2][n5] + Global.distanceMatrix[n4][n6];		
		double distFour = Global.distanceMatrix[n1][n4] + Global.distanceMatrix[n5][n3] + Global.distanceMatrix[n2][n6];		

		
		Global.distArr = new double []{oldDistance,distOne,distTwo,distThree,distFour};
		Global.distArr[2]+=2000;
		Global.distArr[3]+=2000;
		Global.distArr[4]+=2000;
		
		double smallest = Double.MAX_VALUE;
		Global.smallestIndex = -2;
		for (int i = 0; i < 5; i++) {
			if(Global.distArr[i]<smallest){
				smallest = Global.distArr[i];
				Global.smallestIndex= i;
			}
		}
		
//		System.out.println("oldDist: "+Global.distArr[0]+"     distTwo: "+Global.distArr[2]);
		if(Global.smallestIndex!=0){
			return true;
		}else{
			return false;
		}
	}
	
	public static long measureTime(){
		Long time = System.currentTimeMillis()-Global.TIME;
		return time;
	}
}