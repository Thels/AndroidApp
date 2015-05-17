package com.maden.gizmoball.states;

import static com.maden.gizmoball.global.GizmoballConstants.GRID_WIDTH;
import static com.maden.gizmoball.global.GizmoballConstants.V_HEIGHT;
import static com.maden.gizmoball.global.GizmoballConstants.V_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.maden.gizmoball.framework.gizmogrid.Gizmogrid;
import com.maden.gizmoball.framework.gizmogrid.impl.GizmogridImpl;
import com.maden.gizmoball.framework.gizmos.Gizmo;
import com.maden.gizmoball.framework.gizmos.impl.Ball;
import com.maden.gizmoball.framework.gizmos.impl.Block;
import com.maden.gizmoball.framework.physics.PhysicsManager;
import com.maden.gizmoball.global.GizmoballConstants;
import com.maden.gizmoball.rendering.Renderer;
import com.maden.gizmoball.rendering.impl.GizmoRendererImpl;

public class PlayState extends GameState {

	private Box2DDebugRenderer box2DRenderer;
	private OrthographicCamera box2DCamera;

	private Gizmogrid gizmoGrid;
	private Renderer renderer;
	private PhysicsManager physicsManager;

	protected PlayState(GameStateManager gameStateManager) {
		super(gameStateManager);

		
		box2DRenderer = new Box2DDebugRenderer();
		box2DCamera = new OrthographicCamera();
		box2DCamera.setToOrtho(false, V_WIDTH, V_HEIGHT);

		gizmoGrid = new GizmogridImpl();
		renderer = new GizmoRendererImpl();
		physicsManager = new PhysicsManager();

		Gizmo ball = new Ball(10, 10);
		gizmoGrid.placeGizmo(ball);
		ball.createPhysicsObject(physicsManager.getPhysicsWorld());

		for (int i = 0; i < GRID_WIDTH; i++) {
			Gizmo block = new Block(i, 0);
			gizmoGrid.placeGizmo(block);
			block.createPhysicsObject(physicsManager.getPhysicsWorld());
		}

		Gizmo block = new Block(GizmoballConstants.GRID_WIDTH, GizmoballConstants.GRID_HEIGHT);
		gizmoGrid.placeGizmo(block);
	
	}

	@Override
	public void handleUserInput() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(float dt) {
		for (Gizmo gizmo : gizmoGrid.getAllGizmos()) {
			if (gizmo == null) {
				continue;
			}
			gizmo.update(dt);
		}
		
		physicsManager.getPhysicsWorld().step(GizmoballConstants.GAME_STEP, 6, 2);
		
	}

	@Override
	public void render() {
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		box2DRenderer.render(physicsManager.getPhysicsWorld(), box2DCamera.combined);
		renderer.renderGizmos(spriteBatch, gizmoGrid.getAllGizmos());
	}

	@Override
	public void dispose() {

	}

}
