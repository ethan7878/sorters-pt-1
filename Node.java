package common;

import java.util.*;
import java.awt.*;

public class Node {
	
	public int val;
	Node parent;
	public Node lChild;
	public Node hChild;
	public Graphics g;
	public int x, y;
	
	public Node(int val) {
		this.val = val;
	}
	
	public void addChild(Node n) {
		if (n.val > this.val) {
			if (this.hChild != null)
				this.hChild.addChild(n);
			else
				this.hChild = n;
		}
		else {
			if (this.lChild != null)
				this.lChild.addChild(n);
			else
				this.lChild = n;
		}
	}
	
	public ArrayList<Integer> addToAL(ArrayList<Integer> al) {
		
		if (this.g != null) {
			g.setColor(Color.ORANGE);
			g.fillOval(this.x - 15, this.y - 15, 30, 30);
			g.setColor(Color.WHITE);
			g.drawString(this.val + "", this.x, this.y);
			General.doDelay(100);
		}
		
		if (this.lChild != null)
			al = this.lChild.addToAL(al);
		
		if (this.g != null) {
			g.setColor(Color.RED);
			g.fillOval(this.x - 15, this.y - 15, 30, 30);
			g.setColor(Color.WHITE);
			g.drawString(this.val + "", this.x, this.y);
			General.doDelay(100);
		}
		
		al.add(this.val);
		
		if (this.g != null) {
			g.setColor(Color.ORANGE);
			g.fillOval(this.x - 15, this.y - 15, 30, 30);
			g.setColor(Color.WHITE);
			g.drawString(this.val + "", this.x, this.y);
			General.doDelay(100);
		}
		
		if (this.hChild != null)
			al = this.hChild.addToAL(al);
		
		if (this.g != null) {
			g.setColor(Color.GRAY);
			g.fillOval(this.x - 15, this.y - 15, 30, 30);
			g.setColor(Color.WHITE);
			g.drawString(this.val + "", this.x, this.y);
			General.doDelay(100);
		}
		
		return al;
	}
	
	public String toString() {
		String out = "val = " + this.val;
		out = (this.lChild != null)? out + " low = " + this.lChild.val : out + " low = null";
		out = (this.hChild != null)? out + " high = " + this.hChild.val : out + " high = null";
		return out;
	}
	
}
