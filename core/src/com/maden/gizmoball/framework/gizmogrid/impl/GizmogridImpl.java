package com.maden.gizmoball.framework.gizmogrid.impl;

import static com.maden.gizmoball.global.GizmoballConstants.GRID_HEIGHT;
import static com.maden.gizmoball.global.GizmoballConstants.GRID_WIDTH;

import java.util.Arrays;
import java.util.List;

import com.maden.gizmoball.framework.gizmogrid.Gizmogrid;
import com.maden.gizmoball.framework.gizmos.Gizmo;

public class GizmogridImpl implements Gizmogrid {

	private Gizmo[] gizmoGrid;

	public GizmogridImpl() {
		gizmoGrid = new Gizmo[GRID_WIDTH * GRID_HEIGHT];
		System.out.println("Created grid of size = " + GRID_WIDTH * GRID_HEIGHT);
	}

	@Override
	public List<Gizmo> getAllGizmos() {
		return Arrays.asList(gizmoGrid);
	}

	@Override
	public boolean doesGizmoExist(int xLocation, int yLocation) {
		return gizmoGrid[(xLocation * GRID_WIDTH) + yLocation] != null;
	}

	@Override
	public void placeGizmo(Gizmo toPlace) {
		int xLocation = toPlace.getGridX();
		int yLocation = toPlace.getGridY();
		gizmoGrid[(xLocation * GRID_WIDTH) + yLocation] = toPlace;
	}

}
