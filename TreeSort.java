package recursive;

import common.*;

import java.applet.*;
import java.awt.*;
import java.util.*;

public class TreeSort extends Applet {
	
	private static final long serialVersionUID = 1L;
	
	static int len = 25;
	int[] a = General.shuffle(General.newList(len));
	
	//static int sclX = 10, sclY = 5, w = len * sclX, h = len * sclY + 50;
	static int sclX = 10, sclY = 5, w = 1600, h = 900;
	
	static int comparisons = 0;
	
	static Graphics g;
	
	public int[] treeSort() {
		
		Node root = new Node(a[0]);
		drawNode(root, 0, w, 50);
		
		for (int i=1; i<len; i++) {
			root.addChild(new Node(a[i]));
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, w, h);
			drawNode(root, 0, w, 50);
			General.doDelay(100);
		}
		
		ArrayList<Integer> sorted = root.addToAL(new ArrayList<Integer>());
		
		for (int i=0; i<len; i++) {
			this.a[i] = sorted.get(i);
		}
		
		return a;
	}
	
	public void drawNode(Node n, int xMin, int xMax, int y) {
		
		int x = (xMax + xMin) / 2;
		
		n.g = getGraphics();
		n.x = x;
		n.y = y;
		
		g.setColor(Color.WHITE);
		g.fillOval(x - 15, y - 15, 30, 30);
		
		if (n.lChild != null && n.hChild != null) {
			int lX = (xMin + x) / 2;
			int hX = (x + xMax) / 2;
			g.drawLine(x, y, lX, y + 40);
			g.drawLine(x, y, hX, y + 40);
			drawNode(n.lChild, xMin, x, y + 40);
			drawNode(n.hChild, x, xMax, y + 40);
		} else if (n.lChild != null && n.hChild == null) {
			g.drawLine(x, y, x - 5, y + 40);
			drawNode(n.lChild, xMin, xMax - 10, y + 40);
		} else if (n.hChild != null && n.lChild == null) {
			g.drawLine(x, y, x + 5, y + 40);
			drawNode(n.hChild, xMin + 10, xMax, y + 40);
		}
		
		g.setColor(Color.RED);
		g.drawString("" + n.val, x - 8, y+3);
		
	}
	
	public void init() {
		setBackground(Color.BLACK);
		setSize(w, h);
	}

	public void paint(Graphics g_) {
		
		g = g_;
		
		General.printArray(a, " ");
		this.treeSort();
		//Drawing.draw(g, a, sclX, sclY, h);
		
	}

}