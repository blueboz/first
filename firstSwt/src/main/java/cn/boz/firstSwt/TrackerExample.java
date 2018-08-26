package cn.boz.firstSwt;

import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

public class TrackerExample {
	private Tracker tracker;

	public TrackerExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(400, 300);
		shell.setText("Tracker ÊµÀý ");
		tracker = new Tracker(shell, SWT.RESIZE);
		shell.addMouseListener(new MouseAdapter() {
			public void mouseDown(MouseEvent e) {
				tracker.setRectangles(new Rectangle[] { new Rectangle(e.x-100, e.y-100, 0, 0), });
				System.out.println(e.x+"£º"+e.y);
				tracker.open();
			}
		});
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new TrackerExample();
	}
}