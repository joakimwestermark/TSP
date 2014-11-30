import sun.awt.SunHints;

import java.util.Arrays;
import java.util.Collections;

public class OPT2new {
	public static void replaceEdge2(){
		int counter = 0;
		boolean noChange = false;
		while (!noChange) {
			counter++;
            System.out.print(counter+" counter");
			if(counter>50){
				break;				
			}
			noChange = true;
			for (int i = 0; i < Global.theTour.length-1; i++) { //change numbers of iterations
                int n1 = Global.theTour[i];
                int n2 = Global.theTour[i+1];
				for (int j = 0; j < Global.cN.get(0).size(); j++) {
					int n3 = Global.indexKiller.get(Global.allNodes[n1].getNameID()).get(Global.cN.get(Global.allNodes[n1].getNameID()).get(j));
					//System.out.println(i+" "+Global.allNodes[i].getNext()+" "+neighbour+" "+Global.allNodes[neighbour].getNext()+" them shits EARLY");
					if (compute(n1, n3)) {
                        int n4 = 0;
                        for (int k = 0; k < Global.theTour.length; k++) {
                            if(Global.theTour[k]==n3){
                                n4 = Global.theTour[(k+1)%Global.theTour.length];
                            }
                        }
                        if(n3!=n4 && n3!=n1 && n3!=n2 && n1!=n2 && n4!=n1 && n4!=n2){
                            //System.out.println("hej hej"+ counter);
							flipEdges(n1, n2, n3, n4);
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
		for (int i = 0; i < Global.length; i++) {
			int next = Global.allNodes[Global.fromItoT[i]].getNext();
			if(next==Global.allNodes[Global.fromItoT[next]].getNext()){
				System.out.println(Global.allNodes[Global.fromItoT[i]].getNameID()+" name of the node getting fixed");
				int tmp=Global.allNodes[Global.fromItoT[next]].getNext();
				Global.allNodes[Global.fromItoT[next]].setNext(Global.allNodes[Global.fromItoT[next]].getPrev());
				Global.allNodes[Global.fromItoT[next]].setPrev(tmp);
			}
		}
	}
	public static void swapLIKEaFUCKINGswapSHOULDswapNOWplease(int x, int y, int a, int b){

			int tmpPrev;
			int tmpNext;
//			System.out.println(Global.allNodes[Global.fromItoT[a]].getOrderID()+" nr1     "+Global.allNodes[Global.fromItoT[a]].getOrderID()+" nr2");
//			if((Global.allNodes[Global.fromItoT[x]].getOrderID()+Global.allNodes[Global.fromItoT[a]].getOrderID())%2==0){
			if(1==2){	
			
			}else{				
//			tmpPrev = Global.allNodes[Global.fromItoT[x]].getNext();
				Global.allNodes[Global.fromItoT[x]].setNext(a);
				System.out.println(Global.allNodes[Global.fromItoT[x]].getNameID()+" n1 får n3 som next"+a);
//			Global.allNodes[Global.fromItoT[tmpPrev]].setPrev(20);
				
				tmpPrev = Global.allNodes[Global.fromItoT[y]].getNext();
				Global.allNodes[Global.fromItoT[y]].setNext(b);
				Global.allNodes[Global.fromItoT[y]].setPrev(tmpPrev);
				
				tmpNext = Global.allNodes[Global.fromItoT[a]].getPrev();
				Global.allNodes[Global.fromItoT[a]].setPrev(x);
				Global.allNodes[Global.fromItoT[a]].setNext(tmpNext);
				
				
				Global.allNodes[Global.fromItoT[b]].setPrev(y);

			}
				

	}
	public static boolean compute(int x, int a){
        int y = Global.theTour[(x+1)%Global.length];
        int b = Global.theTour[(a+1)%Global.length];
		//int y = Global.allNodes[Global.fromItoT[x]].getNext();
		//int b = Global.allNodes[Global.fromItoT[a]].getNext();

		int oldDistance = Global.distanceMatrix[x][y] + Global.distanceMatrix[a][b];
		int newDistance = Global.distanceMatrix[x][a] + Global.distanceMatrix[y][b];
		
		if (newDistance < oldDistance) {
			//System.out.println("newDist: "+ newDistance+"   oldDist: "+oldDistance);
			return true;
		}

		return false;
	}
}