
public class Node {
	double x;
	double y; 
	int turn; 
	int input; 
	int prev;
	int next;
	
	Node(double a, double b, int t, int i, int p, int n){
		turn = t; 
		input = i; 
		x = a; 
		y = b; 
		prev = p;
		next = n;
	}
	public int getPrev(){
		return prev;
	}
	public void setPrev(int q){
		prev = q;
	}
	public int getNext(){
		return next;
	}
	public void setNext(int q){
		next = q;
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
	public void changeI(int b){
		input = b; 
	}
}
