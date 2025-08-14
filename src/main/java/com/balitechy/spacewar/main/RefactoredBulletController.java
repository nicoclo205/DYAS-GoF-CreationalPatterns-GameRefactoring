package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.util.LinkedList;
import com.balitechy.spacewar.main.abstractions.AbstractBullet;
import com.balitechy.spacewar.main.factories.GameElementsFactory;

public class RefactoredBulletController {
	private LinkedList<AbstractBullet> bullets = new LinkedList<AbstractBullet>();
	private GameElementsFactory factory;
	
	public RefactoredBulletController(GameElementsFactory factory) {
		this.factory = factory;
	}
	
	public void tick(){
		for(int i = 0; i < bullets.size(); i++){
			if(bullets.get(i).getY() < 0){
				removeBullet(bullets.get(i));
			} else {
				bullets.get(i).tick();
			}
		}
	}
	
	public void render(Graphics g){
		for(int i = 0; i < bullets.size(); i++){
			bullets.get(i).render(g);
		}
	}
	
	public void addBullet(double x, double y, Game game){
		AbstractBullet bullet = factory.createBullet(x, y, game);
		bullets.add(bullet);
	}
	
	public void removeBullet(AbstractBullet bullet){
		bullets.remove(bullet);
	}
}