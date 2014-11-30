
public class OPT2new {
	public static void replaceEdge2(){
		int counter = 0;
		boolean noChange = false;
		while (!noChange) {
			counter++;
			if(counter>50){
				break;				
			}
			noChange = true;
			for (int i = 0; i < Global.length-1; i++) {
				for (int j = 0; j < Global.cN.get(0).size(); j++) {
					int neighbour = Global.indexKiller.get(Global.allNodes[i].getNameID()).get(Global.cN.get(Global.allNodes[i].getNameID()).get(j));
					System.out.println(i+" "+Global.allNodes[i].getNext()+" "+neighbour+" "+Global.allNodes[neighbour].getNext()+" them shits EARLY");
					
					if (compute(i, neighbour)) {
						int x = i;
						int y = Global.allNodes[Global.fromItoT[i]].getNext();
						int a = neighbour;
						int b = Global.allNodes[Global.fromItoT[neighbour]].getNext();
						if(a!=b && a!=x && a!=y && x!=y && b!=x && b!=y){
							swapLIKEaFUCKINGswapSHOULDswapNOWplease(x,y,a,b);
							fixDirection();
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
//	public void swap(int x, int y, int a, int b) {
			System.out.println(x+" "+y+" "+a+" "+b+" them shits");
			System.out.println("name n1: "+Global.allNodes[Global.fromItoT[x]].getNameID()+" n2: "+Global.allNodes[Global.fromItoT[y]].getNameID()+" n3: "+Global.allNodes[Global.fromItoT[a]].getNameID()+" n4: "+Global.allNodes[Global.fromItoT[b]].getNameID());
			System.out.println("prev n1: "+Global.allNodes[Global.fromItoT[x]].getPrev()+" n2: "+Global.allNodes[Global.fromItoT[y]].getPrev()+" n3: "+Global.allNodes[Global.fromItoT[a]].getPrev()+" n4: "+Global.allNodes[Global.fromItoT[b]].getPrev());
			System.out.println("next n1: "+Global.allNodes[Global.fromItoT[x]].getNext()+" n2: "+Global.allNodes[Global.fromItoT[y]].getNext()+" n3: "+Global.allNodes[Global.fromItoT[a]].getNext()+" n4: "+Global.allNodes[Global.fromItoT[b]].getNext());
			
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
				
//				Global.allNodes[Global.fromItoT[Global.allNodes[Global.fromItoT[a]].getNext()]].setPrev(Global.allNodes[Global.fromItoT[a]].getNameID()); //Get the n3s next node and set that nodes "prev" to n3s nameID
//				Global.allNodes[Global.fromItoT[Global.allNodes[Global.fromItoT[a]].getNext()]].setNext(Global.allNodes[Global.fromItoT[y]].getNameID());
				
				
				System.out.println("***************************");
				System.out.println("name n1: "+Global.allNodes[Global.fromItoT[x]].getNameID()+" n2: "+Global.allNodes[Global.fromItoT[y]].getNameID()+" n3: "+Global.allNodes[Global.fromItoT[a]].getNameID()+" n4: "+Global.allNodes[Global.fromItoT[b]].getNameID());
				System.out.println("prev n1: "+Global.allNodes[Global.fromItoT[x]].getPrev()+" n2: "+Global.allNodes[Global.fromItoT[y]].getPrev()+" n3: "+Global.allNodes[Global.fromItoT[a]].getPrev()+" n4: "+Global.allNodes[Global.fromItoT[b]].getPrev());
				System.out.println("next n1: "+Global.allNodes[Global.fromItoT[x]].getNext()+" n2: "+Global.allNodes[Global.fromItoT[y]].getNext()+" n3: "+Global.allNodes[Global.fromItoT[a]].getNext()+" n4: "+Global.allNodes[Global.fromItoT[b]].getNext());
			
				Greedy.createTourList();
			}
				

	}
	public static boolean compute(int x, int a){
		int y = Global.allNodes[Global.fromItoT[x]].getNext();
		int b = Global.allNodes[Global.fromItoT[a]].getNext();

		int oldDistance = Global.distanceMatrix[x][y] + Global.distanceMatrix[a][b];
		int newDistance = Global.distanceMatrix[x][a] + Global.distanceMatrix[y][b];
		
		if (newDistance < oldDistance) {
			System.out.println("newDist: "+ newDistance+"   oldDist: "+oldDistance);
			return true;
		}

		return false;
	}
}