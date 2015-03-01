package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Fenetre {
	
	private JFrame f = new JFrame();
	private Panneau p = new Panneau();
	
	public Fenetre() {
		// TODO Auto-generated constructor stub
		f.setTitle("CecleSocket");
		f.setSize(800, 400);
		f.setLocationRelativeTo(null);
		f.setContentPane(p);
		f.setVisible(true);
	}
}
