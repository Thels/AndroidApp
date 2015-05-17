package com.maden.gizmoball.framework;

import static com.maden.gizmoball.global.GizmoballConstants.TILE_SIZE;

import com.badlogic.gdx.math.Vector2;

public class LocationTranslator {

	public static Vector2 translateGridLocationToVectorLocation(int xLocation, int yLocation) {

		float translatedLocX = TILE_SIZE / 2;
		float translatedLocY = TILE_SIZE / 2;

		for (int i = 0; i < xLocation; i++) {
			translatedLocX += TILE_SIZE;
		}

		for (int i = 0; i < yLocation; i++) {
			translatedLocY += TILE_SIZE;
		}
		
		return new Vector2(translatedLocX, translatedLocY);
	}

}
