import java.util.ArrayList;
import java.util.HashMap;


public abstract class Global {
    public static int [] theTour;
	public static int[][] distanceMatrix;
	public static int length;
	public static int originalDist;
	static Node[] allNodes;
	static ArrayList <ArrayList<Integer>> cN;
	static ArrayList <HashMap<Integer, Integer>> indexKiller;
	static HashMap<Integer,HashMap<Integer, Integer>> indexKiller2;
	static int [] fromItoT;
	static HashMap<Integer, Integer> tourIndexer;
	
	//new stuff
	public static int [] newTour;
	
	
}
