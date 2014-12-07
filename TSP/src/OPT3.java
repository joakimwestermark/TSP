

public class OPT3 {

	public static int getNext(int n){
		int next = Global.newTour[n];
		return next;
	}
	public static void flipper3(int n1, int n2, int n3, int n4, int n5, int n6){
		System.out.println("n1: "+n1+"    n2: "+n2+"    n3: "+n3+"    n4: "+n4+"    n5: "+n5+"    n6: "+n6);
		System.out.println(Global.smallestIndex+" swap nr");
		
//		double distOne = Global.distanceMatrix[n1][n4] + Global.distanceMatrix[n5][n2] + Global.distanceMatrix[n3][n6];		//done
//		double distTwo = Global.distanceMatrix[n1][n5] + Global.distanceMatrix[n4][n2] + Global.distanceMatrix[n3][n6];		//done
//		double distThree = Global.distanceMatrix[n1][n3] + Global.distanceMatrix[n2][n5] + Global.distanceMatrix[n4][n6];	//done	
//		double distFour = Global.distanceMatrix[n1][n4] + Global.distanceMatrix[n5][n3] + Global.distanceMatrix[n2][n6];	//done	
//		
		
		if(Global.smallestIndex==1){
			//flip1 done
			flipper(n1,n2,n3,n4);
			int tour = 0;
			for (int i = 0; i < Global.length; i++) {
				System.out.println(Global.newTour[tour]);
				tour = Global.newTour[tour];
			}
			System.out.println("");
			System.out.println("n1: "+n1+"    n2: "+n2+"    n5: "+n5+"    n6: "+n6);
			flipper(n4,n2,n5,n6); //test alternative
//			flipper(n5,n6,n3,n1); //it atm
//			flipper(n1,n2,n5,n6); //original
//			flipper(n1,n3,n5,n6); //original nya
			tour = 0;
			for (int i = 0; i < Global.length; i++) {
				System.out.println(Global.newTour[tour]);
				tour = Global.newTour[tour];
			}
			System.out.println("");
			System.out.println("n1: "+n1+"    n3: "+n3+"    n4: "+n4+"    n6: "+n6);
			flipper(n1,n3,n4,n6); //test alternative
//			flipper(n1,n5,n4,n3); //it atm
//			flipper(n1,n5,n4,n3); //original
//			flipper(n1,n5,n4,n2); //original nya
			tour = 0;
			for (int i = 0; i < Global.length; i++) {
				System.out.println(Global.newTour[tour]);
				tour = Global.newTour[tour];
			}
			while(true);
			
		}else if(Global.smallestIndex==2){
			//flip2 done
//			System.out.println("yep");
			flipper(n1,n2,n3,n4);
			int tour = 0;
			for (int i = 0; i < Global.length; i++) {
				System.out.println(Global.newTour[tour]);
				tour = Global.newTour[tour];
			}
			System.out.println("");
//			System.out.println("n1: "+n1+"    n3: "+n3+"    n5: "+n5+"    n6: "+n6);
			
			if(getNext(n6)==n5){
				flipper(n3,n1,n6,n5);	
				System.out.println("uno");
			}else{
				flipper(n3,n1,n5,n6);
			}
			
			
			
//			if(getNext(n3)==n1 && getNext(n5)==n6){
//				System.out.println("n3: "+n3+"    n1: "+n1+"    n5: "+n5+"    n6: "+n6);
//
//				flipper(n3,n1,n5,n6);				
//			}else{
//				System.out.println("n3: "+n3+"    n1: "+n1+"    n6: "+n6+"    n5: "+n5);
//				flipper(n3,n1,n6,n5);
//			}
			
			
		}else if(Global.smallestIndex==3){
			//flip3 done
			flipper(n1,n2,n3,n4);
			flipper(n4,n2,n6,n5);
//			flipper(n2,n4,n5,n6); original
			
		}else if(Global.smallestIndex==4){
			//flip4 done
			flipper(n1,n2,n5,n6);
			flipper(n1,n5,n4,n3);
		}
		System.out.println("done");
		int tour = 0;
		for (int i = 0; i < Global.length; i++) {
			System.out.println(Global.newTour[tour]);
			tour = Global.newTour[tour];
		}
		System.out.println("");
	}
	public static void flipper(int n1, int n2, int n3, int n4){
		int tmp [] = new int [Global.length];
		System.arraycopy(Global.newTour, 0, tmp, 0, Global.length);
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
		boolean noChange = true;
			int counter = 0;
			while(noChange && measureTime()<(2500)){
				if(counter>10){
					break;					
				}
				noChange = false;				
				for (int i = 0; i < Global.length; i++) {
					
					int n1 = Global.newTour[i];
					int n2 = getNext(n1);
					for (int j = 0; j < Global.length; j++) {
					
						int n3 = Global.newTour[j];
						int n4 = getNext(n3);
						
						for (int k = 0; k < Global.length; k++) {
							int n5 = Global.newTour[k];
							int n6 = getNext(n5);
							
								if(n1!=n3 && n1!=n5 && n1!=n4 && n1!=n6 && n2!=n3 && n2!=n4 && n2!=n5 && n2!= n6 && n3!=n5 && n3!=n6 && n4!=n5 && n4!=n6 && getNext(n4)!=n1 && getNext(n6)!=n1 && getNext(n4)!=n5 && getNext(n6)!=n3 && getNext(n2)!=n3 && getNext(n2)!=n5){ //byt plats på denna ifsatsen och compute
									if(compute(n1,n2,n3,n4,n5,n6)){
									counter++;
									flipper3(n1,n2,n3,n4,n5,n6);
									noChange=true;
								
								}
								
							}
							if(noChange){
								break;
							}
						}
					}
				}
			}
			
	}
	


				

