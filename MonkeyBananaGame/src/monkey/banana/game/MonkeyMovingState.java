package monkey.banana.game;

public class MonkeyMovingState extends MonkeyState {
	
	public MonkeyMovingState(Monkey monkey){
		moveMonkey(monkey);
	}
	
	public MonkeyState moveMonkey(Monkey monkey){
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new MonkeyIdleState();
	}
	
		
}
