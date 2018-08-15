package com.bstek.utils.main;

import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class DbUtils {
	private int dw = 0;
	private int dh = 0;
	private int sw = 0;
	private int sh = 0;
	private double dlgwp = .18;
	private double dlghp = .3;
	protected Shell shell;
	private Display display;
	
	private void start() {
		display = new Display();
		shell = new Shell(display);
		shell.setText("¶Ô»°¿ò");
		Rectangle ca = display.getClientArea();
		dh = ca.height;
		dw = ca.width;
		int rw = (int) (dw * dlgwp);
		int rh = (int) (dh * dlghp);
		int x = (dw - rw) / 2;
		int y = (dh - rh) / 2;
		shell.setBounds(x, y, rw, rh);
		sw = shell.getClientArea().width;
		sh = shell.getClientArea().height;
		render();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

	public static void main(String[] args) {
		DbUtils dbutils=new DbUtils();
		dbutils.start();
	}
	
	private void render() {
		
	}
	
	
}
