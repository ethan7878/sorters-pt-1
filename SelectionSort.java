package basic;

import common.Drawing;
import common.General;

import java.awt.*;
import java.applet.*;

public class SelectionSort extends Applet {
	
	private static final long serialVersionUID = 1L;
	
	static int len = 200;
	int[] a = General.shuffle(General.newList(len));
	
	static int sclX = 8, sclY = 4, w = len * sclX, h = len * sclY + 50;
	
	static Graphics g;
	
	public static int[] selectionSort(int low, int high, int[] a) {
		
		for (int i=low; i<high; i++) {
			
			int lowIndex = i;
			
			for (int j=i; j<high; j++) {
				
				Drawing.drawBar(g, a, sclX, sclY, lowIndex, h);
				Drawing.drawBar(g, a, sclX, sclY, j, h);
				General.doDelay(1);
				
				if (a[j] < a[lowIndex])
					lowIndex = j;
				
			}
			
			General.swap(i, lowIndex, a);
			
		}
		
		return a;
		
	}
	
	public static int[] selectionSort(int low, int high, int[] a, Graphics g_) {
		g = g_;
		a = selectionSort(low, high, a);
		return a;
	}
	
	public void init() {
		
		setBackground(Color.BLACK);
		setSize(w, h);
		
	}
	
	public void paint(Graphics g_) { g = g_;
		
		selectionSort(0, a.length, a);
		Drawing.draw(g, a, sclX, sclY, h);
		
	}

}
