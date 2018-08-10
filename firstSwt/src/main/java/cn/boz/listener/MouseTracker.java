package cn.boz.listener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;

public class MouseTracker implements MouseListener,MouseMoveListener{

	protected Point org=new Point(0,0);
	protected boolean drawing;
	protected Canvas canvas;
	public MouseTracker(Canvas canvas) {
		this.canvas=canvas;
		canvas.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		canvas.addMouseListener(this);
		canvas.addMouseMoveListener(this);
		
	}
	@Override
	public void mouseMove(MouseEvent e) {
		var gc=new GC(canvas);
		if(drawing) {
			gc.drawLine(org.x, org.y, e.x, e.y);
			org.x=e.x;
			org.y=e.y;
		}
		
	}

	@Override
	public void mouseDoubleClick(MouseEvent var1) {
		
	}

	@Override
	public void mouseDown(MouseEvent e) {

		this.drawing=true;
		org.x=e.x;
		org.y=e.y;
	}

	@Override
	public void mouseUp(MouseEvent e) {
		this.drawing=false;
	}

}
