import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;


public class Greedy{
	
//	Greedy(){
//		
//	}
	
	public static int[] findTour(ArrayList<Node> allNodes){
		int [] tour = new int[Global.length];
		boolean [] used = new boolean [Global.length];
		Global.fromItoT = new int[allNodes.size()];
		Arrays.fill(used, false);
		tour[0] = 0;
		used [0] = true; 
		for (int i = 1; i < Global.length; i++) {
			int best = -1; 
			for (int j = 0; j< Global.length; j++) {
				if(!used[j] && (best==-1 || Global.distanceMatrix[tour[i-1]][j] < Global.distanceMatrix[tour[i-1]][best])){
//					System.out.println("1: "+tour[i-1]+" "+j+"  2: "+tour[i-1]+" "+best);
				//if(!used[j] && (best==-1 || dist(tour[i-1],j, allNodes)<dist(tour[i-1],best, allNodes))){
					best = j; 
					//System.out.println(best+" best");
				}
			}
			Global.fromItoT[best] = i;
			tour[i] = best;
			allNodes.get(i).changeT(best);
			allNodes.get((i+1)%Global.length).setPrev(best);
			allNodes.get(i-1).setNext(best);
			
			
//			System.out.println(allNodes.get(i).getT()+" T");
//			allNodes.get(best).changeT(i);
			//System.out.println(allNodes.get(i).getI()+ "turn: "+allNodes.get(i).getT());
			
//			System.out.println(allNodes.get(0).getT());
//			System.out.println(allNodes.get(1).getT());
			
//			System.out.println(best+" best");
			used [best] = true; 
			
		}
		for (int i = 0; i < Global.length; i++) {
			System.out.println(allNodes.get(i).getT());
			System.out.println(allNodes.get(i).getPrev()+ " prev");
			System.out.println(allNodes.get(i).getNext()+ " next");
			System.out.println("");
		}
		allNodes.get(Global.length-1).setNext(allNodes.get(0).getT()); //IS THIS OKEY?!?
		Global.originalDist = totalDistance(allNodes);
		String [] s = new String[1];
		s[0] = "First";
        GUI.main(s);
        
        Scanner user_input = new Scanner( System.in );
        String first_name = user_input.next();


		for (int i = 0; i < 1; i++) {
			OPT2.replaceEdge2(allNodes);
		}
		
		Global.originalDist = totalDistance(allNodes);
		String [] s2 = new String[1];
		s2[0] = "Second";
        GUI.main(s2);

		for (int i = 0; i < allNodes.size(); i++) {
			tour[i]=allNodes.get(i).getT();
		}
		
		int dist = totalDistance(allNodes);
		System.out.println(dist+" the dist");
//		int finalDist=0;
//		ArrayList<Node> originalAllNodes = new ArrayList<Node>();
//		Node n = new Node(1,1, 0, 1);
////		for (int i = 0; i < allNodes.size(); i++) {
////			originalAllNodes.add(n);
////		}
//		int before = 0;
//		int originalDist = totalDistance(allNodes);
//		originalAllNodes.addAll(allNodes);
//		for (int i = 0; i < allNodes.size(); i++) {
//			System.out.println(originalAllNodes.get(i).getT()+" thfk!!!!!");
//		}
//		int test2 = totalDistance(originalAllNodes);
//		System.out.println(test2+ " the fking test2");
////		originalAllNodes = allNodes;
//		for (int o = 0; o < 3; o++) {
//			before = totalDistance(allNodes);
//			System.out.println(before +" before");
//			allNodes = replaceEdge2(allNodes);
////			allNodes = replaceEdge2(allNodes);
//			int after = totalDistance(allNodes);
//			System.out.println(after + " after");
//			if (after<before){
////				for (int i = 0; i < allNodes.size(); i++) {
////					allNodes.set(i, tmpAllNodes.get(i));
////				}
////				System.out.println("hej");
//				finalDist = totalDistance(allNodes);
//				for (int i = 0; i < allNodes.size(); i++) {
//					tour[i]=allNodes.get(i).getT();
//				}		
//			}else{
//				System.out.println("yes?");
//				allNodes.clear();
//				allNodes.addAll(originalAllNodes);
//				for (int i = 0; i < allNodes.size(); i++) {
//					System.out.println(allNodes.get(i).getT()+" thfk");
//				}
//				int test = totalDistance(allNodes);
//				System.out.println(test+" the test");
//			}
////			for (int j = 0; j < tour.length; j++) {
////				System.out.println(tour[j]);
////			}
////			System.out.println(after);
////			System.out.println(o);
////			System.out.println("");
//		}
//		
////		int finalDist = totalDistance(allNodes);
//		System.out.println(finalDist);
		return tour;
	}
	
	public static void dist(ArrayList<Node> a){
		Global.cN = new ArrayList<ArrayList<Integer>>();
		Global.indexKiller = new ArrayList<HashMap<Integer, Integer>>();
		for (int i = 0; i < a.size(); i++) {
			Node n1 = a.get(i);
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
			for (int j = 0; j < a.size(); j++) {
				Node n2 = a.get(j);
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
			Global.cN.add(bestValue);
		}
//		for (int i = 0; i < Global.cN.size(); i++) {
//			for (int j = 0; j < 3; j++) {
//				//select the closest neighbour
//				System.out.print(Global.indexKiller.get(i).get(Global.cN.get(i).get(j))+" ");
//			}
//			System.out.println(Global.cN.get(i));
//			System.out.println("");
//		}
//		Scanner user_in = new Scanner( System.in );
//        String first_na = user_in.next();
//		
//		//System.out.println();
//		//Print matrix
//		for (int i = 0; i < Global.distanceMatrix.length; i++) {
//			for (int j = 0; j < Global.distanceMatrix[0].length; j++) {
//				System.out.print(Global.distanceMatrix[i][j]+" ,");
//			}
//			System.out.println("");
//		}
//		
		/*Node first = a.get(p1);
		Node second = a.get(p2);
		double x = first.getX() - second.getX();
		double y = first.getY() - second.getY();
		double d = Math.sqrt(Math.pow(x,2)+Math.pow(y, 2));
		d = Math.round(d);
		int newD = (int) d;
		for (int i = 0; i < Global.length; i++) {
			
		}*/
		
	}
	
	public static int totalDistance(ArrayList<Node> allNodes){
		int sum = 0;
		for (int i = 0; i < allNodes.size(); i++) {
			sum+=Global.distanceMatrix[allNodes.get(i).getT()][allNodes.get((i+1)%allNodes.size()).getT()];	
//			System.out.println(Global.distanceMatrix[allNodes.get(i).getT()][allNodes.get((i+1)%allNodes.size()).getT()]);
		}
		//System.out.println(sum+" total distance");
		return sum;
	}
	

}
