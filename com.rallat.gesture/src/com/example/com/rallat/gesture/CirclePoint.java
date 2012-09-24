package com.example.com.rallat.gesture;

import android.graphics.Paint;

public class CirclePoint {
	private int index;
	private float x;
	private float y;
	private Paint paint;

	public Paint getPaint() {
		return paint;
	}

	public void setPaint(Paint paint) {
		this.paint = paint;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public CirclePoint(int index, float x, float y,int color) {
		this.x = x;
		this.y = y;
		this.index = index;
		this.paint=new Paint();
		paint.setColor(color);
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	

}
