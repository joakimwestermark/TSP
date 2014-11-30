

public class OPT2 {
public static void replaceEdge2(){
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < Global.length-1; j++) {
				System.out.println(j+"  JJJJJJJJJJJJJJJJJJJJJJJJJ");
				Node n1 = Global.allNodes[j];
				Node n2 = Global.allNodes[j+1];
				System.out.println(n1.getNameID()+" n1      "+n2.getNameID()+ " n2");
				Node n3= null; 
				Node n4 = null;
				int flag = 0;
				for (int k = 0; k < Global.cN.get(0).size(); k++) {
					flag = 0;
					int neighbour = Global.indexKiller.get(n1.getNameID()).get(Global.cN.get(n1.getNameID()).get(k));
					System.out.println(neighbour+" neighbobob");
					n3 = Global.allNodes[Global.fromItoT[neighbour]];
					n4 = (Global.allNodes[(n3.getOrderID()+1)%Global.length]); 
					System.out.println(n4.getNext()+" n4s NEXT");
					System.out.println(n4.getNameID()+ " the name of n4");
//					System.out.println(n3.getPrev()+" n3 prev");
//					System.out.println(n3.getNext()+" n3 next");
//					System.out.println(n3.getNameID()+" n3    "+ n4.getNameID()+" n4");
					
					int dist1 = Global.distanceMatrix[n1.getNameID()][n2.getNameID()];
					int dist2 = Global.distanceMatrix[n3.getNameID()][n4.getNameID()];
					int newDist1 = Global.distanceMatrix[n1.getNameID()][n3.getNameID()];
					int newDist2 = Global.distanceMatrix[n2.getNameID()][n4.getNameID()];
					System.out.println((dist1+dist2)+" dist old     "+(newDist1+newDist2)+" dist new" );
					System.out.println("n1: "+n1.getNameID()+" n2: "+n2.getNameID()+" n3: "+n3.getNameID()+" n4: "+n4.getNameID());
//					if(!(n2.getT()==n3.getT()) && (!(n1.getT()==n4.getT())&&!(n2.getT()==n3.getT())) && ((dist1+dist2)>(newDist1+newDist2))){
					if(!(n2.getNameID()==n3.getNameID()) && (!(n1.getNameID()==n4.getNameID())&&!(n2.getNameID()==n3.getNameID())) && ((dist1+dist2)>(newDist1+newDist2))){
						System.out.println("not here");
						if(n2.equals(n3)){
							System.out.println("print 1");
//							n3 = null;
							flag = 1;
							continue; 
						}
						break; 
					}else{
						System.out.println("print 2");
//						n3= null;
						flag = 1;
					}
				}
//				if(n3!=null){
				if(flag==0){
					Greedy.totalDistance();
					flipEdge(n1, n2, n3, n4);
					Greedy.totalDistance();
					break;
				}
			}
		}
	}

	public static void flipEdge(Node n1, Node n2, Node n3, Node n4){
		
//		for (int i = 0; i < Global.length; i++) {
//			System.out.println(Global.allNodes[i].getNameID()+"hohohoh");
//		}
//		
		System.out.println("name n1: "+n1.getNameID()+" n2: "+n2.getNameID()+" n3: "+n3.getNameID()+" n4: "+n4.getNameID());
		System.out.println("prev n1: "+n1.getPrev()+" n2: "+n2.getPrev()+" n3: "+n3.getPrev()+" n4: "+n4.getPrev());
		System.out.println("next n1: "+n1.getNext()+" n2: "+n2.getNext()+" n3: "+n3.getNext()+" n4: "+n4.getNext());
//		
		int tmpPrev = n2.getPrev();
		int tmpNext = n2.getNext();
		
//		int tmpOrderID = n2.getOrderID();
		
		
		
		n2.setPrev(n3.getPrev());
		n2.setNext(n3.getNext());
		n3.setPrev(tmpPrev);
		n3.setNext(tmpNext);
		n1.setNext(n3.getNameID());
		n4.setPrev(n2.getNameID());
		
//		n2.changeOrderID(n3.getOrderID());
//		n3.changeOrderID(tmpOrderID);
		
		System.out.println(n4.getNext()+ "N4s NEXT WOOOOOOOOOOOOOOOOOOOW");
		Global.allNodes[Global.fromItoT[n3.getNext()]].setPrev(n3.getNameID()); //Get the n3s next node and set that nodes "prev" to n3s nameID
		Global.allNodes[Global.fromItoT[n3.getNext()]].setNext(n2.getNameID());
		System.out.println(n4.getNext()+ "N4s NEXT WOOOOOOOOOOOOOOOOOOOW");
		System.out.println(Global.allNodes[2].getNameID()+" bör bli 9");
		
//		Global.allNodes[Global.fromItoT[n3.getNext()]].setPrev(n3.getNameID()); //Get the n3s next node and set that nodes "prev" to n3s nameID
//		Global.allNodes[Global.fromItoT[n3.getNext()]].setNext(n2.getNameID());
//		
//		Global.allNodes[Global.fromItoT[n2.getNext()]].setPrev(n2.getNameID());
//		Global.allNodes[Global.fromItoT[n2.getNext()]].setNext(n4.getNext());
//		
		
		System.out.println("********");
		System.out.println("name n1: "+n1.getNameID()+" n2: "+n2.getNameID()+" n3: "+n3.getNameID()+" n4: "+n4.getNameID());
		System.out.println("prev n1: "+n1.getPrev()+" n2: "+n2.getPrev()+" n3: "+n3.getPrev()+" n4: "+n4.getPrev());
		System.out.println("next n1: "+n1.getNext()+" n2: "+n2.getNext()+" n3: "+n3.getNext()+" n4: "+n4.getNext());
		System.out.println(n3.getNext()+"=n3getnext");
		System.out.println(n2.getNext()+"=n2getnext");
		System.out.println(Global.fromItoT[n3.getNext()]+" fromtoI n3getnext");
		System.out.println(Global.fromItoT[n2.getNext()]+" fromtoI n2getnext");
		System.out.println(Global.allNodes[Global.fromItoT[n3.getNext()]].getNameID()+"=3 om 3an ligger på 3ans 3a");
		System.out.println(Global.allNodes[Global.fromItoT[n2.getNext()]].getNameID()+"=5 om 5an.... ");
//		int tmp = n2.getNameID();
//		int tmp1 = n3.getNameID();
//		n2.changeNameID(n3.getNameID());
//		n3.changeNameID(tmp);
		
		
	}

}
