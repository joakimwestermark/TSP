import java.util.Date;

public class OPT2new {

	public static int getNext(int n){
		int next = Global.newTour[n];
		return next;
	}
	
	public static void flipper(int n1, int n2, int n3, int n4){
		int tmp [] = new int [Global.length];

		for (int i = 0; i < Global.length; i++) { //tung operation
			tmp[i] = Global.newTour[i];
		}
		Global.newTour[n3]=n1;
		Global.newTour[n4]=n2;
						
		
		int pos = 0;
		int value = n4;
		for (int i = 0; i < Global.length; i++) {	 //kan råka reversa åt fel håll, dvs 99% istället för 1%
			pos = tmp[value];
			Global.newTour[pos] = value;
			value = pos;
			if(pos==n1){
				break;
			}
		}
		
		
	}
	public static void replaceEdge2(){
		boolean noChange = false;
		
		while(!noChange && (measureTime()<(1750))){
			noChange = true;
			for (int i = 0; i < Global.length-1; i++) {
				int n1 = Global.newTour[i];
				int n2 = getNext(n1);
				for (int j = 0; j < Global.cN.get(0).size(); j++) {
					int n3 = Global.indexKiller.get(n1).get(Global.cN.get(n1).get(j));
					int n4 = getNext(n3);
					if(compute(n1,n2,n3,n4)){
						if(n1!=n3 && n1!=n4 && n2!=n3 && n2!=n4){
							flipper(n1,n2,n3,n4);
							noChange=false;
						}
					}
					if(!noChange){
						break;
					}
				}
			}
		}
	}


				

	public static boolean compute(int n1, int n2, int n3, int n4){
		int oldDistance = Global.distanceMatrix[n1][n2] + Global.distanceMatrix[n3][n4];
		int newDistance = Global.distanceMatrix[n1][n3] + Global.distanceMatrix[n2][n4];		
		if (newDistance < oldDistance) {
			return true;
		}
		return false;
	}
	public static long measureTime(){
		Long time = (new Date().getTime() - Main.date.getTime());
		return time;
	}
}