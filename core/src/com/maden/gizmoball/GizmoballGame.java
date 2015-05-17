package com.maden.gizmoball;

import static com.maden.gizmoball.global.GizmoballConstants.GAME_STEP;
import static com.maden.gizmoball.global.GizmoballConstants.V_HEIGHT;
import static com.maden.gizmoball.global.GizmoballConstants.V_WIDTH;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.maden.gizmoball.states.GameStateManager;

public class GizmoballGame extends ApplicationAdapter {

	private float gameTickAccum;
	private SpriteBatch spriteBatch;
	private OrthographicCamera gameCamera;
	private OrthographicCamera hudCamera;
	private GameStateManager gameStateManager;

	@Override
	public void create() {
		spriteBatch = new SpriteBatch();
		gameStateManager = new GameStateManager(this);
		setupCameras();
		gameStateManager.setGameState(0);
	}

	private void setupCameras() {
		gameCamera = new OrthographicCamera();
		gameCamera.setToOrtho(false, V_WIDTH, V_HEIGHT);

		hudCamera = new OrthographicCamera();
		hudCamera.setToOrtho(false, V_WIDTH, V_HEIGHT);
	}

	@Override
	public void render() {
		gameTickAccum += Gdx.graphics.getDeltaTime();
		while (gameTickAccum >= GAME_STEP) {
			gameTickAccum -= GAME_STEP;
			gameStateManager.updateGameState(GAME_STEP);
			gameStateManager.renderGameState();
		}
	}

	public SpriteBatch getSpriteBatch() {
		return spriteBatch;
	}

	public void setSpriteBatch(SpriteBatch spriteBatch) {
		this.spriteBatch = spriteBatch;
	}

	public OrthographicCamera getGameCamera() {
		return gameCamera;
	}

	public void setGameCamera(OrthographicCamera gameCamera) {
		this.gameCamera = gameCamera;
	}

	public OrthographicCamera getHudCamera() {
		return hudCamera;
	}

	public void setHudCamera(OrthographicCamera hudCamera) {
		this.hudCamera = hudCamera;
	}
}
