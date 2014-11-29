import java.util.ArrayList;
import java.util.Collections;


public class OPT2 {
public static ArrayList<Node> replaceEdge2(ArrayList<Node> allNodes){
		
		for (int i = 0; i < 0; i++) {
			for (int j = 0; j < allNodes.size()-1; j++) {
				Node n1 = allNodes.get(j);
				Node n2 = allNodes.get(j+1);
				System.out.println(n1.getT()+" n1      "+n2.getT()+ " n2");
				Node n3= null; 
				Node n4 = null;
				int flag = 0;
				for (int k = 0; k < Global.cN.get(0).size(); k++) {
					flag = 0;
					int neighbour = Global.indexKiller.get(n1.getT()).get(Global.cN.get(n1.getT()).get(k));
					System.out.println(neighbour+" neighbobob");
					n3 = allNodes.get(Global.fromItoT[neighbour]);
					n4 = (allNodes.get(n3.getI()+1)); 
					System.out.println(n3.getPrev()+" n3 prev");
					System.out.println(n3.getNext()+" n3 next");
					System.out.println(n3.getT()+" n3    "+ n4.getT()+" n4");
					int dist1 = Global.distanceMatrix[n1.getT()][n2.getT()];
					int dist2 = Global.distanceMatrix[n3.getT()][n4.getT()];
					int newDist1 = Global.distanceMatrix[n1.getT()][n3.getT()];
					int newDist2 = Global.distanceMatrix[n2.getT()][n4.getT()];
					System.out.println((dist1+dist2)+" dist old     "+(newDist1+newDist2)+" dist new" );
					System.out.println("n1: "+n1.getT()+" n2: "+n2.getT()+" n3: "+n3.getT()+" n4: "+n4.getT());
//					if(!(n2.getT()==n3.getT()) && (!(n1.getT()==n4.getT())&&!(n2.getT()==n3.getT())) && ((dist1+dist2)>(newDist1+newDist2))){
					if(!(n2.getT()==n3.getT()) && (!(n1.getT()==n4.getT())&&!(n2.getT()==n3.getT())) && ((dist1+dist2)>(newDist1+newDist2))){
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
					System.out.println(Greedy.totalDistance(allNodes)+" dist before flip");
					allNodes = flipEdge(allNodes, n1, n2, n3, n4);
					System.out.println(Greedy.totalDistance(allNodes)+" dist after flip");
					break;
				}
			}
		}
		
	
		//save closest neighbours när vi skapar matrisen 
		//loopa iteration
			//loopa igenom alla cn (hur många ska vi spara?
				//x,y = första kanten = kant1, som finns i tour 
				//kx1,ky1 = kant1:s closest neighbour
				//x1,y1 = andra kanten = kant2, som finns i tour
				//x1,closestNeighbour < x1,y1
		
	
	
	
	/*int theBest = 0;
		for (int i = 0; i < allNodes.size()-2; i++) {
			for (int j = 0+i; j < allNodes.size()-2; j++) {
				if(i!=j){
					int improvement = compute(allNodes,i,j);
					if(improvement>0){
						allNodes = swapEdges(allNodes,i,j);
//						break;
					}else{
												
					}
				}
			}
		}*/
		return allNodes;
	}

	public static ArrayList<Node> flipEdge(ArrayList<Node> a, Node n1, Node n2, Node n3, Node n4){
//		a.get(n2.getI()).changeT(n4.getT());
//		a.get(n4.getI()).changeT(n2.getT());
		
//		System.out.println("flipper");
//		int tmp = n2.getT();
//		int tmp1 = n4.getT();
//		n2.changeT(n4.getT());
//		n4.changeT(tmp);
//		Global.fromItoT[n4.getI()] = tmp;
//		Global.fromItoT[n2.getI()] = tmp1;
		
		int tmp = n2.getT();
		int tmp1 = n3.getT();
		n2.changeT(n3.getT());
		n3.changeT(tmp);
		
		Collections.swap(a, n3.getI(), n2.getI());
//		int temp = n3.getI();
//		n3.changeI(n2.getI());
//		n2.changeI(temp);
//		Node tempNode = n2;
//		int n2I = n3.getI();
//		int n3I = n3.getI();
//		a.set(n2.getI(), n3);
//		a.set(n3.getI(), tempNode);
//		a.get(n2I).changeI(n3.getI());
//		a.get(n3I).changeI(tempNode.getI());
//		n2 = tempNode; 
		
//		Node tempNode = n2;
//		a.set(n2.getI(), n3);
//		a.set(n3.getI(), tempNode);
//		a.get(tempNode.getI()).changeI(n3.getI());
//		a.get(n3.getI()).changeI(tempNode.getI());
//		
		Global.fromItoT[n3.getI()] = tmp;
		Global.fromItoT[n2.getI()] = tmp1;
		
		return a; 
	}

	public static ArrayList<Node> swapEdges(ArrayList<Node> allNodes,int i, int j){
//		int tmp = allNodes.get(j).getT();
//		allNodes.get(j).changeT(allNodes.get(j+2).getT());
//		allNodes.get(j+2).changeT(tmp);
		
//		Global.distanceMatrix[allNodes.get(i).getT()][tmp] = Global.distanceMatrix[allNodes.get(i).getT()][allNodes.get(j+2).getT()];
//		Global.distanceMatrix[allNodes.get(i).getT()][allNodes.get(j+2).getT()] = Global.distanceMatrix[allNodes.get(i).getT()][tmp];
		
//		int tmp = allNodes.get(j).getT();
//		allNodes.get(j).changeT(allNodes.get(i+2).getT());
//		allNodes.get(i+2).changeT(tmp);
//		
		
		int tmp = allNodes.get(i+1).getT();
		allNodes.get(i+1).changeT(allNodes.get(j+1).getT());
		allNodes.get(j+1).changeT(tmp);
		
		
//		
//		Global.distanceMatrix[allNodes.get(i).getT()][tmp] = Global.distanceMatrix[allNodes.get(i).getT()][allNodes.get(i+2).getT()];
//		Global.distanceMatrix[allNodes.get(i+2).getT()][allNodes.get(j+2).getT()] = Global.distanceMatrix[tmp][allNodes.get(j+2).getT()];
		
		return allNodes;
	}
	
	public static int compute(ArrayList<Node> allNodes,int i, int j){
		
//		int from1 = allNodes.get(i).getT();
//		int from2 = allNodes.get(i+2).getT();
//		
//		int to1 = allNodes.get(j).getT();
//		int to2 = allNodes.get(j+2).getT();
		
		int from1 = allNodes.get(i).getT();
		int from2 = allNodes.get(j+1).getT();
		
		int to1 = allNodes.get(i+1).getT();
		int to2 = allNodes.get(j+2).getT();
		
		
//		System.out.println(Global.distanceMatrix[from1][to1]+" 1");
//		System.out.println(Global.distanceMatrix[from2][to2]+" 2");
//		return (Global.distanceMatrix[from1][to1]+Global.distanceMatrix[from2][to2])-(Global.distanceMatrix[from1][to2]+Global.distanceMatrix[from2][to1]);
		return (Global.distanceMatrix[from1][to1]+Global.distanceMatrix[from2][to2])-(Global.distanceMatrix[from1][from2]+Global.distanceMatrix[to1][to2]);
		
	}
}
