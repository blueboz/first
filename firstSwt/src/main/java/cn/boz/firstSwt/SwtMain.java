package cn.boz.firstSwt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class SwtMain {

	public static void main(String[] args) {

		var display = new Display();
		var shell = new Shell(display);

		
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

	}

}
