package no_ifs;

import common.*;

import java.applet.*;
import java.awt.*;
import java.util.*;

public class Gravity extends Applet {
	
	private static final long serialVersionUID = 1L;
	
	static int len = 200;
	int[] a = General.shuffle(General.newList(len));
	
	static int sclX = 8, sclY = 4, w = len * sclX, h = len * sclY + 50;
	
	static int comparisons = 0;
	
	static Graphics g;
	
	public int[] countBeads(boolean[][] abacus) {
		int[] cols = new int[abacus.length]; 
		for (int x=0; x<abacus.length; x++) {
			for (int y=0; y<abacus.length; y++) {
				if (abacus[x][y])
					cols[x]++;
			}
		}
		return cols;
	}
	
	public int[] gravitySort(int[] a) {
		
		// Place beads in abacus
		boolean[][] abacus = new boolean[a.length][a.length];
		for (int x=0; x<a.length; x++) {
			for (int y=0; y<a[x]; y++) {
				abacus[x][y] = true;
			}
		}
		
		// Drop beads
		// For each number down max->0
		for (int y=abacus.length-1; y>=0; y--) {
			
			// Number of bars that fulfill that mark
			int beads = 0;
			
			// Go through each bar and check if it's tall enough
			for (int x=0; x<abacus.length; x++) {
				if (abacus[x][y])
					beads++;
			}
			
			// Go back through and add that number of beads back to the abacus
			for (int x=abacus.length-1; x>=0; x--) {
				abacus[x][y] = beads-- > 0;
			}
			
			// Display
			a = countBeads(abacus);
			General.doDelay(80);
			Drawing.draw(getGraphics(), a, sclX, sclY, h);
			
		}
		
		return a;
	}
	
	public void init() {
		
		setBackground(Color.BLACK);
		setSize(w, h);
		
	}
	
	public void paint(Graphics g) {
		
		a = gravitySort(a);
		
		Drawing.draw(g, a, sclX, sclY, h);
		
	}

}
