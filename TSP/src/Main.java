import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;


public class Main{

	static Date date = new Date();

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
		io.println(OPT2new.measureTime());
        io.close();
	}
	public static void dist(Node [] allNodes){
		Global.cN = new ArrayList<ArrayList<Integer>>();
		Global.indexKiller = new ArrayList<HashMap<Integer, Integer>>();

		for (int i = 0; i < Global.length; i++) {
			Node n1 = allNodes[i];
			ArrayList<Integer> bestValue = new ArrayList<Integer>();
			int a = 20;
			if(Global.length<=a){
				a=Global.length-1;
			}
			for (int j = 0; j < a; j++) {
				bestValue.add(Integer.MAX_VALUE-i);
			}
			HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
			for (int j = 0; j <Global.length; j++) {
				Node n2 = allNodes[j];
				double x = n1.getX() - n2.getX();
				double y = n1.getY() - n2.getY();
				double d = Math.sqrt(Math.pow(x,2)+Math.pow(y, 2));
				d = Math.round(d);
				int newD = (int) d;
				if(newD!=0){
					bestValue.add(newD);
					Collections.sort(bestValue);
					bestValue.remove(bestValue.size()-1);
					if(bestValue.contains(newD)){
                        hash.put(newD, j);                                              
					}
					
				}
				Global.distanceMatrix[i][j] = newD;	
			}
			Global.indexKiller.add(hash);
			Global.cN.add(bestValue);
		}
	}
}
