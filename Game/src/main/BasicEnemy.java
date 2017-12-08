package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject {
	
	private int scale;
	private int maxSpeed = 2;
	private int acceleration = maxSpeed;
	
	public BasicEnemy(int x, int y, int scale, ID id) {
		super(x, y, scale, id, Color.red);
		this.scale = scale;
		
		velX = 0;
		velY = 0;
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if (acceleration > 0) {
			velX++;
			velY++;
			acceleration--;
		}
		
		velX = Game.clamp(velX, -maxSpeed, maxSpeed);
		velY = Game.clamp(velY, -maxSpeed, maxSpeed);
		
		x = Game.clamp(x, 0, Game.WIDTH - scale - 6);
		y = Game.clamp(y, 0, Game.HEIGHT - (scale * 2) - 12);
		
		if (x == Game.WIDTH - scale - 6) {
			velX *= -1;
		}
		if (y == Game.HEIGHT - (scale * 2) - 12) {
			velY *= -1;
		}
		if (x == 0) {
			velX *= -1;
		}
		if (y == 0) {
			velY *= -1;
		}
		

	}

	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, scale, scale);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, scale, scale);
	}
}
