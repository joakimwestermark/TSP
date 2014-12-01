import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;


public class Greedy{
	
	public static int[] findTour(){
//		int [] tour = new int[Global.length];
//		boolean [] used = new boolean [Global.length];
//		Global.fromItoT = new int[Global.allNodes.length];
//		Arrays.fill(used, false);
//		tour[0] = 0;
//		used [0] = true;
//        Global.theTour[0] = 0;
//		for (int i = 1; i < Global.length; i++) {
//			int best = -1; 
//			for (int j = 0; j< Global.length; j++) {
//				if(!used[j] && (best==-1 || Global.distanceMatrix[tour[i-1]][j] < Global.distanceMatrix[tour[i-1]][best])){
//					best = j; 
//				}
//			}
//			Global.tourIndexer.put(best, i);
//            Global.theTour[i] = best;
//			Global.fromItoT[best] = i;
//			tour[i] = best;
//			Global.allNodes[i].changeNameID(best);
//			Global.allNodes[(i+1)%Global.length].setPrev(best);
//			Global.allNodes[i-1].setNext(best);
//			
//			used [best] = true; 
//		}
		
		
		Global.newTour = new int[Global.length];
		boolean [] used = new boolean [Global.length];
		Arrays.fill(used, false);
		int n1 = 0;
		int original = 0;
		Global.theTour[0]=0;
		for (int i = 0; i < Global.length-1; i++) {
			int best = -1;
			for (int j = 0; j< Global.length; j++) {
				if(n1!=j){
					if(!used[j] && (best==-1 || Global.distanceMatrix[n1][j] < Global.distanceMatrix[n1][best])){
						best = j;
					}
				}
			}
			used[n1]=true;
//			Global.tourIndexer.put(best, i);
			Global.newTour[n1] = best;
			Global.theTour[i+1] = best;

			n1 = best;
		}
		Global.newTour[n1]=original;
		
//		System.out.println(Arrays.toString(Global.newTour));
//		System.out.println(Arrays.toString(Global.theTour));
//		OPT2new.flipInTheFlip(1, 3);
//		OPT2new.flipper(0, 8, 4, 3);
		OPT2new.replaceEdge2();
//		System.out.println(Arrays.toString(Global.newTour));
//		System.out.println(Arrays.toString(Global.theTour));

/*
        //****is right*****
        for (int i = 0; i < Global.theTour.length; i++) {
            System.out.print(Global.theTour[i]+" ,");
        }

        Global.allNodes[Global.length-1].setNext(Global.allNodes[0].getNameID()); //IS THIS OKEY?!?
		//totalDistance();
		String [] s = new String[1];
		s[0] = "First";
        //GUI.main(s);
        
       // Scanner user_input = new Scanner( System.in );
        //String first_name = user_input.next();


		for (int i = 0; i < 1; i++) {
			OPT2new.replaceEdge2();
		}
		
		//totalDistance();
		String [] s2 = new String[1];
		s2[0] = "Second";
        //GUI.main(s2);

		for (int i = 0; i < Global.length; i++) {
			tour[i]=Global.allNodes[i].getNameID();
		}
*/		
		//totalDistance();
		return Global.theTour;
	}
	
	public static void dist(){
		Global.cN = new ArrayList<ArrayList<Integer>>();
		Global.indexKiller = new ArrayList<HashMap<Integer, Integer>>();
		Global.indexKiller2 = new HashMap<Integer,HashMap<Integer, Integer>>();

		for (int i = 0; i < Global.allNodes.length; i++) {
			Node n1 = Global.allNodes[i];
			//for (int j=1+i; j < a.size(); j++) { //calculate matrix/2
			ArrayList<Integer> bestValue = new ArrayList<Integer>();
			bestValue.add(Integer.MAX_VALUE);
			bestValue.add(Integer.MAX_VALUE-1);
			bestValue.add(Integer.MAX_VALUE-2);
			bestValue.add(Integer.MAX_VALUE-3);
			bestValue.add(Integer.MAX_VALUE-4);
			bestValue.add(Integer.MAX_VALUE-5);
			bestValue.add(Integer.MAX_VALUE-6);
			HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
			for (int j = 0; j <Global.allNodes.length; j++) {
				Node n2 = Global.allNodes[j];
				double x = n1.getX() - n2.getX();
				double y = n1.getY() - n2.getY();
				double d = Math.sqrt(Math.pow(x,2)+Math.pow(y, 2));
				d = Math.round(d);
				int newD = (int) d;
				if(newD!=0){
					bestValue.add(newD);
					Collections.sort(bestValue);
					bestValue.remove(bestValue.size()-1);
					hash.put(newD, j);
				}
				Global.distanceMatrix[i][j] = newD;	
			}
			Global.indexKiller.add(hash);
			Global.indexKiller2.put(i, hash);
			Global.cN.add(bestValue);
		}

		
	}

    //******is right*****
	public static void totalDistance(){
		int sum = 0;
		int current = 0;
		int next = 0;
		for (int i = 0; i < Global.length; i++) {
            current = Global.theTour[i];
            next = Global.theTour[(i+1)%Global.length];
            sum +=Global.distanceMatrix[current][next];
			//current = Global.allNodes[next].getNameID();
			//next = Global.allNodes[current].getNext();
			//sum+=Global.distanceMatrix[current][next];
			//System.out.println("summa: "+sum+"  current: "+current+"  next: "+next);
			
			
		}
		//System.out.println(Global.distanceMatrix[0][7]+" matrix from 0 to 7");
		//System.out.println(sum + " sum");
		
			
	}


	
//	public static int totalDistance(){
//		int sum = 0;
//		for (int i = 0; i < Global.allNodes.length; i++) {
//			sum+=Global.distanceMatrix[Global.allNodes[i].getNameID()][Global.allNodes[(i+1)%Global.length].getNameID()];	
////			System.out.println(Global.distanceMatrix[allNodes.get(i).getT()][allNodes.get((i+1)%allNodes.size()).getT()]);
//		}
//		System.out.println(sum+" total distance");
//		return sum;
//	}
	

}
