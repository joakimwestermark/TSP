
public class Node {
	double x;
	double y; 
	int nameID; 
	int orderID; 
	int prev;
	int next;
	
	Node(double xx, double yy, int nID, int oID, int p, int n){
		nameID = nID; 
		orderID = oID; 
		x = xx; 
		y = yy; 
		prev = p;
		next = n;
	}
	public int getPrev(){
		return prev;
	}
	public void setPrev(int p){
		prev = p;
	}
	public int getNext(){
		return next;
	}
	public void setNext(int n){
		next = n;
	}
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y; 
	}
	
	public int getNameID(){
		return nameID; 
	}
	
	public void changeNameID(int n){
		nameID = n; 
	}
	
	public int getOrderID(){
		return orderID; 
	}
	public void changeOrderID(int o){
		orderID = o; 
	}
}
