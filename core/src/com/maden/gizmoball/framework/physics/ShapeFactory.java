package com.maden.gizmoball.framework.physics;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;

public class ShapeFactory {

	public static CircleShape getCircleShape(Vector2 circleCenter, float circleRadius)
	{
		CircleShape circleShape = new CircleShape();
		circleShape.setPosition(circleCenter);
		circleShape.setRadius(circleRadius);
		return circleShape;
	}
	
	public static PolygonShape getTriangleShape(Vector2 triangleCenter, float triangleSize)
	{
		PolygonShape polygonShape = new PolygonShape();
		return polygonShape;
	}
	
	public static Shape getBoxShape(Vector2 boxCenter, float boxSize)
	{
		Shape boxShape = new Shape();
	}
	
}
