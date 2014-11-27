import java.util.ArrayList;
import java.util.Arrays;


public class Greedy extends OPT2{
	
	Greedy(){
		
	}
	
	public static int[] findTour(ArrayList<Node> allNodes){
		int [] tour = new int[Global.length];
		boolean [] used = new boolean [Global.length];
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
			tour[i] = best;
			allNodes.get(i).changeT(best);
//			System.out.println(allNodes.get(i).getT()+" T");
//			allNodes.get(best).changeT(i);
			//System.out.println(allNodes.get(i).getI()+ "turn: "+allNodes.get(i).getT());
			
//			System.out.println(allNodes.get(0).getT());
//			System.out.println(allNodes.get(1).getT());
			
//			System.out.println(best+" best");
			used [best] = true; 
			
		}
		int finalDist=0;
//		ArrayList<Node> tmpAllNodes = new ArrayList<Node>();
		
		for (int o = 0; o < 9; o++) {
			int before = totalDistance(allNodes);
//			System.out.println(before +" before");
//			tmpAllNodes = replaceEdge2(allNodes);
			allNodes = replaceEdge2(allNodes);
			int after = totalDistance(allNodes);
//			System.out.println(after + " after");
			if (before>after){
//				for (int i = 0; i < allNodes.size(); i++) {
//					allNodes.set(i, tmpAllNodes.get(i));
//				}
//				System.out.println("hej");
				finalDist = totalDistance(allNodes);
				for (int i = 0; i < allNodes.size(); i++) {
					tour[i]=allNodes.get(i).getT();
				}		
			}
//			for (int j = 0; j < tour.length; j++) {
//				System.out.println(tour[j]);
//			}
//			System.out.println(after);
//			System.out.println(o);
//			System.out.println("");
		}
		
//		int finalDist = totalDistance(allNodes);
//		System.out.println(finalDist);
		return tour;
	}
	
	public static void dist(ArrayList<Node> a){
		for (int i = 0; i < a.size(); i++) {
			Node n1 = a.get(i);
			//for (int j=1+i; j < a.size(); j++) { //calculate matrix/2
			for (int j = 0; j < a.size(); j++) {
				Node n2 = a.get(j);
				double x = n1.getX() - n2.getX();
				double y = n1.getY() - n2.getY();
				double d = Math.sqrt(Math.pow(x,2)+Math.pow(y, 2));
				d = Math.round(d);
				int newD = (int) d;
				Global.distanceMatrix[i][j] = newD;	
			}
		}
		//Print matrix
//		for (int i = 0; i < Global.distanceMatrix.length; i++) {
//			for (int j = 0; j < Global.distanceMatrix[0].length; j++) {
//				System.out.print(Global.distanceMatrix[i][j]+" ,");
//			}
//			System.out.println("");
//		}
		
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
		for (int i = 0; i < allNodes.size()-1; i++) {
			sum+=Global.distanceMatrix[allNodes.get(i).getT()][allNodes.get(i+1).getT()];			
		}
		//System.out.println(sum+" total distance");
		return sum;
	}
	

}
