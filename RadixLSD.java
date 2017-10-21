package no_ifs;

import common.Drawing;
import common.General;

import java.applet.*;
import java.awt.*;
import java.util.*;

public class RadixLSD extends Applet {
	
	private static final long serialVersionUID = 1L;
	
	static int len = 200;
	int[] a = General.shuffle(General.newList(len));
	
	static int sclX = 8, sclY = 4, w = len * sclX, h = len * sclY + 50;
	
	static Graphics g;
	
	public int[] radixLSDSort(int[] a, int low, int high) {
		
		ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<10; i++) {
			buckets.add(new ArrayList<Integer>());
		}
		
		int mostDigits = 4;
		
		// For each digit
		for (int i=0; i<mostDigits; i++) {
			
			// Put all into buckets
			for (int j=low; j<high; j++) {
				
				int index = getDigit(a[j], i);
				buckets.get(index).add(a[j]);
				
			}
			
			// Put back into Array
			int count = low;
			for (int x = 0; x<10; x++) {
				int size = buckets.get(x).size();
				for (int y=0; y<size; y++) {
					a[count] = buckets.get(x).get(0);
					buckets.get(x).remove(0);
					
					General.doDelay(1);
					Drawing.draw(g, a, sclX, sclY, h);
					Drawing.drawBar(g, a, sclX, sclY, count++);
				}
			}
			
		}
		
		return a;
	}
	
	public int getDigit(int num, int dig) {
		num %= (Math.pow(10, dig));
		num = (int) (num / Math.pow(10, dig - 1));
		return num;
	}
	
	public void init() {
		
		setBackground(Color.BLACK);
		setSize(w, h);
		
	}

	public void paint(Graphics g_) { g = g_;
		
		radixLSDSort(a, 0, a.length);
		Drawing.draw(g, a, sclX, sclY, h);
		
	}

}
