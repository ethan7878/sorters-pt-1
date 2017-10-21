package common;

import java.awt.*;
import java.util.ArrayList;

public class Drawing {
	
	static int height = 650;
	
	public static void draw(Graphics g, int[] a, int sclX, int sclY) {
		
		for (int i=0; i<a.length; i++) {
			
			g.setColor(Color.BLACK);
			g.fillRect(i * sclX, 0, sclX, height);
			g.setColor(Color.BLUE);
			g.fillRect(i * sclX, height - a[i] * sclY, sclX, a[i] * sclY);
			g.setColor(Color.WHITE);
			g.drawRect(i * sclX, height - a[i] * sclY, sclX, a[i] * sclY);
			
		}
		
	}
	
	public static void draw(Graphics g, int[] a, int sclX, int sclY, int h) {
		height = h;
		draw(g, a, sclX, sclY);
	}
	
	public static void drawBar(Graphics g, int[] a, int sclX, int sclY, int index) {
		//Drawing.draw(g, a, sclX, sclY);
		g.setColor(Color.RED);
		g.fillRect(index * sclX, height - a[index] * sclY, sclX, a[index] * sclY);
	}
	
	public static void drawBar(Graphics g, int[] a, int sclX, int sclY, int index, int h) {
		height = h;
		drawBar(g, a, sclX, sclY, index);
	}
	
	public static void draw(Graphics g, ArrayList<Integer> a, int sclX, int sclY) {
		
		for (int i=0; i<a.size(); i++) {
			
			g.setColor(Color.BLACK);
			g.fillRect(i * sclX, 0, sclX, height);
			g.setColor(Color.BLUE);
			g.fillRect(i * sclX, height - a.get(i) * sclY, sclX, a.get(i) * sclY);
			g.setColor(Color.WHITE);
			g.drawRect(i * sclX, height - a.get(i) * sclY, sclX, a.get(i) * sclY);
			
		}
		
	}
	
	public static void draw(Graphics g, ArrayList<Integer> a, int sclX, int sclY, int h) {
		height = h;
		draw(g, a, sclX, sclY);
	}
	
	public static void drawBar(Graphics g, ArrayList<Integer> a, int sclX, int sclY, int index) {
		Drawing.draw(g, a, sclX, sclY);
		g.setColor(Color.RED);
		g.fillRect(index * sclX, height - a.get(index) * sclY, sclX, a.get(index) * sclY);
	}
	
	public static void drawBar(Graphics g, ArrayList<Integer> a, int sclX, int sclY, int index, int h) {
		height = h;
		drawBar(g, a, sclX, sclY, index);
	}
	
	public static void draw(Graphics g, ArrayList<Integer> a, int sclX, int sclY, int h, int x) {
		height = h;
		for (int i=0; i<a.size(); i++) {
			
			g.setColor(Color.BLACK);
			g.fillRect((i + x) * sclX, 0, sclX, height);
			g.setColor(Color.BLUE);
			g.fillRect((i + x) * sclX, height - a.get(i) * sclY, sclX, a.get(i) * sclY);
			g.setColor(Color.WHITE);
			g.drawRect((i + x) * sclX, height - a.get(i) * sclY, sclX, a.get(i) * sclY);
			
		}
	}

}
