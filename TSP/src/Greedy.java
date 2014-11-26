import java.util.ArrayList;
import java.util.Arrays;




public class Greedy{
	
	Greedy(){
		
	}
	
	public static int[] findTour(ArrayList allNodes, int l){
		int [] tour = new int[l];
		boolean [] used = new boolean [l];
		Arrays.fill(used, false);
		tour[0] = 0;
		used [0] = true; 
		for (int i = 1; i < l; i++) {
			int best = -1; 
			for (int j = 0; j< l; j++) {
				if(!used[j] && (best==-1 || dist(tour[i-1],j, allNodes)<dist(tour[i-1],best, allNodes))){
					best = j; 
					//System.out.println(best+" best");
				}
			}
			tour[i] = best;
//			System.out.println(best+" best");
			used [best] = true; 
			
		}
		return tour;
	}
	
	public static int dist(int p1, int p2, ArrayList a){
		Node first = (Node) a.get(p1);
		Node second = (Node) a.get(p2);
		double x = first.getX() - second.getX();
		double y = first.getY() - second.getY();
		double d = Math.sqrt(Math.pow(x,2)+Math.pow(y, 2));
		d = Math.round(d);
		int newD = (int) d;
		return newD; 
		
	}
	

}
