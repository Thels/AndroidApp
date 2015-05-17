package com.maden.gizmoball.framework.physics;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.maden.gizmoball.framework.gizmos.Gizmo;

public class PhysicsManager {

	private World physicsWorld;
	private Map<Gizmo, Fixture> gizmoMap = new HashMap<Gizmo, Fixture>();

	public PhysicsManager() {
		physicsWorld = new World(new Vector2(0, -84f), false);
	}

	public void addGizmoToPhysicsWorld(Gizmo gizmo) {
		BodyDef bodyDef = gizmo.getBodyDef();
		Body gizmoBody = getPhysicsWorld().createBody(bodyDef);
		FixtureDef gizmoFixtureDef = gizmo.getFixtureDef();
		Fixture gizmoFixture = gizmoBody.createFixture(gizmoFixtureDef);
		gizmoMap.put(gizmo, gizmoFixture);

	}

	public World getPhysicsWorld() {
		return physicsWorld;
	}

}
