package com.maden.gizmoball.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.maden.gizmoball.GizmoballGame;
import com.maden.gizmoball.global.GizmoballConstants;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = GizmoballConstants.V_WIDTH;
		config.height = GizmoballConstants.V_HEIGHT;
		new LwjglApplication(new GizmoballGame(), config);
	}
	
}
