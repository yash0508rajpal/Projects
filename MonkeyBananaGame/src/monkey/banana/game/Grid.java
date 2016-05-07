package monkey.banana.game;

import java.awt.EventQueue;
import javax.swing.JFrame;



public class Grid extends JFrame {
	private final int GRID_WIDTH = 516;
	private final int GRID_HEIGHT = 580;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public Grid(){
		setTitle("Monkey-Banana game");
		setSize(GRID_WIDTH,GRID_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		add(new Game());
		
		
		
	}
	
	
	
    public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run(){
					new Grid();
			}
		});	
    	
	}



	

}
