import java.util.ArrayList;
import java.util.Arrays;


public class Greedy{
	
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
//			allNodes.get(best).changeT(i);
			//System.out.println(allNodes.get(i).getI()+ "turn: "+allNodes.get(i).getT());
			
			
			
//			System.out.println(best+" best");
			used [best] = true; 
			
		}
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
	

}
