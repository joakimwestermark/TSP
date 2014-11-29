import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * @author joakimwestermark
 *
 */
public class GUI extends JPanel{
	//all vertices
	//distMatrix
    public static void main(String[] args) { 
    	String s = args[0];
        createFrame(s);
        
    	
        
    }
    public static void createFrame(String s){
        JFrame frame = new JFrame(s);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500,500));
        
        frame.getContentPane().add(new GUI());
        
//        JLabel label = new JLabel("This is the label");
//        frame.getContentPane().add(label);

        frame.pack();
        frame.setVisible(true);
    }
    
    public void paint(Graphics g){
    	Graphics2D g2 = (Graphics2D)g;
    	System.out.println("hej");
    	int factor = 4;
    	for (int i = 0; i < Global.allNodes.size(); i++) {
    		int x1 = (int) Global.allNodes.get(Global.allNodes.get(i).getT()).getX()*factor;
    		int y1 = 500 - (int) Global.allNodes.get(Global.allNodes.get(i).getT()).getY()*factor;
    		int x2 = (int) Global.allNodes.get((Global.allNodes.get((i+1)%Global.allNodes.size())).getT()).getX()*factor;
    		int y2 = 500 - (int) Global.allNodes.get((Global.allNodes.get((i+1)%Global.allNodes.size())).getT()).getY()*factor;
    		g2.drawLine(x1, y1, x2, y2);
        	g2.fillOval(x1, y1, 10, 10);
        	String s = ""+Global.allNodes.get(i).getT();
        	g2.drawString(s,x1, y1);
        	String s2 = ""+Global.originalDist;
        	g2.drawString(s2, 450, 450);
    	}
    }
}
