import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;


public class Greedy{
	
	public static int[] findTour(){
		int [] tour = new int[Global.length];
		boolean [] used = new boolean [Global.length];
		Global.fromItoT = new int[Global.allNodes.length];
		Arrays.fill(used, false);
		tour[0] = 0;
		used [0] = true; 
		for (int i = 1; i < Global.length; i++) {
			int best = -1; 
			for (int j = 0; j< Global.length; j++) {
				if(!used[j] && (best==-1 || Global.distanceMatrix[tour[i-1]][j] < Global.distanceMatrix[tour[i-1]][best])){
					best = j; 
				}
			}
			Global.fromItoT[best] = i;
			tour[i] = best;
			Global.allNodes[i].changeNameID(best);
			Global.allNodes[(i+1)%Global.length].setPrev(best);
			Global.allNodes[i-1].setNext(best);
			
			used [best] = true; 
			
		}
		Global.allNodes[Global.length-1].setNext(Global.allNodes[0].getNameID()); //IS THIS OKEY?!?
//		totalDistance();
//		String [] s = new String[1];
//		s[0] = "First";
//        GUI.main(s);
        
//        Scanner user_input = new Scanner( System.in );
//        String first_name = user_input.next();


		OPT2new.replaceEdge2();

		
//		totalDistance();
//		String [] s2 = new String[1];
//		s2[0] = "Second";
//        GUI.main(s2);

//		for (int i = 0; i < Global.length; i++) {
//			tour[i]=Global.allNodes[i].getNameID();
//		}
		
		totalDistance();
		int [] tourL = createTourList();
		return tourL;
	}
	
	public static void dist(){
		Global.cN = new ArrayList<ArrayList<Integer>>();
		Global.indexKiller = new ArrayList<HashMap<Integer, Integer>>();
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
			bestValue.add(Integer.MAX_VALUE-6);
			bestValue.add(Integer.MAX_VALUE-6);
			

			HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
//			int[] getValue = new int [Global.allNodes.length];
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
//					getValue [newD] = j; 
					if(bestValue.contains(newD)){
						hash.put(newD, j);						
					}
				}
				Global.distanceMatrix[i][j] = newD;	
			}
//			for (int j = 0; j < bestValue.size(); j++) {
//				hash.put(bestValue.get(j),getValue[bestValue.get(j)]);
//			}
			Global.indexKiller.add(hash);
			Global.cN.add(bestValue);
		}

		
	}
	
	public static void totalDistance(){
			int sum = 0;
			int current = 0;
			int next = 0;
			for (int i = 0; i < Global.length; i++) {
				current = Global.allNodes[Global.fromItoT[current]].getNameID();
				next = Global.allNodes[Global.fromItoT[current]].getNext();
				sum += Global.distanceMatrix[current][next];
				current = next;
			}
			//System.out.println("the sum is: "+sum);
	}
	
	public static int[] createTourList(){
		int[] tourList = new int[Global.length];
		int next = 0;
		for (int i = 0; i < Global.length; i++) {
			tourList[i]=next;
//			io.println(next);
			next = Global.allNodes[Global.fromItoT[next]].getNext();				

				
		}
		return tourList;
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
