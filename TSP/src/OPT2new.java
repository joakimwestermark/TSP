import java.util.Date;

public class OPT2new {
	static Date date = new Date();

	public static int getNext(int n){
		int next = Global.newTour[n];
		return next;
	}
	
	public static void flipper(int n1, int n2, int n3, int n4){
//		int tmp [] = new int [Global.length];
		Global.temp = new int [Global.length];
		for (int i = 0; i < Global.length; i++) {
//			tmp[i] = Global.newTour[i];
			Global.temp[i] = Global.newTour[i];
		}
//		tmp[n3]=n1;
//		tmp[n4]=n2;
		Global.temp[n3]=n1;
		Global.temp[n4]=n2;
//		int six = Global.newTour[n4];
//		tmp[six]=n4;
//		int two = Global.newTour[six];
//		tmp[two]=six;
//		int one = Global.newTour[two];
//		tmp[one]=two;
//		int seven = Global.newTour[one];
//		tmp[seven] = one;
		//if int "XX" = n1, breaka och kopiera resten rakt av, all reverse är då klar.
		//fyll sedan i de som saknas
				
		
		
		int pos = 0;
		int value = n4;
		for (int i = 0; i < Global.length; i++) {	
			pos = Global.newTour[value];
//			tmp[pos] = value;
			Global.temp[pos] = value;
			value = pos;
			if(pos==n1){
				break;
			}
		}
		
		for (int i = 0; i < Global.length; i++) {
//			Global.newTour[i]=tmp[i];
			Global.newTour[i]=Global.temp[i];
		}
		
	}
	public static void replaceEdge2(){
		boolean noChange = false;
		
		while(!noChange && (measureTime()<1000)){
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
		Long time = (new Date().getTime() - date.getTime());
		return time;
	}
}