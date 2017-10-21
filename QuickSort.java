package recursive;

import common.Drawing;
import common.General;

import java.applet.*;
import java.awt.*;

public class QuickSort extends Applet {
	
	private static final long serialVersionUID = 1L;
	
	static int len = 200;
	int[] a = General.shuffle(General.newList(len));
	
	static int sclX = 8, sclY = 4, w = len * sclX, h = len * sclY + 50;
	
	static int comparisons = 0;
	
	static Graphics g;
	
	public static int[] quickSort(int[] a, int min, int max) {
		
		if (min == max)
			return a;
		
		int pivot = a[max - 1];
		int pivotIndex = max - 1;
		int compareIndex = min;
		
		while (pivotIndex > compareIndex) {
			
			Drawing.draw(g, a, sclX, sclY, h);
			Drawing.drawBar(g, a, sclX, sclY, pivotIndex, h);
			Drawing.drawBar(g, a, sclX, sclY, compareIndex, h);
			General.doDelay(1);
			//g.drawLine(0, h - sclY * pivot, w, h - sclY * pivot);
			
			if (a[compareIndex] < pivot) {
				compareIndex++;
				comparisons++;
			}
			
			else if (a[compareIndex] > pivot) {
				a = General.swap(compareIndex, pivotIndex - 1, a);
				a = General.swap(pivotIndex - 1, pivotIndex--, a);
				comparisons++;
			}
			
		}
		
		a = quickSort(a, min, pivotIndex);
		a = quickSort(a, pivotIndex + 1, max);
		
		return a;
	}
	
	public void init() {
		setBackground(Color.BLACK);
		setSize(w, h);
	}

	public void paint(Graphics g_) { g = g_;
		
		quickSort(a, 0, a.length);
		Drawing.draw(g, a, sclX, sclY);
		//System.out.println(comparisons);
		
	}

}