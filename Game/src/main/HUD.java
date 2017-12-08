package main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD{
	
	public void tick() {
		
	}
	
	public void render(Graphics g, Player player) {
		
		// empty health bar
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		
		// filled health bar
		g.setColor(Color.green);
		g.fillRect(15, 15, player.getHealth() * 2, 32);
		
		// health bar border
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
		
		// fps
		g.drawString("FPS: " + Game.getFrames(), Game.WIDTH - 65 , Game.HEIGHT - 30);
		
		// TODO points
	}
}
