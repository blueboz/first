package cn.boz.firstSwt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

public class Demo5 {
	private int dw = 0;
	private int dh = 0;
	private int sw = 0;
	private int sh = 0;
	private double dlgwp = .18;
	private double dlghp = .3;
	protected Shell shell;
	private Display display;
	public static void main(String[] args) {
		var layoutMain = new Demo5();
		layoutMain.start();
	}
	private void start() {
		display = new Display();
		shell = new Shell(display);
		shell.setText("对话框");
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
	
	private List list;
	private Composite composite;
	private StackLayout stackLayout;
	private Composite comp1;
	private Composite comp2;
	private Composite comp3;
	private Composite comp4;
	private Composite comp5;
	private void render() {
		final var display=Display.getDefault();
		shell.setText("GoogleTalk设置对话框实例 ");
		shell.setLayout(new GridLayout(7,false));
		list = new List(shell,SWT.BORDER);
		list.setItems(new String[] {"常规","音频","被拒","通知","链接"});
		var gd=new GridData(GridData.FILL_VERTICAL);
	}
}
