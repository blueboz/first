package cn.boz.firstSwt;

import java.util.stream.IntStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class SwtMain {

	public static void main(String[] args) {

		var display = new Display();
		var shell = new Shell(display);
		shell.setBounds(50,50,600,500);
		var composite = new Composite(shell, SWT.NONE);
		composite.setBounds(10,10,500,400);
		composite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
		var comp2=new Composite(shell, SWT.NONE);
		comp2.setBounds(500, 10, 500, 400);
		comp2.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_YELLOW));
		var text=new Text(composite,SWT.READ_ONLY|SWT.MULTI|SWT.BORDER);
		
		text.setText("Î´Â¼Èë...\n");
		text.setBounds(0, 0, 480, 380);
		var menu = new Menu(shell);
		composite.setMenu(menu);
		
		shell.addShellListener(new ShellListener() {
			
			@Override
			public void shellIconified(ShellEvent arg0) {
				text.append("Shell IconinXfied\n");
				
			}
			
			@Override
			public void shellDeiconified(ShellEvent arg0) {
				text.append("Shell Deiconinfied\n");
			}
			
			@Override
			public void shellDeactivated(ShellEvent arg0) {
				text.append("Shell Deactived\n");
			}
			
			@Override
			public void shellClosed(ShellEvent arg0) {
				text.append("Shell Closed\n");
				int max=0;
				IntStream.range(0, max).forEach(n->{
					text.append(max-n+"s...\n");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});

			}
			
			@Override
			public void shellActivated(ShellEvent arg0) {
				text.append("Shell Actived\n");
				
			}
		});
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
