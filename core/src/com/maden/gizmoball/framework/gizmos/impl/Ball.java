package com.maden.gizmoball.framework.gizmos.impl;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;
import com.maden.gizmoball.framework.gizmos.Gizmo;
import com.maden.gizmoball.rendering.TextureManager;

public class Ball extends Gizmo {

	public Ball(int gridX, int gridY) {
		super(TextureManager.getTexture("Ball"), gridX, gridY);
	}

	@Override
	public void update(float dt) {
		this.gizmoCenter = gizmoPhysicsBody.getPosition();
	}

	@Override
	public BodyDef getBodyDef() {
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		bodyDef.position.set(getGizmoCenter());
		return bodyDef;
	}

	@Override
	protected Shape getShape() {
		Shape ballShape = new CircleShape();
		ballShape.setRadius(getTexture().getHeight() / 2);
		return ballShape;
	}

	@Override
	public FixtureDef getFixtureDef() {
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = getShape();
		return fixtureDef;
	}

}
