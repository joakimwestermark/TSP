import java.util.ArrayList;


public class OPT2 {
	public static ArrayList<Node> replaceEdge2(ArrayList<Node> allNodes){
		
//		boolean noChange = true; 
		for (int i = 0; i < allNodes.size()-2; i++) {
			for (int j = 0+i; j < allNodes.size()-2; j++) {
				if(i!=j){
					int improvement = compute(allNodes,i,j);
					if(improvement>0){
						allNodes = swapEdges(allNodes,i,j);
					}
				}
			}
		}
		return allNodes;
		
		
	}
	public static ArrayList<Node> swapEdges(ArrayList<Node> allNodes,int i, int j){
//		int tmp = allNodes.get(j).getT();
//		allNodes.get(j).changeT(allNodes.get(j+2).getT());
//		allNodes.get(j+2).changeT(tmp);
//		
//		Global.distanceMatrix[allNodes.get(i).getT()][tmp] = Global.distanceMatrix[allNodes.get(i).getT()][allNodes.get(j+2).getT()];
//		Global.distanceMatrix[allNodes.get(i).getT()][allNodes.get(j+2).getT()] = Global.distanceMatrix[allNodes.get(i).getT()][tmp];
//		
		int tmp = allNodes.get(j).getT();
		allNodes.get(j).changeT(allNodes.get(i+2).getT());
		allNodes.get(i+2).changeT(tmp);
		
		Global.distanceMatrix[allNodes.get(i).getT()][tmp] = Global.distanceMatrix[allNodes.get(i).getT()][allNodes.get(i+2).getT()];
		Global.distanceMatrix[allNodes.get(i+2).getT()][allNodes.get(j+2).getT()] = Global.distanceMatrix[tmp][allNodes.get(j+2).getT()];
		
		return allNodes;
	}
	
	public static int compute(ArrayList<Node> allNodes,int i, int j){
		
		int from1 = allNodes.get(i).getT();
		int from2 = allNodes.get(i+2).getT();
		
		int to1 = allNodes.get(j).getT();
		int to2 = allNodes.get(j+2).getT();
		
//		System.out.println(Global.distanceMatrix[from1][to1]+" 1");
//		System.out.println(Global.distanceMatrix[from2][to2]+" 2");
//		return (Global.distanceMatrix[from1][to1]+Global.distanceMatrix[from2][to2])-(Global.distanceMatrix[from1][to2]+Global.distanceMatrix[from2][to1]);
		return (Global.distanceMatrix[from1][to1]+Global.distanceMatrix[from2][to2])-(Global.distanceMatrix[from1][from2]+Global.distanceMatrix[to1][to2]);

	}
}
