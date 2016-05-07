package monkey.banana.game;

public class MonkeyIdleState extends MonkeyState {
		

	public MonkeyState leftKeyPressed(Monkey monkey){
		if(monkey.getXCoordinate() > 0 && Game.gameTimer.isRunning()){
			monkey.setXCoordinate(monkey.getXCoordinate()-Monkey.gridSquare);
			return new MonkeyMovingState(monkey);
		}
		return this;
		
	
	}
	
	public MonkeyState rightKeyPressed(Monkey monkey){
		if(monkey.getXCoordinate() < 475 && Game.gameTimer.isRunning()){
			monkey.setXCoordinate(monkey.getXCoordinate()+Monkey.gridSquare);
			return new MonkeyMovingState(monkey);	
		}
		return this;
	}
	
	public MonkeyState upKeyPressed(Monkey monkey){
		if(monkey.getYCoordinate() > 0 && Game.gameTimer.isRunning()){
			monkey.setYCoordinate(monkey.getYCoordinate()-Monkey.gridSquare);
			return new MonkeyMovingState(monkey);	
		}
		return this;
	}
	
	public MonkeyState downKeyPressed(Monkey monkey){
		if(monkey.getYCoordinate() < 475 & Game.gameTimer.isRunning()){
			monkey.setYCoordinate(monkey.getYCoordinate()+Monkey.gridSquare);
			return new MonkeyMovingState(monkey);	
		}
		return this;
	}
}
