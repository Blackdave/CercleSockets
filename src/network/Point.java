package network;

import java.awt.Color;

public class Point {
	private int X;
	private int Y;
	private Color color = Color.blue;
	private int dim = 30;
	
	public Point(int x, int y){
		X = x;
		Y = y;
	}
	
	public int getX(){
		return X;
	}
	
	public int getY(){
		return Y;
	}
	
	public Color getColor(){
		return color;
	}
	
	public int getSize(){
		return dim;
	}
}
