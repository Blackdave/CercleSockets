package network;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Reseau {
	private Socket socket = null;
	private String whoami = new String();
	
	public Reseau(){
		try {
			socket = new Socket(InetAddress.getLocalHost(), 10666);
			System.out.println("Client");
			whoami = "Client";
		} catch (Exception e) {
			lancerServeur();
			System.out.println("Serveur");
			whoami = "Serveur";
		}
	}
	
	private void lancerServeur(){
		try {
			socket = (new ServerSocket(10666)).accept();
		} catch (Exception e) {
			//socket = null;
		}
	}
	
	public void envoyerPoint(Point p){
		try {
			ObjectOutputStream envoie = new ObjectOutputStream(socket.getOutputStream());
			envoie.writeObject(p);
		} catch (Exception e) {
			//socket = null;
		}
	}
	
	public Point recevoirPoint(){
		Point result = null;
		try {
				ObjectInputStream recevoir = new ObjectInputStream(socket.getInputStream());
				result = (Point)recevoir.readObject();
			} catch (Exception e) {
				//socket = null;
			}
			return result;
	}
	
	public void quiSuisje(){
		System.out.println(whoami);
	}
	
	
}
