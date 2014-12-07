import java.util.Arrays;


public class Greedy{
	
	public static void findTour(){
				
		Global.newTour = new int[Global.length];
		Arrays.fill(Global.newTour, -1);
		int n1 = 0;
		int original = 0;
		for (int i = 0; i < Global.length-1; i++) {
			int best = -1;
			for (int j = 0; j< Global.length; j++) {
				if(n1!=j){
					if(Global.newTour[j]==-1 && (best==-1 || Global.distanceMatrix[n1][j] < Global.distanceMatrix[n1][best])){
						best = j;
					}
				}
			}
			Global.newTour[n1] = best;

			n1 = best;
		}
		Global.newTour[n1]=original;
		if(Global.length<150){
			for (int i = 0; i < 3; i++) {
				OPT3new.replaceEdge2();			
			}
		}
		OPT2new.replaceEdge2();
		OPT2new.replaceEdge2pure();
		if(Global.length<150){
			OPT3new.replaceEdge2();			
		}

	}
}
