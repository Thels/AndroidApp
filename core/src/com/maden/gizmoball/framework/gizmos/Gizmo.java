package com.maden.gizmoball.framework.gizmos;

public abstract class Gizmo {

	private int xLocation;
	private int yLocation;

	public Gizmo(int xLocation, int yLocation) {
		this.xLocation = xLocation;
		this.yLocation = yLocation;
	}

	public int getX() {
		return this.xLocation;
	}

	public int getY() {
		return this.yLocation;
	}

}
