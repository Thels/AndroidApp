package com.maden.gizmoball.framework.gizmogrid;

import java.util.List;

import com.maden.gizmoball.framework.gizmos.Gizmo;


public interface Gizmogrid {
	List<Gizmo> getAllGizmos();

	boolean doesGizmoExist(int xLocation, int yLocation);

	void placeGizmo(Gizmo toPlace);
}
