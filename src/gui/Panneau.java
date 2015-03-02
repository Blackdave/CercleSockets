package gui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import network.Point;
import network.Reseau;
 
public class Panneau extends JPanel implements MouseListener, Runnable{  
	private Reseau r = null;
	private ArrayList<Point> listPoint = new ArrayList<Point>();
	private Point unPoint;
	
	public Panneau(){
		addMouseListener(this);
		(new Thread(this)).start();
	}
	
	public void paintComponent(Graphics g) {
	    
	    for(Point p : listPoint)
	    {
	    	g.setColor(p.getColor());
	      g.fillOval(p.getX() - p.getSize()/2, p.getY() - p.getSize()/2, p.getSize(), p.getSize());
	    }
	 }

@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	//Si jamais on clic sur le fenetre alors qu'il n'y a pas d'autres fenetres de lancés, alors il n'y a pas de réseau établit donc r = null
	if(r != null){
		//r.quiSuisje();
		r.envoyerPoint(new Point(e.getX(),e.getY()));
	}
	else{
		listPoint.add(new Point(e.getX(), e.getY()));
		repaint();
	}
	
}

@Override
public void run() {
	// TODO Auto-generated method stub
	if(r == null){
		r = new Reseau();
		//System.out.println("work");
		//Permet de tout de suite prendre en compte la réception d'un point quand un point est envoyé
		synchronized(this) {
			while((unPoint = r.recevoirPoint()) != null){
				System.out.println("Point recu : "+ unPoint.getX() + " "+ unPoint.getY());
				listPoint.add(unPoint);
				repaint();
			}
		}

	}
}
   
@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
}

@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	//System.out.println("dedans");
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	//System.out.println("dehors");
}

            
}