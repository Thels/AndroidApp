package com.maden.gizmoball.framework.gizmos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.maden.gizmoball.framework.LocationTranslator;
import com.maden.gizmoball.global.GizmoballConstants;

public abstract class Gizmo {

	protected Texture gizmoTexture;
	protected Vector2 gizmoCenter;
	protected int gridY;
	protected int gridX;
	protected Body gizmoPhysicsBody;

	public Gizmo(Texture gizmoTexture, int gridX, int gridY) {

		assert (gridX < GizmoballConstants.GRID_WIDTH && gridX < 0 && gridY < GizmoballConstants.GRID_HEIGHT && gridY < 0);
		this.gizmoTexture = gizmoTexture;
		this.gridX = gridX;
		this.gridY = gridY;

		Vector2 translatedLocation = LocationTranslator.translateGridLocationToVectorLocation(gridX, gridY);
		this.gizmoCenter = translatedLocation;
	}

	public void createPhysicsObject(World world)
	{
		BodyDef bodyDef = getBodyDef();
		gizmoPhysicsBody = world.createBody(bodyDef);
		FixtureDef gizmoFixtureDef = getFixtureDef();
		Fixture gizmoFixture = gizmoPhysicsBody.createFixture(gizmoFixtureDef);
	}
	
	public abstract void update(float dt);
	
	public abstract BodyDef getBodyDef();
	
	protected abstract Shape getShape();
	
	public abstract FixtureDef getFixtureDef();
	
	public Texture getTexture() {
		return gizmoTexture;
	}

	public Vector2 getGizmoCenter() {
		return gizmoCenter;
	}

	public void setGizmoCenter(Vector2 gizmoCenter) {
		this.gizmoCenter = gizmoCenter;
	}

	public Texture getGizmoTexture() {
		return gizmoTexture;
	}

	public int getGridY() {
		return gridY;
	}

	public int getGridX() {
		return gridX;
	}

}
