package com.maden.gizmoball.framework.gizmos.impl;

import static com.maden.gizmoball.global.GizmoballConstants.TILE_SIZE;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.maden.gizmoball.framework.gizmos.Gizmo;
import com.maden.gizmoball.rendering.TextureManager;

public class Block extends Gizmo {

	public Block(int gridX, int gridY) {
		super(TextureManager.getTexture("Block"), gridX, gridY);
	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub

	}

	@Override
	public BodyDef getBodyDef() {
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.StaticBody;
		return bodyDef;
	}

	@Override
	protected Shape getShape() {
		PolygonShape blockShape = new PolygonShape();
		blockShape.setAsBox(TILE_SIZE, TILE_SIZE);
		return blockShape;
	}

	@Override
	public FixtureDef getFixtureDef() {
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = getShape();
		return fixtureDef;
	}

}
