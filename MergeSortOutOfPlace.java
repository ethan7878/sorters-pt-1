package recursive;

import common.Drawing;
import common.General;

import basic.InsertionSort;

import java.applet.*;
import java.awt.*;

public class MergeSortOutOfPlace extends Applet {
	
	private static final long serialVersionUID = 1L;
	
	static int len = 200;
	int[] a = General.shuffle(General.newList(len));
	
	static int sclX = 8, sclY = 4, w = len * sclX, h = len * sclY + 50;
	
	static int comparisons = 0;
	
	static Graphics g;
	
	public static int[] mergeSort(int low, int high, int[] a) {
		
		if (low == high - 1)
			return a;
		
		// Pick midpoint
		int mid = (high + low) / 2;
		
		a = mergeSort(low, mid, a);
		a = mergeSort(mid, high, a);
		a = mergeArrays(a, low, mid, high);
		
		return a;
		
	}
	
	// Midpoint is index of first element in second half
	public static int[] mergeArrays(int[] a, int low, int midPoint, int high) {
		
		int[] newA = new int[high - low];
		int index1 = low, index2 = midPoint;
		
		for (int i=0; i<newA.length; i++) {
			
			if (index1 == midPoint) {
				for (int j=index2; j<high; j++) {
					newA[i] = a[j];
					i++;
				}
				break;
			} else if (index2 == high) {
				for (int j=index1; j<midPoint; j++) {
					newA[i] = a[j];
					i++;
				}
				break;
			}
			
			Drawing.drawBar(g, a, sclX, sclY, index1, h);
			Drawing.drawBar(g, a, sclX, sclY, index2, h);
			General.doDelay(1);
			
			if (a[index1] < a[index2]) {
				newA[i] = a[index1];
				index1++;
			} else {
				newA[i] = a[index2];
				index2++;
			}
			comparisons++;
		}
		
		for (int i=0; i<newA.length; i++) {
			a[low + i] = newA[i];
			General.doDelay(1);
			Drawing.draw(g, a, sclX, sclY, h);
		}
		
		return a;
		
	}
	
	public void init() {
		
		setBackground(Color.BLACK);
		setSize(w, h);
		
	}

	public void paint(Graphics g_) { this.g = g_;
		
		a = mergeSort(0, a.length, a);
		Drawing.draw(g, a, sclX, sclY, h);
		//System.out.println(comparisons);
		
	}

}
