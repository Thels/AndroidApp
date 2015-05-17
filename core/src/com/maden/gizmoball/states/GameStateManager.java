package com.maden.gizmoball.states;

import java.util.Stack;

import com.maden.gizmoball.GizmoballGame;

public class GameStateManager {

	private GizmoballGame gizmoballGame;
	
	private Stack<GameState> gameStates;
	
	
	
	
	
	public GameStateManager(GizmoballGame game)
	{
		this.gizmoballGame = game;
		gameStates = new Stack<GameState>();
		
	}
	
	public GizmoballGame getGame()
	{
		return gizmoballGame;
	}
	
	public void updateGameState(float dt)
	{
		GameState peek = gameStates.peek();
		if(peek != null)
		{
			peek.update(dt);
		}
		else
		{
			throw new RuntimeException("Attempted to update null gamestate.");
		}
	}
	
	public void renderGameState()
	{
		GameState peek = gameStates.peek();
		if(peek != null)
		{
			peek.render();
		}
		else
		{
			throw new RuntimeException("Attempted to render null gamestate");
		}
	}
	
	private GameState getGameState(int gameState)
	{
		switch (gameState) {
		case 0:
			return new PlayState(this);
		default:
			return null;
		}
	}
	
	public void setGameState(int gameState)
	{
		removeCurrentGameState();
		pushGameState(gameState);
	}
	
	public void pushGameState(int gameState)
	{
		GameState newGameState = getGameState(gameState);
		if(newGameState != null)
		{
			gameStates.push(newGameState);
		}
	}
	
	public void removeCurrentGameState()
	{
		GameState currentGameState = gameStates.pop();
		currentGameState.dispose();
	}
	
	
	
	
	
	
	
	
	
}
