package fancy;

import common.*;

import java.applet.*;
import java.awt.*;
import java.util.*;

public class TimSort extends Applet {
	
	private static final long serialVersionUID = 1L;
	
	static int len = 200;
	int[] a = General.shuffle(General.newList(len));
	
	static int sclX = 8, sclY = 4, w = len * sclX, h = len * sclY + 50;
	
	static int comparisons = 0;
	
	static Graphics g;
	
	ArrayList<ArrayList<Integer>> runs;
	
	public ArrayList<ArrayList<Integer>> findRuns(int[] a) {
		
		ArrayList<ArrayList<Integer>> runs = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> aAL = new ArrayList<Integer>();
		for (int i=0; i<a.length; i++) {
			Drawing.draw(g, a, sclX, sclY, h);
			Drawing.drawBar(getGraphics(), a, sclX, sclY, i, h);
			General.doDelay(50);
			aAL.add(a[i]);
		}
		
		while (aAL.size() > 0) {
			
			int highest = -1;
			ArrayList<Integer> run = new ArrayList<Integer>();
			
			for (int i=0; i<aAL.size(); i++) {
				
				if (aAL.get(i) >= highest) {
					highest = aAL.get(i);
					run.add(highest);
					aAL.remove(i--);
				}
				
				comparisons++;
			}
			
			runs.add(run);
		}
		
		return runs;
	}
	
	public int[] putRunsInArray(int[] a, ArrayList<ArrayList<Integer>> runs) {
		
		int pos = 0;
		for (int i=0; i<runs.size(); i++) {
			for (int j=0; j<runs.get(i).size(); j++) {
				General.doDelay(50);
				Drawing.draw(g, a, sclX, sclY, h);
				Drawing.drawBar(g, a, sclX, sclY, pos, h);
				a[pos++] = runs.get(i).get(j);
			}
		}
		return a;
		
	}
	
	public static void mergeAll(int[] a, ArrayList<ArrayList<Integer>> runs) {
		int low = 0, mid = 0, high;
		for (int i=0; i<runs.size() - 1; i++) {
			mid += runs.get(i).size();
			high = mid + runs.get(i + 1).size();
			a = mergeArrays(a, low, mid, high);
		}
		
	}
	
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
			
			Drawing.draw(g, a, sclX, sclY, h);
			Drawing.drawBar(g, a, sclX, sclY, index1, h);
			Drawing.drawBar(g, a, sclX, sclY, index2, h);
			General.doDelay(50);
			
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

	public void paint(Graphics g_) {
		
		g = g_;

		runs = this.findRuns(a);
		Drawing.draw(g, a, sclX, sclY, h);
		this.putRunsInArray(a, runs);
		this.mergeAll(a, runs);
		Drawing.draw(g, a, sclX, sclY, h);
		
		
		System.out.println(comparisons);
		
	}

}
