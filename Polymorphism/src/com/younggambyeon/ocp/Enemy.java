package com.younggambyeon.ocp;

public class Enemy {

	private PathPattern pathPattern;

	public Enemy(PathPattern pathPattern) {
		this.pathPattern = pathPattern;
	}

	public void draw() {
		int x = this.pathPattern.nextX();
		int y = this.pathPattern.nextY();

		System.out.println("x : " + x);
		System.out.println("y : " + y);
		
		// draw logic...
		
	}
	
	public static void main(String[] args) {
		Enemy enemy = new Enemy(new SouthMovePattern());
		
		enemy.draw();
	}

}
