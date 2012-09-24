package com.example.com.rallat.gesture;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class MultiTouchView extends View {

	private int[] colors = { Color.BLUE, Color.GREEN };
	private CirclePoint[] points = {
			new CirclePoint(0, radius, radius, colors[0]),
			new CirclePoint(1, radius * 2, radius, colors[1]) };
	private final static int MAX_POINTER = 2;
	private final static int radius = 30;

	public MultiTouchView(Context context) {
		super(context);

	}

	@Override
	public void onDraw(Canvas canvas) {
		for (CirclePoint point : points) {
			if (point != null)
				canvas.drawCircle(point.getX(), point.getY(), radius,
						point.getPaint());

		}

	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int pointerCount = Math.min(event.getPointerCount(), MAX_POINTER);
		switch (event.getAction() & MotionEvent.ACTION_MASK) {
		case MotionEvent.ACTION_MOVE:
			for (int i = 0; i < pointerCount; i++) {
				points[i] = new CirclePoint(i, event.getX(i), event.getY(i),
						colors[i]);
			}
			invalidate();
			break;
		case MotionEvent.ACTION_DOWN:
			for (int i = 0; i < pointerCount; i++) {
				points[i] = new CirclePoint(i, event.getX(i), event.getY(i),
						colors[i]);
			}
			invalidate();
			break;
		case MotionEvent.ACTION_CANCEL:
			for (int i = 0; i < pointerCount; i++) {
				points[i] = null;

			}
			invalidate();
			break;

		default:
			break;
		}

		return true;

	}
}
