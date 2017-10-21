package common;

import java.util.*;

public class General {
	
	public static void doDelay(double millis) {
		try {
			Thread.sleep((int) millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static int[] newList(int len) {
		
		int[] a = new int[len];
		
		for (int i=0; i<len; i++) {
			a[i] = i + 1;
		}
		
		return a;
		
	}
	
	public static int[] shuffle(int[] a) {
		
		Random rng = new Random();
		
		for (int i=a.length-1; i>0; i--) {
			int toSwap = rng.nextInt(i);
			General.swap(i, toSwap, a);
		}
		
		return a;
		
	}
	
	public static int[] swap(int pos1, int pos2, int[] a) {
		
		int temp = a[pos1];
		a[pos1] = a[pos2];
		a[pos2] = temp;
		
		return a;
	}
	
	public static int[] reverse(int[] a) {
		int[] newA = new int[a.length];
		for (int i=0; i<a.length; i++) {
			newA[i] = a[a.length - i - 1];
		}
		return newA;
	}
	
	public static void printArray(int[] a) {
		for (int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public static void printArray(int[] a, String end) {
		for (int i=0; i<a.length; i++) {
			System.out.print("" + a[i] + end);
		}
	}
	
	public static void printArray(ArrayList<Integer> a) {
		for (int i=0; i<a.size(); i++) {
			System.out.println(a.get(i));
		}
	}
	
	public static void printArray(ArrayList<Integer> a, String end) {
		for (int i=0; i<a.size(); i++) {
			System.out.print("" + a.get(i) + end);
		}
	}
	
	public static ArrayList<Integer> merge(ArrayList<Integer> al1, ArrayList<Integer> al2) {
		
		ArrayList<Integer> out = new ArrayList<Integer>();
		
		while (al1.size() > 0 && al2.size() > 0) {
			if (al1.get(0) < al2.get(0)) {
				out.add(al1.get(0));
				al1.remove(0);
			} else {
				out.add(al2.get(0));
				al2.remove(0);
			}
		}
		
		for (int i=0; i<al1.size(); i++) {
			out.add(al1.get(i));
		}
		
		for (int i=0; i<al2.size(); i++) {
			out.add(al2.get(i));
		}
		
		return out;
		
	}
}
