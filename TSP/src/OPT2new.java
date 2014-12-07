import java.util.ArrayList;
import java.util.Arrays;


public class OPT2new {

	public static int getNext(int n){
		int next = Global.newTour[n];
		return next;
	}
	public static int getNext2(int n){
		int next = Global.bestTour[n];
		return next;
	}
	
	public static void flipper(int n1, int n2, int n3, int n4){
		int tmp [] = new int [Global.length];
		System.arraycopy(Global.newTour, 0, tmp, 0, Global.length);
		Global.newTour[n3]=n1;
		Global.newTour[n4]=n2;
		int pos = 0;
		int value = n4;
		for (int i = 0; i < Global.length; i++) {	 //kan råka reversa åt fel håll, dvs 99% istället för 1%
			
//			if(measureTime()>(1700)){
//				break;
//			}
			
			pos = tmp[value];
			Global.newTour[pos] = value;
			value = pos;
			if(pos==n1){
				break;
			}
		}	
	}
	public static void flipper2(int n1, int n2, int n3, int n4){
		int tmp [] = new int [Global.length];
		System.arraycopy(Global.bestTour, 0, tmp, 0, Global.length);
		Global.bestTour[n3]=n1;
		Global.bestTour[n4]=n2;
		int pos = 0;
		int value = n4;
		for (int i = 0; i < Global.length; i++) {	 //kan råka reversa åt fel håll, dvs 99% istället för 1%
			
//			if(measureTime()>(1700)){
//				break;
//			}
			
			pos = tmp[value];
			Global.bestTour[pos] = value;
			value = pos;
			if(pos==n1){
				break;
			}
		}	
	}
	
	public static void replaceEdge2(){
//		Global.tabu = new ArrayList<int[]>();
		boolean noChange = true;
		Global.bestTour = new int [Global.length];
		Global.bestSum = Integer.MAX_VALUE;
//		System.out.println(measureTime()+ " the time");
//		while((measureTime()<(800))){
//			System.out.println(measureTime()+ " the time inside while");
//			int counter = 0;
//			System.out.println(System.currentTimeMillis()-Global.TIME);
			while(noChange && measureTime()<(700)){
//				counter++;
//				if(counter%10000==0){
//					System.out.println(counter + " counter");
//				}
				noChange = false;
//				int random = (int )(Math.random() * Global.length + 1);
				
				for (int i = 0; i < Global.length; i++) {
					
//					if(measureTime()>(1700)){
//						break;
//					}
//					
					int n1 = Global.newTour[i];
					int n2 = getNext(n1);
//				int random2 = (int )(Math.random() * Global.length + 1);
					
//				for (int j = 0; j < Global.cN.get(0).size(); j++) {
//					int n3 = Global.indexKiller.get(n1).get(Global.cN.get(n1).get(j));
//					for (int j = 0; j < Global.length; j++) {
					
					for (int j = 0; j < Global.numberCN-1; j++) {
//						int n3 = Global.newTour[j];
						int n3 = Global.closestN.get(n1)[j];
						int n4 = getNext(n3);
//						int [] b = {n1,n2,n3,n4};
//						boolean check = false;
////						System.out.println("outside"+Global.tabu.size());
//						for (int k = 0; k < Global.tabu.size(); k++) {
//							if(Arrays.equals(Global.tabu.get(k), b)){
////								System.out.println("huhuhuhuuh");
//
//								check = true;
//							}							
//						}
						if(compute(n1,n2,n3,n4)){
							if(n1!=n3 && n1!=n4 && n2!=n3 && n2!=n4){ //byt plats på denna ifsatsen och compute
								flipper(n1,n2,n3,n4);
								noChange=true;
							}
						
						}
						if(noChange){
							break;
						}
					}
				}
				if(!noChange){
					shuffle();
//					counter++;
//					System.out.println(counter + " counter");
					noChange=true;
				}
			}
	}
			
