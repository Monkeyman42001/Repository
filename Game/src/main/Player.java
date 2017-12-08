package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {
	
	private int scale;
	protected int health;
	private int maxHealth;

	
	Random r = new Random();
	Handler handler;
	
	public Player(int x, int y, int scale, ID id, Color color, int maxHealth, Handler handler) {
		super(x, y, scale, id, color);
		this.scale = scale;
		health = maxHealth;
		this.maxHealth = maxHealth;
		this.handler = handler;
	}

	public void tick() {
		x += velX;
		y += velY;
		
		health = Game.clamp(health, 0, maxHealth);
		
		x = Game.clamp(x, 0, Game.WIDTH - scale - 6);
		y = Game.clamp(y, 0, Game.HEIGHT - (scale * 2) + 4);
		
		collision();
		
	}
	
	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getId() == ID.BasicEnemy) {
				if (getBounds().intersects(tempObject.getBounds())) {
					// collision code
					health--;
					
				}
			}
			
		}
	}

	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(Color.green);
		g2d.drawRect(getBounds().x, getBounds().y, scale, scale);
		
		g.setColor(color);
		g.fillRect(x + 1, y + 1, scale - 1, scale - 1);
	}
	
	public int getHealth() {
		return health;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, scale, scale);
	}

}
