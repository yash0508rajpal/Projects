package monkey.banana.game;

import javax.swing.ImageIcon;

public class Monkey{
	private int monkeyXCoordiante;
	private int monkeyYCoordiante;
	private MonkeyState state;
	final static int gridSquare = 25;
	

	public Monkey(){
		state = new MonkeyIdleState();
	}
	
	public void setXCoordinate(int x){
		this.monkeyXCoordiante = x;
	}
	
	public int getXCoordinate(){
		return monkeyXCoordiante;
	}
	
	public void setYCoordinate(int y){
		this.monkeyYCoordiante = y;
	}
		
	public int getYCoordinate(){
		return monkeyYCoordiante;
	}
	
	public Monkey setMonkeyCoordinates(Monkey monkey){
		monkey.setXCoordinate(Game.generateRandomNumber()*gridSquare);
		monkey.setYCoordinate(Game.generateRandomNumber()*gridSquare);
		return monkey;
	}
	
	public ImageIcon getMonkeyImage(){
		ImageIcon monI = new ImageIcon(Grid.class.getResource("/Images/monkey2.png"));
		return monI;
	}
	
	public void leftKeyPressed(){
		state.leftKeyPressed(this);
	}
	
	public void rightKeyPressed(){
		state.rightKeyPressed(this);
	}
	
	public void upKeyPressed(){
		state.upKeyPressed(this);
	}
	
	public void downKeyPressed(){
		state.downKeyPressed(this);
	}
	
	
	

}
