import java.util.ArrayList;
import java.util.HashMap;


public abstract class Global {
	public static double[][] distanceMatrix;
	public static int length;
	static ArrayList <ArrayList<Integer>> cN;
	static ArrayList <HashMap<Integer, Integer>> indexKiller;
	
	//new stuff
	static int [] newTour;
	static ArrayList<int[]> closestN;
	static int numberCN;
	static int [] bestTour; 
	static long TIME;
	static int bestSum;
	static ArrayList <int[]> tabu;
	static boolean shuffleCheck = false;
	static double [] distArr;
	static int smallestIndex;
	static int repeater = 0;
	static int repeater2 = 0;
	static int reapeterIndex = 0;
}