	public static boolean compute(int n1, int n2, int n3, int n4, int n5, int n6){
		
		double oldDistance = Global.distanceMatrix[n1][n2] + Global.distanceMatrix[n3][n4] + Global.distanceMatrix[n5][n6];
		
//		double distOne = Global.distanceMatrix[n1][n3] + Global.distanceMatrix[n2][n6] + Global.distanceMatrix[n4][n5];		
//		double distTwo = Global.distanceMatrix[n1][n6] + Global.distanceMatrix[n2][n3] + Global.distanceMatrix[n4][n5];		
//		double distThree = Global.distanceMatrix[n1][n4] + Global.distanceMatrix[n2][n6] + Global.distanceMatrix[n3][n5];		
//		double distFour = Global.distanceMatrix[n1][n3] + Global.distanceMatrix[n2][n5] + Global.distanceMatrix[n4][n6];		
		
		double distOne = Global.distanceMatrix[n1][n4] + Global.distanceMatrix[n5][n2] + Global.distanceMatrix[n3][n6];		
		double distTwo = Global.distanceMatrix[n1][n5] + Global.distanceMatrix[n4][n2] + Global.distanceMatrix[n3][n6];		
		double distThree = Global.distanceMatrix[n1][n3] + Global.distanceMatrix[n2][n5] + Global.distanceMatrix[n4][n6];		
		double distFour = Global.distanceMatrix[n1][n4] + Global.distanceMatrix[n5][n3] + Global.distanceMatrix[n2][n6];		
		
		
		Global.distArr = new double []{oldDistance,distOne,distTwo,distThree,distFour};
		Global.distArr[1]+=2000;
		Global.distArr[3]+=2000;
		Global.distArr[4]+=2000;
		
		double smallest = Double.MAX_VALUE;
		Global.smallestIndex = -2;
		for (int i = 0; i < 5; i++) {
			if(Global.distArr[i]<smallest){
				smallest = Global.distArr[i];
				Global.smallestIndex= i;
			}
		}
		
		System.out.println("oldDist: "+Global.distArr[0]+"     distTwo: "+Global.distArr[2]);
		if(Global.smallestIndex!=0){
			return true;
		}else{
			return false;
		}
	}
	
	public static long measureTime(){
		Long time = System.currentTimeMillis()-Global.TIME;
		return time;
	}
}