package monkey.banana.game;

import javax.swing.ImageIcon;

public class Banana {
	private int bananaXCoordiante;
	private int bananaYCoordiante;
	final static int gridSquare = 25;
	
	public void setXCoordinate(int x){
		this.bananaXCoordiante = x;
		//System.out.println(x);
	}
	
	public int getXCoordinate(){
		return bananaXCoordiante;
	}
	
	public void setYCoordinate(int y){
		this.bananaYCoordiante = y;
		//System.out.println(y);
	}
	
	public int getYCoordinate(){
		return bananaYCoordiante;
	}
	
	public ImageIcon getBananaImage(){
		ImageIcon banI = new ImageIcon(Grid.class.getResource("/Images/banana2.png"));
		return banI;
	}
	
	public Banana setBananaCoordinates(Banana banana){
		//Banana banana = new Banana();
		banana.setXCoordinate(Game.generateRandomNumber()*gridSquare);
		banana.setYCoordinate(Game.generateRandomNumber()*gridSquare);
		return banana;
	}
}
