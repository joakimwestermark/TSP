import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;


public class Main{

//	static Date date = new Date();
	static long TIME = System.currentTimeMillis();

	public static void main (String [] args) throws NumberFormatException, IOException{

//		####KATTIO####
		
		Kattio io = new Kattio(System.in, System.out);
	
		Global.length = io.getInt();
		Global.distanceMatrix = new int[Global.length][Global.length];
		Node [] allNodes = new Node[Global.length];
		for (int i = 0; i < Global.length; i++) {
			double x = io.getDouble();
			double y = io.getDouble();
			Node n = new Node(x,y); 	
			allNodes[i]=n; //Nodes get the same index as their nameID
		}
		
		dist(allNodes);
		
		
		Greedy.findTour();
		int tour = 0;
		for (int i = 0; i < Global.length; i++) {
			io.println(Global.newTour[tour]);
			tour = Global.newTour[tour];
		}
//		io.println(OPT2new.measureTime());
        io.close();
	}
	public static void dist(Node [] allNodes){
		for (int i = 0; i < Global.length; i++) {
			Node n1 = allNodes[i];
			for (int j = 0; j <Global.length; j++) {
				Node n2 = allNodes[j];
				double x = n1.getX() - n2.getX();
				double y = n1.getY() - n2.getY();
				double d = Math.sqrt(Math.pow(x,2)+Math.pow(y, 2));
				d = Math.round(d);
				int newD = (int) d;
				Global.distanceMatrix[i][j] = newD;	
			}
		}
		TreeMap<Integer, Integer> theTree = new TreeMap<Integer, Integer>();
		if(Global.length<5){
			Global.numberCN = Global.length/2; 
		}
		else{
			Global.numberCN = 8;
		}
		Global.closestN = new ArrayList<int []>();
		for (int i = 0; i < Global.length; i++) {
			Global.closestN.add(new int[Global.numberCN]);
			for (int j = 0; j < Global.length; j++) {
				theTree.put(Global.distanceMatrix[i][j], j);
			}
			theTree.pollLastEntry();
			for (int k = 0; k < Global.numberCN-1; k++) {
				Global.closestN.get(i)[k]= theTree.pollFirstEntry().getValue();
			}
			theTree.clear();
		}
	}
}
