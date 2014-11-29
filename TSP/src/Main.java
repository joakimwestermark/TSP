import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Main{

	//static ArrayList <Node> allNodes = new ArrayList<Node>();
	
	public static void main (String [] args) throws NumberFormatException, IOException{

//		####KATTIO####
		Kattio io = new Kattio(System.in, System.out);
		Global.length = io.getInt();
		Global.distanceMatrix = new int[Global.length][Global.length];
		Global.allNodes  = new ArrayList<Node>();
		
		for (int i = 0; i < Global.length; i++) {
			double x = io.getDouble();
			double y = io.getDouble();
			Node n = new Node(x,y, 0, i,0,0);
			//System.out.println(n.getX());
			Global.allNodes.add(n);
			//System.out.println(allNodes.size());
		}
		
		Greedy.dist(Global.allNodes);
		
		//System.out.println(allNodes.size());
//		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
//		for (String line = in.readLine(); line != null; line = in.readLine()) {
//            String [] s = line.split(" ");
//            if(s.length==1){
//            	length=Integer.parseInt(s[0]);
//            }else{
//            	double x = Double.parseDouble(s[0]);
//            	double y = Double.parseDouble(s[1]);
//            	Node n = new Node(x,y);
//            	allNodes.add(n);            	
//            }
//        }

		
		int[] tour = Greedy.findTour(Global.allNodes);
		
		for (int i = 0; i < Global.allNodes.size(); i++) {
			System.out.println(Global.allNodes.get(i).getT()+" Teeee    "+Global.allNodes.get(i).getI()+" I");
		}
		
		for (int i = 0; i < tour.length; i++) {
			io.println(tour[i]);
//			if(i <tour.length-2){
//				io.println(tour[i]);
//			}
//			else{
//				io.print(tour[i]);
//			}
//			System.out.println(tour[i]);
		}
		
        io.close();
	}
	
	
}
