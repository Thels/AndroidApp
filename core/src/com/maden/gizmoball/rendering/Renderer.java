package com.maden.gizmoball.rendering;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.maden.gizmoball.framework.gizmos.Gizmo;

public interface Renderer {

	public void renderGizmos(SpriteBatch spriteBatch, List<Gizmo> gizmos);
	
}
