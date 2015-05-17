package com.maden.gizmoball.rendering.impl;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.maden.gizmoball.framework.gizmos.Gizmo;
import com.maden.gizmoball.rendering.Renderer;

public class GizmoRendererImpl implements Renderer {

	private void renderGizmo(SpriteBatch spriteBatch, Gizmo gizmo) {
		Texture gizmoTexture = gizmo.getTexture();
		if (gizmoTexture != null) {
			spriteBatch.draw(gizmoTexture, gizmo.getGizmoCenter().x, gizmo.getGizmoCenter().y, gizmoTexture.getWidth(), gizmoTexture.getHeight());
		} else {
			throw new RuntimeException("Attempted to render gizmo which doesn't exist");
		}

	}

	@Override
	public void renderGizmos(SpriteBatch spriteBatch, List<Gizmo> gizmos) {

		assert (spriteBatch != null);

		spriteBatch.begin();

		for (Gizmo gizmo : gizmos) {
			if (gizmo == null)
				continue;
			renderGizmo(spriteBatch, gizmo);
		}

		spriteBatch.end();
	}

}
