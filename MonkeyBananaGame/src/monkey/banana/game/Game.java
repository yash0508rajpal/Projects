package monkey.banana.game;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Game extends JPanel implements KeyListener, ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int score;
	private static final int MIN = 0;
	private static final int MAX = 19;
	private final static int PANEL_HEIGHT = 500;
	private final static int PANEL_WIDTH = 500;
	private final int BANANAN_TIME = 7000;
	private final int GAME_TIME = 30000;
	private Image monkeyImg;
	private Image bananaImg;
	private boolean gameOn;
	private boolean startScreen;
	private Monkey monkey;
	private Banana banana;
	private Timer bananaTimer;
	static Timer gameTimer;
	
	

	
	
	public Game(){
		addKeyListener(this);
		gameOn = true;
		startScreen = true;
		setFocusable(true);
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		monkey = new Monkey();
		monkey.setMonkeyCoordinates(monkey);
		banana = new Banana();
		banana.setBananaCoordinates(banana);
		setImages();
		add(panel());
		
		
		//gameStart();	
	}
	
	public void gameStart(){
		score = 0;
		gameOn = true;
		gameTimer = new Timer(GAME_TIME,this);
		bananaTimer = new Timer(BANANAN_TIME, this);
		gameTimer.start();
		gameTimer.setRepeats(false);
		bananaTimer.start();
	}
	
	public Component panel(){
		JButton startButton = new JButton("Start"); 
		startButton.setLocation(1, 520);
		startButton.addActionListener(this);
		return startButton;
	}
	
	public void setImages(){
		ImageIcon mon = monkey.getMonkeyImage();
		ImageIcon ban = banana.getBananaImage();
		monkeyImg = mon.getImage();
		bananaImg = ban.getImage();
	}
	
	 public void paint(Graphics g) {
	        super.paint(g);
	        drawGraphics(g);
	          
	 }
	 
	 
	 
	 private void drawGraphics(Graphics g){
		 g.setColor(Color.white);
		 setBackground(Color.GREEN);
		 if(gameOn && score < 500){
			 g.drawImage(monkeyImg,monkey.getXCoordinate() ,monkey.getYCoordinate() , null);
			 g.drawImage(bananaImg,banana.getXCoordinate() ,banana.getYCoordinate() , null);
			 g.drawString("Score:" + Integer.toString(this.score),(PANEL_WIDTH - formatString(g).stringWidth("Score:")) / 2,520);
		 }
		 else{
			 gameOver(g);
		 }
	 }
	 
	 private FontMetrics formatString(Graphics g){
		 Font small = new Font("Helvetica", Font.BOLD, 18);
		 FontMetrics metr = getFontMetrics(small);
		 g.setFont(small);
		 g.setColor(Color.BLACK);
		 return metr;
		 
	 }
	 
	
	
	public static int generateRandomNumber(){
		return (int)(Math.random() * ((MAX - MIN) + 1)) + MIN;
	}
	
	
	
	public void setScore(int score){
		this.score = score;
	}
	
	public int getScore(){
		return this.score;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key =  e.getKeyCode();
		if(!startScreen){
			if(key == KeyEvent.VK_LEFT){
				monkey.leftKeyPressed();
			}
			if(key == KeyEvent.VK_RIGHT){
				monkey.rightKeyPressed();
			}
			if(key == KeyEvent.VK_UP){
				monkey.upKeyPressed();
			}
			if(key == KeyEvent.VK_DOWN){
				monkey.downKeyPressed();
			}
			repaint();
			checkMonkeyEatsBanana();
		}
		
		
		
	}
	
	public void checkMonkeyEatsBanana(){
		if(banana.getXCoordinate() == monkey.getXCoordinate() && banana.getYCoordinate() == monkey.getYCoordinate()){
			setScore(score + 100);
			bananaTimer.restart();
			do{
				banana = banana.setBananaCoordinates(banana);
			}while(monkey.getXCoordinate() == banana.getXCoordinate() && monkey.getYCoordinate() == banana.getYCoordinate());
			repaint();
		}
	}
	
		
		
		public void gameOver(Graphics g){
			String msg;
			FontMetrics metr = formatString(g);
			if(this.score == 500){
				msg = "Winner";
				g.drawString(msg, (PANEL_WIDTH - metr.stringWidth(msg)) / 2, PANEL_HEIGHT / 2);
				g.drawString("Score:" + Integer.toString(this.score), (PANEL_WIDTH - metr.stringWidth(msg)) / 2, (PANEL_HEIGHT / 2) + 20);
				g.drawImage(monkeyImg,((PANEL_WIDTH - metr.stringWidth(msg)) / 2)-40 ,PANEL_HEIGHT / 2 , null);
				startScreen = true;
				bananaTimer.stop();
				gameTimer.stop();
			}
			else if(!startScreen){
				msg = "Game Over";
				g.drawString(msg, (PANEL_WIDTH - metr.stringWidth(msg)) / 2, PANEL_HEIGHT / 2);
				g.drawString("Score:" + Integer.toString(this.score), (PANEL_WIDTH - metr.stringWidth(msg)) / 2, (PANEL_HEIGHT / 2) + 20);
				g.drawImage(monkeyImg,((PANEL_WIDTH - metr.stringWidth(msg)) / 2)-40 ,PANEL_HEIGHT / 2 , null);
				startScreen = true;
				
			}
			gameOn = false;
			requestFocusInWindow();
			
			
		}
		
		
		public void changeBananaLocation(){
			if(gameTimer.isRunning() && this.score < 500){
				banana = banana.setBananaCoordinates(banana);
				
			}
			else{
				bananaTimer.stop();
				gameTimer.stop();
				gameOn = false;
				
			}
			repaint(); // new added
			
		}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//changeMonkeyLocation();
		if(!startScreen){
			changeBananaLocation();
		}
		else{
			gameStart();
			startScreen = false;
			requestFocusInWindow();
		}
		
	}


	
	
	

	
	
	


	


	
	
	

	
}
