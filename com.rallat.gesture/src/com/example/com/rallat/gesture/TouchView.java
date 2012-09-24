package com.example.com.rallat.gesture;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class TouchView extends View{
	private float dx;
	private float dy;
	private final static int radius=30;
	private Paint paint;

	public TouchView(Context context) {
		super(context);
		paint=new Paint();
		paint.setColor(Color.GREEN);
		dx=radius;
		dy=radius;
	}

	@Override
	public void onDraw(Canvas canvas) {
        canvas.drawCircle(dx, dy, radius, paint);

	}
	@Override
	public boolean onTouchEvent(MotionEvent e){
		dx=e.getX();
		dy=e.getY();
		invalidate();
		return true;
		
	}
}
