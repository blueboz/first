package cn.boz.firstSwt;

import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import cn.boz.domain.ListContentProvider;
import cn.boz.domain.ListLabelProvider;
import cn.boz.domain.ListModel;
import cn.boz.domain.User;

public class LayoutMain {
	private int dw = 0;
	private int dh = 0;
	private int sw = 0;
	private int sh = 0;
	private double dlgwp = .18;
	private double dlghp = .3;
	protected Shell shell;

	public static void main(String[] args) {
		LayoutMain layoutMain = new LayoutMain();
		layoutMain.start();
	}

	private void start() {
		var display = new Display();
		shell = new Shell(display);
		shell.setText("¶Ô»°¿ò");
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
		FillLayout fillLayout = new FillLayout();
		shell.setLayout(fillLayout);
		List list = new List(shell,SWT.BORDER);

		ListViewer listViewer = new ListViewer(list);

		var lc=new ListContentProvider();
		listViewer.setLabelProvider(new ListLabelProvider());
		listViewer.setContentProvider(lc);
		ListModel listModel = new ListModel();
		listViewer.setInput(listModel);
		User user = new User();
		user.setName("JayChou");
		listModel.add(user);
		
	}

	
	//Form layout 
	private void render4() {
		FormLayout formLayout = new FormLayout();
		shell.setLayout(formLayout);

		var btn1 = new Button(shell, SWT.NONE);
		btn1.setText("µÇÂ¼1");
		FormData formData = new FormData();
		
		formData.left=new FormAttachment(10);
		formData.right=new FormAttachment(60);
		formData.top=new FormAttachment(30);
		formData.bottom=new FormAttachment(70);
		btn1.setLayoutData(formData);
		
	}
	private void render3() {
		var gl=new GridLayout();
		gl.numColumns=2;
		shell.setLayout(gl);

		Label label = new Label(shell,SWT.NONE);
		label.setText("µÇÂ¼Ãû:");
		label.setLayoutData(new GridData(SWT.NONE, SWT.NONE, false, false,1,1));

		var text=new Text(shell,SWT.NONE);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label label2 = new Label(shell,SWT.NONE);
		label2.setText("ÃÜÂë:");

		var text2=new Text(shell,SWT.NONE);
		text2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

	}
	private void render2() {
		var fillLayout = new FillLayout(SWT.VERTICAL);

		shell.setLayout(fillLayout);

		var btn1 = new Button(shell, SWT.NONE);
		btn1.setText("µÇÂ¼");
		var btn2 = new Button(shell, SWT.NONE);
		btn2.setText("µÇÂ¼");
		var btn3 = new Button(shell, SWT.NONE);
		btn3.setText("µÇÂ¼");

	}

}
