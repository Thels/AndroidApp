package com.maden.gizmoball.rendering;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.maden.gizmoball.rendering.TextureManager;

public class TextureManager {

	private static final Map<String, Texture> TEXTURE_CACHE = new HashMap<String, Texture>();

	public static Texture getTexture(String name) {
		return TEXTURE_CACHE.get(name);
	}

	public static void addTexture(String name, Texture texture) {

		assert (name != null && texture != null);
		TEXTURE_CACHE.put(name, texture);
	}

	private static Texture resolveTexture(String fileName) {
		return new Texture(Gdx.files.internal(fileName));
	}

	static {
		addTexture("Ball", resolveTexture("ball.png"));
		addTexture("Block", resolveTexture("block.png"));
	}

}
