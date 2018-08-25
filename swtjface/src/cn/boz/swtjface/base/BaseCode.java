package cn.boz.swtjface.base;


import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public abstract class BaseCode {
	private int dw = 0;
	private int dh = 0;
	private int sw = 0;
	private int sh = 0;
	private double dlgwp = .6;
	private double dlghp = .6;
	protected Shell shell;
	protected Display display;


	protected void start() {
		display = new Display();
		shell = new Shell(display);
		shell.setText("TextViewer/SourceViewer视图");
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
	
	protected abstract void render();

}
