package com.maden.gizmoball.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.maden.gizmoball.GizmoballGame;

public abstract class GameState {

	protected GameStateManager gameStateManager;
	protected GizmoballGame gizmoballGame;
	protected SpriteBatch spriteBatch;
	protected OrthographicCamera gameCamera;
	protected OrthographicCamera hudCamera;

	protected GameState(GameStateManager gameStateManager) {
		this.gameStateManager = gameStateManager;
		this.gizmoballGame = gameStateManager.getGame();
		this.spriteBatch = this.gizmoballGame.getSpriteBatch();
		this.gameCamera = this.gizmoballGame.getGameCamera();
		this.hudCamera = this.gizmoballGame.getHudCamera();
	}

	public abstract void handleUserInput();

	public abstract void update(float dt);

	public abstract void render();

	public abstract void dispose();

}
