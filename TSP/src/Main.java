import java.io.IOException;
import java.util.HashMap;


public class Main{

	//static ArrayList <Node> allNodes = new ArrayList<Node>();
	
	public static void main (String [] args) throws NumberFormatException, IOException{

//		####KATTIO####
		Kattio io = new Kattio(System.in, System.out);
		Global.length = io.getInt();
		Global.distanceMatrix = new int[Global.length][Global.length];
		Global.allNodes  = new Node[Global.length];
        Global.theTour = new int[Global.length];
//        Global.tourIndexer = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < Global.length; i++) {
			double x = io.getDouble();
			double y = io.getDouble();
			Node n = new Node(x,y, 0, i,0,0); //	Node(double xx, double yy, int nID, int oID, int p, int n)
			//System.out.println(n.getX());
//			Global.allNodes.add(n);
			Global.allNodes[i]=n; //Nodes get the same index as their nameID
			//System.out.println(allNodes.size());
		}
		
		Greedy.dist();
		
		
		int[] tour = Greedy.findTour();
		
		/*for (int i = 0; i < Global.length; i++) {
			System.out.println(Global.allNodes[i].getNameID()+" Teeee    "+Global.allNodes[i].getOrderID()+" I");
		}*/
		
		for (int i = 0; i < tour.length; i++) {
			io.println(tour[i]);
		}
		
        io.close();
	}
	
	
}
