
public class Node {
	double x;
	double y; 
	int turn; 
	int input; 
	
	Node(double a, double b, int t, int i){
		turn = t; 
		input = i; 
		x = a; 
		y = b; 
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y; 
	}
	
	public int getT(){
		return turn; 
	}
	
	public void changeT(int b){
		turn = b; 
	}
	
	public int getI(){
		return input; 
	}

	

}
