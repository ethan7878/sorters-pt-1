package basic;

import common.Drawing;
import common.General;

import java.applet.*;
import java.awt.*;

public class BubbleSort extends Applet {
	
	private static final long serialVersionUID = 1L;
	
	static int len = 200;
	int[] a = General.shuffle(General.newList(len));
	
	static int sclX = 8, sclY = 4, w = len * sclX, h = len * sclY + 50;
	
	static Graphics g;
	
	public static int[] bubbleSort(int low, int high, int[] a) {
		
		int sortedIndex = high;
		
		for (int i=0; i<high-low; i++) {
			for (int j=low; j<sortedIndex - 1; j++) {
				Drawing.drawBar(g, a, sclX, sclY, j, h);
				General.doDelay(1);
				if (a[j] > a[j + 1])
					General.swap(j, j + 1, a);
			}
			sortedIndex--;
		}
		
		return a;
	}
	
	public static int[] bubbleSort(int low, int high, int[] a, Graphics g_) {
		g = g_;
		a = bubbleSort(low, high, a);
		return a;
	}
	
	public void init() {
		
		setBackground(Color.BLACK);
		setSize(w, h);
		
	}

	public void paint(Graphics g_) { g = g_;
		
		//General.printArray(a);
		a = bubbleSort(0, a.length, a);
		Drawing.draw(g, a, sclX, sclY, h);
		
	}

}