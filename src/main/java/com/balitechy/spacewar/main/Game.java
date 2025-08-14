package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import javax.swing.JFrame;

// Nuevas importaciones para Abstract Factory
import com.balitechy.spacewar.main.abstractions.AbstractPlayer;
import com.balitechy.spacewar.main.abstractions.AbstractBackgroundRenderer;
import com.balitechy.spacewar.main.factories.GameElementsFactory;
import com.balitechy.spacewar.main.factories.FactoryProducer;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 320;
	public static final int HEIGHT = WIDTH / 12 * 9;
	public static final int SCALE = 2;
	public final String TITLE = "Space War 2D - Abstract Factory Pattern";
	
	private boolean running = false;
	private Thread thread;
	private SpritesImageLoader sprites;
	
	// Game components - now using abstractions
	private GameElementsFactory elementsFactory;
	private AbstractPlayer player;
	private RefactoredBulletController bullets;
	private AbstractBackgroundRenderer backgRenderer;
	
	public void init(){
		requestFocus();
		
		sprites = new SpritesImageLoader("/sprites.png");
		try {			
			sprites.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Add keyboard listener
		addKeyListener(new InputHandler(this));
		
		// Get factory based on current configuration
		elementsFactory = FactoryProducer.getFactory();
		
		// Initialize game components using factory
		player = elementsFactory.createPlayer((WIDTH * SCALE - AbstractPlayer.WIDTH) / 2, 
											 HEIGHT * SCALE - 50, this);
		bullets = new RefactoredBulletController(elementsFactory);
		backgRenderer = elementsFactory.createBackgroundRenderer();
		
		System.out.println("Game initialized with style: " + FactoryProducer.getCurrentStyle());
	}

	public SpritesImageLoader getSprites(){
		return sprites;
	}
	
	public RefactoredBulletController getBullets(){
		return bullets;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		switch(key){
			case KeyEvent.VK_RIGHT:
				player.setVelX(5);
			break;
			
			case KeyEvent.VK_LEFT:
				player.setVelX(-5);
			break;
			
			case KeyEvent.VK_UP:
				player.setVelY(-5);
			break;
			
			case KeyEvent.VK_DOWN:
				player.setVelY(5);
			break;
			
			case KeyEvent.VK_SPACE:
				shoot();
			break;
			
			// Style switching keys for demonstration
			case KeyEvent.VK_1:
				switchStyle(FactoryProducer.SPRITE_STYLE);
			break;
			
			case KeyEvent.VK_2:
				switchStyle(FactoryProducer.VECTORIAL_STYLE);
			break;
			
			case KeyEvent.VK_3:
				switchStyle(FactoryProducer.COLORFUL_VECTORIAL_STYLE);
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		switch(key){
			case KeyEvent.VK_RIGHT:
				player.setVelX(0);
			break;
			
			case KeyEvent.VK_LEFT:
				player.setVelX(0);
			break;
			
			case KeyEvent.VK_UP:
				player.setVelY(0);
			break;
			
			case KeyEvent.VK_DOWN:
				player.setVelY(0);
			break;
		}
	}
	
	private void switchStyle(String newStyle) {
		FactoryProducer.setCurrentStyle(newStyle);
		init(); // Reinitialize with new style
		System.out.println("Switched to style: " + newStyle);
	}
	
	private void shoot() {
		bullets.addBullet(player.getX() + (AbstractPlayer.WIDTH/2) - 5, 
						 player.getY() - 18, this);
	}
	
	private synchronized void start(){
		if(running) return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	private synchronized void stop(){
		if(!running) return;
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}
	
	/*
	 * Game thread runner. 
	 */
	@Override
	public void run() {
		init();
		
		long lastTime = System.nanoTime();
		final double numOfTicks = 60.0;
		double ns = 1000000000 / numOfTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println(updates + " ticks, fps " + frames + " - Style: " + FactoryProducer.getCurrentStyle());
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}
	
	/*
	 * Run the ticks of all game components.
	 */
	public void tick(){
		player.tick();
		bullets.tick();
	}
	
	/*
	 * Render overall game components.
	 */
	public void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		/////////////////////////////////
		
		try {
			backgRenderer.render(g, this);
			player.render(g);
			bullets.render(g);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		////////////////////////////////
		g.dispose();
		bs.show();
	}
	
	public static void main(String args[]){
		// Set initial style via system property or default
		String initialStyle = System.getProperty("game.style", FactoryProducer.SPRITE_STYLE);
		FactoryProducer.setCurrentStyle(initialStyle);
		
		Game game = new Game();
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		JFrame frame = new JFrame(game.TITLE);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		System.out.println("=== Space War 2D - Abstract Factory Pattern Demo ===");
		System.out.println("Press 1 for Sprite style");
		System.out.println("Press 2 for Vectorial style");
		System.out.println("Press 3 for Colorful Vectorial style");
		System.out.println("Use arrow keys to move, SPACE to shoot");
		
		game.start();
	}
}