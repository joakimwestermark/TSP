import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class Main{

	//static ArrayList <Node> allNodes = new ArrayList<Node>();
	
	public static void main (String [] args) throws NumberFormatException, IOException{

//		####KATTIO####
		
		Kattio io = new Kattio(System.in, System.out);

		Global.length = io.getInt();
		Global.distanceMatrix = new int[Global.length][Global.length];
		Global.allNodes  = new Node[Global.length];
//		Global.temp = new int [Global.length];
		for (int i = 0; i < Global.length; i++) {
			double x = io.getDouble();
			double y = io.getDouble();
			
			
			
			Node n = new Node(x,y); //	Node(double xx, double yy, int nID, int oID, int p, int n)	
			Global.allNodes[i]=n; //Nodes get the same index as their nameID
		}
		
		dist();
		
		
		Greedy.findTour();
		for (int i = 0; i < Global.length; i++) {
			io.println(Global.distanceMatrix[0][i]);
		}
		
        io.close();
	}
	public static void dist(){
		Global.cN = new ArrayList<ArrayList<Integer>>();
		Global.indexKiller = new ArrayList<HashMap<Integer, Integer>>();
//		Global.indexKiller2 = new HashMap<Integer,HashMap<Integer, Integer>>();

		for (int i = 0; i < Global.length; i++) {
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
			for (int j = 0; j <Global.length; j++) {
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
//			Global.indexKiller2.put(i, hash);
			Global.cN.add(bestValue);
		}

		Global.allNodes = null;

	}

	
	
}
