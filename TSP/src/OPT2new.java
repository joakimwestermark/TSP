import java.util.Arrays;
import java.util.Date;

public class OPT2new {
	static Date date = new Date();

	public static int getNext(int n){
		int next = Global.newTour[n];
		return next;
	}
	public static int [] flipInTheFlip(int index1, int index2){
//		System.out.println(index1+" index1     "+ index2+" index2");
//		System.out.println((index1-1+Global.length)%Global.length+" index1mod     "+ (index2+2)%Global.length+" index2mod");
		
		int [] tmp = Arrays.copyOfRange(Global.theTour, (index1), (index2+1));
		
//		System.out.println(Arrays.toString(tmp)+ "  yayay");
		return tmp;
	}
	public static void joakimEsnygg(int n1, int n2, int n3, int n4){
		int tmp [] = new int [Global.length];
		for (int i = 0; i < Global.length; i++) {
			tmp[i] = Global.newTour[i];
		}
		tmp[n3]=n1;
		tmp[n4]=n2;
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
			tmp[pos] = value;
			value = pos;
			if(pos==n1){
				break;
			}
		}
		
		for (int i = 0; i < Global.length; i++) {
			Global.newTour[i]=tmp[i];
		}
		int index = 0;
		for (int i = 0; i < Global.length; i++) {
			Global.theTour[i]=Global.newTour[index];
			index = Global.newTour[index];
		}
		
//		for (int i = 0; i < tmp.length; i++) {
//			if(tmp[i]==-1){
//				tmp[i]=Global.newTour[i];
//			}
//		}
		
	}
	public static void flipper(int n1, int n2, int n3, int n4){
//		System.out.println("n1: "+n1+"   n2: "+n2+"   n3: "+n3+"   n4: "+n4);
//		System.out.println(n2 + " this is n2");
		joakimEsnygg(n1, n2, n3, n4);
//		int index1 = Global.tourIndexer.get(n2);
//		int index2 = Global.tourIndexer.get(n3);
//		int index11 = Global.tourIndexer.get(n1);
//		int index22 = Global.tourIndexer.get(n4);
//		int index1 = 0;
//		int index2 = 0;
//		int index11 = 0;
//		int index22 = 0;
//		for (int i = 0; i < Global.length; i++) {
//			if(n1==Global.newTour[i]){
//				index1=i;
//			}else if(n2==Global.newTour[i]){
//				index2=i;
//			}else if(n2==Global.newTour[i]){
//				index11=i;
//			}else if(n2==Global.newTour[i]){
//				index22=i;
//			}
//		}
//		int [] tmp;
//		if(index1<index2){
//			tmp = flipInTheFlip(index1,index2);
//		}else{
//			tmp = flipInTheFlip(index2, index1);
//		}
//		tmp = reverseTour(tmp);
//		
//		Global.newTour[index11]=n2;
//		Global.newTour[index22]=n4;
//		for (int i = 0; i < tmp.length-1; i++) { //optminera, räkna ut skillnaden index1-index2 istället
//			int index = tmp[i];
//			int next = tmp[i+1];
//			Global.newTour[index]=next;
//		}
	}
	public static void replaceEdge2(){
		boolean noChange = false;
		int counter = 0;
		
		while(!noChange && (measureTime()<1000)){
			counter++;
//			System.out.println(counter+ " this is counter");
			noChange = true;
			for (int i = 0; i < Global.length-1; i++) {
				int n1 = Global.newTour[i];
				int n2 = getNext(n1);
				for (int j = 0; j < Global.cN.get(0).size(); j++) {
					int n3 = Global.indexKiller2.get(n1).get(Global.cN.get(n1).get(j));
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
/*		
		while (!noChange){
			counter++;
			if(counter>100){
//				System.out.println(counter+ "counter");	
				break;
			}
			noChange = true;
			for (int i = 0; i < Global.length-1; i++) {
				for (int j = 0; j < Global.cN.get(0).size(); j++) {
					int neighbour = Global.indexKiller.get(Global.theTour[i]).get(Global.cN.get(Global.theTour[i]).get(j));
//					System.out.println(i+" "+Global.allNodes[i].getNext()+" "+neighbour+" "+Global.allNodes[neighbour].getNext()+" them shits EARLY");
					
					if (compute(i, neighbour)) {
						int x = i;
						int y = Global.allNodes[Global.fromItoT[i]].getNext();
						int a = neighbour;
						int b = Global.allNodes[Global.fromItoT[neighbour]].getNext();
						if(a!=x && a!=y && b!=x && b!=y){
							int peaceLove = y;
							int andUnderstanding = a;
							int one = Global.tourIndexer.get(y);
							int two = Global.tourIndexer.get(a);
							if(one<two){
								peaceLove = b;
								andUnderstanding = x;
							}
								
							flippin(peaceLove,andUnderstanding);
							noChange = false;	
//							break;
						}
					}
					if (!noChange) { 
						break;
					}
				}
//				break;
			}
		}
*/
	
	}
	public static void flippin(int n2,int n3){
//        for (int i = 0; i < Global.theTour.length; i++) {
//        	Global.tourIndexer.put(Global.theTour[i], i);			
//		}
//    	
//    	System.out.println(Global.theTour[1]);
//		int [] tmp = new int[Global.theTour.length];
//		int n2Index = Global.tourIndexer.get(n2);
//		int n3Index = Global.tourIndexer.get(n3);
//		for (int o = 0; o < tmp.length; o++) {
//			if(Global.theTour[o]==n2){
//				for (int i = 0; i < n3Index-n2Index+1; i++) {
//					tmp[n2Index+i]=Global.theTour[n3Index-i];
//					o++;
//				
//				}
////				o--;
//			}else{
//				tmp[o]=Global.theTour[o];				
//			}
//		}
//		for (int i = 0; i < tmp.length; i++) {
//			Global.theTour[i]=tmp[i];
//		}
	}

    public static void flipEdges(int n1, int n2, int n3, int n4){
        System.out.println("n1 = "+n1+ "      n2= "+n2+"       n3= "+n3+ "          n4= "+n4);

        /*for (int j = 0; j < Global.theTour.length ; j++) {
            System.out.print(Global.theTour[j]+" ,");
        }
        System.out.println("");*/
        //System.out.println("Flipping some edges");
        //n1 och n4 ska flippa kanter
        int indexN2 = 0;
        int indexN3 = 0;
        boolean check1 = true;
        boolean check2 = true;
        int i = 0;
        while ((check1 && check2) || (!check1 && check2) || (check1 && !check2)) {
            if(Global.theTour[i%Global.length]==n2){
                indexN2 = i;
                check1 = false;
            }else if (Global.theTour[i%Global.length]==n3){
                indexN3 = i;
                check2 = false;
            }
            i++;
        }
        int [] tmp = new int[Math.abs(indexN3-indexN2)+1];
        if(indexN2<indexN3){
           tmp = Arrays.copyOfRange(Global.theTour, (indexN2)%Global.length,(indexN3+1)%Global.length);
           System.out.println(Arrays.toString(tmp));
           tmp = reverseTour(tmp);
            System.out.println(Arrays.toString(tmp));
           for (int j = 0; j < tmp.length; j++) {
                Global.theTour[indexN2+j] = tmp[j];
           }
        }
        if(indexN3<indexN2){
            tmp = Arrays.copyOfRange(Global.theTour, (indexN3+1)%Global.length,(indexN2)%Global.length);
            System.out.println(Arrays.toString(tmp));
            tmp = reverseTour(tmp);
            System.out.println(Arrays.toString(tmp));
            for (int j = 0; j < tmp.length; j++) {
                Global.theTour[indexN3+j] = tmp[j];
            }
        }
        /*System.out.println("AAAAAFFFTTTTEEEERRRRR");
        for (int j = 0; j < tmp.length ; j++) {
            System.out.print(tmp[j]+" ,");
        }
        System.out.println("TMP");

        for (int j = 0; j < Global.theTour.length ; j++) {
            System.out.print(Global.theTour[j]+" ,");
        }
        System.out.println("THE TOUR");*/

    }

    public static int[] reverseTour(int[] tmp){
        int [] tmp2 = new int[tmp.length];
        for (int i = 0; i <tmp.length; i++) {
            tmp2[i] = tmp[tmp.length-i-1];
        }
        return tmp2;
    }

	public static void fixDirection(){
//		for (int i = 0; i < Global.length; i++) {
//			int next = Global.allNodes[Global.fromItoT[i]].getNext();
//			if(next==Global.allNodes[Global.fromItoT[next]].getNext()){
//				System.out.println(Global.allNodes[Global.fromItoT[i]].getNameID()+" name of the node getting fixed");
//				int tmp=Global.allNodes[Global.fromItoT[next]].getNext();
//				Global.allNodes[Global.fromItoT[next]].setNext(Global.allNodes[Global.fromItoT[next]].getPrev());
//				Global.allNodes[Global.fromItoT[next]].setPrev(tmp);
//			}
//		}
	}
	public static void swapLIKEaFUCKINGswapSHOULDswapNOWplease(int x, int y, int a, int b){

//			int tmpPrev;
//			int tmpNext;
////			System.out.println(Global.allNodes[Global.fromItoT[a]].getOrderID()+" nr1     "+Global.allNodes[Global.fromItoT[a]].getOrderID()+" nr2");
////			if((Global.allNodes[Global.fromItoT[x]].getOrderID()+Global.allNodes[Global.fromItoT[a]].getOrderID())%2==0){
//			if(1==2){	
//			
//			}else{				
////			tmpPrev = Global.allNodes[Global.fromItoT[x]].getNext();
//				Global.allNodes[Global.fromItoT[x]].setNext(a);
//				System.out.println(Global.allNodes[Global.fromItoT[x]].getNameID()+" n1 får n3 som next"+a);
////			Global.allNodes[Global.fromItoT[tmpPrev]].setPrev(20);
//				
//				tmpPrev = Global.allNodes[Global.fromItoT[y]].getNext();
//				Global.allNodes[Global.fromItoT[y]].setNext(b);
//				Global.allNodes[Global.fromItoT[y]].setPrev(tmpPrev);
//				
//				tmpNext = Global.allNodes[Global.fromItoT[a]].getPrev();
//				Global.allNodes[Global.fromItoT[a]].setPrev(x);
//				Global.allNodes[Global.fromItoT[a]].setNext(tmpNext);
//				
//				
//				Global.allNodes[Global.fromItoT[b]].setPrev(y);
//
//			}
				

	}
	public static boolean compute(int n1, int n2, int n3, int n4){
//        int y = Global.theTour[(x+1)%Global.length];
//        int b = Global.theTour[(a+1)%Global.length];
        
               
		//int y = Global.allNodes[Global.fromItoT[x]].getNext();
		//int b = Global.allNodes[Global.fromItoT[a]].getNext();

		int oldDistance = Global.distanceMatrix[n1][n2] + Global.distanceMatrix[n3][n4];
		int newDistance = Global.distanceMatrix[n1][n3] + Global.distanceMatrix[n2][n4];
		
		if (newDistance < oldDistance) {
			//System.out.println("newDist: "+ newDistance+"   oldDist: "+oldDistance);
			return true;
		}

		return false;
	}
	public static long measureTime(){
		Long time = (new Date().getTime() - date.getTime());
		return time;
	}
}