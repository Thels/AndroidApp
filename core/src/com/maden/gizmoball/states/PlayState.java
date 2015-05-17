package com.maden.gizmoball.states;

import static com.maden.gizmoball.global.GizmoballConstants.GAME_GRAVITY;
import static com.maden.gizmoball.global.GizmoballConstants.V_HEIGHT;
import static com.maden.gizmoball.global.GizmoballConstants.V_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class PlayState extends GameState {

	private World box2DWorld;
	private Box2DDebugRenderer box2DRenderer;
	private OrthographicCamera box2DCamera;

	protected PlayState(GameStateManager gameStateManager) {
		super(gameStateManager);
		box2DWorld = new World(new Vector2(0, GAME_GRAVITY), true);
		box2DRenderer = new Box2DDebugRenderer();
		box2DCamera = new OrthographicCamera();
		box2DCamera.setToOrtho(false, V_WIDTH, V_HEIGHT);

	}

	@Override
	public void handleUserInput() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {

		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		box2DRenderer.render(box2DWorld, box2DCamera.combined);

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
