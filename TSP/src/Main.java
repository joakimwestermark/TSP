import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;


public class Main{

//	static Date date = new Date();

	public static void main (String [] args) throws NumberFormatException, IOException{
		Global.TIME = 0; 
		Global.TIME = System.currentTimeMillis();
//		Global.tabu = new ArrayList<int[]>();


//		####KATTIO####
		
//		Kattio io = new Kattio(System.in, System.out);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
		Global.length = Integer.parseInt(in.readLine());
		Global.distanceMatrix = new double[Global.length][Global.length];
		Node [] allNodes = new Node[Global.length];
		for (int i = 0; i < Global.length; i++) {
			String xy = in.readLine();
			String [] tmp = xy.split(" ");
			double x = Double.parseDouble(tmp[0]);
			double y = Double.parseDouble(tmp[1]);
			Node n = new Node(x,y); 	
			allNodes[i]=n; //Nodes get the same index as their nameID
		}
		
//		Global.length = io.getInt();
//		Global.distanceMatrix = new int[Global.length][Global.length];
//		Node [] allNodes = new Node[Global.length];
//		for (int i = 0; i < Global.length; i++) {
//			double x = io.getDouble();
//			double y = io.getDouble();
//			Node n = new Node(x,y); 	
//			allNodes[i]=n; //Nodes get the same index as their nameID
//		}
		Global.TIME = System.currentTimeMillis();
		dist(allNodes);
		
		Greedy.findTour();
		
		int tour = 0;
		if(Global.shuffleCheck){
			for (int i = 0; i < Global.length; i++) {
				System.out.println(Global.bestTour[tour]);
				tour = Global.bestTour[tour];
			}			
		}else{
			for (int i = 0; i < Global.length; i++) {
				System.out.println(Global.newTour[tour]);
				tour = Global.newTour[tour];
			}
		}
//		io.println(OPT2new.measureTime());
//        io.close();
		in.close();
//      System.out.println(OPT2new.measureTime()+" end time");

	}
	public static void dist(Node [] allNodes){
		for (int i = 0; i < Global.length; i++) {
			Node n1 = allNodes[i];
			for (int j = 0; j <Global.length; j++) {
				Node n2 = allNodes[j];
				double x = n1.getX() - n2.getX();
				double y = n1.getY() - n2.getY();
				double d = Math.sqrt(Math.pow(x,2)+Math.pow(y, 2));
//				d = Math.round(d);
				double newD =  d;
				Global.distanceMatrix[i][j] = newD;	
			}
		}
		TreeMap<Double, Integer> theTree = new TreeMap<Double, Integer>();
		if(Global.length<17){
			Global.numberCN =  Global.length; 
		}
		else{
			Global.numberCN = 15;
		}
		Global.closestN = new ArrayList<int []>();
		for (int i = 0; i < Global.length; i++) {
			Global.closestN.add(new int[Global.numberCN+1]);
			for (int j = 0; j < Global.length; j++) {
				if(i!=j){
					theTree.put(Global.distanceMatrix[i][j], j);
				}
			}
//			System.out.println(theTree.pollLastEntry());
			for (int k = 0; k < Global.numberCN-1; k++) {
				Global.closestN.get(i)[k]= theTree.pollFirstEntry().getValue();					
			}
			theTree.clear();
		}
	}
}
