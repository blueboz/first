package cn.boz.base;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class BaseAppWindow extends ApplicationWindow{

	private int dh;
	private int dw;
	private float dlgwp=.4f;
	private float dlghp=.8f;

	public BaseAppWindow() {
		super(null);
	}

	public BaseAppWindow(float w,float h) {
		super(null);
		this.dlghp=h;
		this.dlgwp=w;
	}


	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setSize(400, 500);
		shell.setText("ListView实例");
		Display display = shell.getDisplay();
		Rectangle ca = display.getClientArea();
		dh = ca.height;
		dw = ca.width;
		int rw = (int) (dw * dlgwp);
		int rh = (int) (dh * dlghp);
		int x = (dw - rw) / 2;
		int y = (dh - rh) / 2;
		shell.setBounds(x, y, rw, rh);
	}
	
	public void run() {
		setBlockOnOpen(true);
		open();
		Display.getCurrent().dispose();
	}

}