	public static void replaceEdge2pure(){
		boolean noChange = true;
			while(noChange && measureTime()<(1000)){
				noChange = false;						
				for (int i = 0; i < Global.length; i++) {
					int n1 = Global.bestTour[i];
					int n2 = getNext2(n1);
					for (int j = 0; j < Global.length; j++) {
						int n3 = Global.bestTour[j];
						int n4 = getNext2(n3);
						if(compute(n1,n2,n3,n4)){
							if(n1!=n3 && n1!=n4 && n2!=n3 && n2!=n4){ //byt plats på denna ifsatsen och compute
								flipper2(n1,n2,n3,n4);
								noChange=true;
							}
						
						}
						if(noChange){
							break;
						}
					}
				}
			}
	}
	
//			int newSum = calculate(Global.newTour);
////			System.out.println("newSum: "+newSum+"    bestSum: "+bestSum);
//			if(newSum<bestSum){
////				System.out.println("newSum: "+newSum+"    bestSum: "+bestSum+"   inside if");
//				System.arraycopy(Global.newTour, 0, Global.bestTour, 0, Global.length);
//				bestSum = newSum;
//			}
//			
//			
//			for (int i = 0; i < Global.length/10; i++) {
////				if(measureTime()>(1700)){
////					break;
////				}
//				int n1 = (int)(Math.random()*Global.length);
//				int n2 = getNext(n1);
//				int n3 = (int)(Math.random()*Global.length);
//				int n4 = getNext(n3);
//				if(n1!=n3 && n1!=n4 && n2!=n3 && n2!=n4){ //byt plats på denna ifsatsen och compute
//					flipper(n1,n2,n3,n4);
//				}
//			}
//		}
//	}
	public static void shuffle(){
//		System.out.println("hahahahahaha");
		int newSum = calculate(Global.newTour);
//		System.out.println("newSum: "+newSum+"    bestSum: "+Global.bestSum);
		if(newSum<Global.bestSum){
	//		System.out.println("newSum: "+newSum+"    bestSum: "+bestSum+"   inside if");
			System.arraycopy(Global.newTour, 0, Global.bestTour, 0, Global.length);
			Global.bestSum = newSum;
		}
	
		
//		for (int i = 0; i < Global.length/Math.sqrt(Global.length); i++) {
		
		
		for (int i = 0; i < 3; i++) {
	//		if(measureTime()>(1700)){
	//			break;
	//		}
			int n1 = (int)(Math.random()*Global.length);
			int n2 = getNext(n1);
//			int n3 = (int)(Math.random()*Global.length);
			int n3 = Global.closestN.get(n1)[(int)(Math.random()*Global.closestN.get(n1).length)];
			int n4 = getNext(n3);
			if(n1!=n3 && n1!=n4 && n2!=n3 && n2!=n4){ //byt plats på denna ifsatsen och compute
				flipper(n1,n2,n3,n4);
//				System.out.println("we in here?");
//				int[] a = {n1,n2,n3,n4};
//				Global.tabu.add(a);
			}
		}
		Global.shuffleCheck = true;

	}
	public static int calculate(int[] t){
		int sum = 0; 
		int next = 0;
		for (int i = 0; i < t.length; i++) {
			
//			if(measureTime()>(1700)){
//				break;
//			}
			
			sum+=Global.distanceMatrix[next][getNext(next)];
			next = getNext(next);
			
		}
		return sum; 
	}



				

	public static boolean compute(int n1, int n2, int n3, int n4){
		double oldDistance = Global.distanceMatrix[n1][n2] + Global.distanceMatrix[n3][n4];
		double newDistance = Global.distanceMatrix[n1][n3] + Global.distanceMatrix[n2][n4];		
		if (newDistance < oldDistance) {
			return true;
		}
		return false;
	}
	public static long measureTime(){
		Long time = System.currentTimeMillis()-Global.TIME;
		return time;
	}
}