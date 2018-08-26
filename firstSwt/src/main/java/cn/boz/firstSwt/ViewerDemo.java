package cn.boz.firstSwt;

import org.eclipse.jface.text.source.CompositeRuler;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ViewerDemo {
	private int dw = 0;
	private int dh = 0;
	private int sw = 0;
	private int sh = 0;
	private double dlgwp = .6;
	private double dlghp = .6;
	protected Shell shell;
	private Display display;

	public static void main(String[] args) {
		var app = new ViewerDemo();
		app.start();
	}

	private void start() {
		display = new Display();
		shell = new Shell(display);
		shell.setText("TextViewer/SourceViewerÊµÀý");
		var ca = display.getClientArea();
		dh = ca.height;
		dw = ca.width;
		var rw = (int) (dw * dlgwp);
		var rh = (int) (dh * dlghp);
		var x = (dw - rw) / 2;
		var y = (dh - rh) / 2;
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
	
	private void render() {
		shell.setLayout(new FillLayout());
		SashForm sashForm = new SashForm(shell, SWT.NONE);
		CompositeRuler ruler = new CompositeRuler();
		new SourceViewer(shell,ruler , SWT.BORDER);

		sashForm.setWeights(new int[] {1});

	}

}
