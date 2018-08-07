package cn.boz.firstSwt;

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.TreeViewer;
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

import cn.boz.domain.User;
import cn.boz.domain.User2;
import cn.boz.model.ListModel;
import cn.boz.model.UserStructure;
import cn.boz.provider.ListContentProvider;
import cn.boz.provider.ListLabelProvider;
import cn.boz.provider.MyTableLabelProvider;
import cn.boz.provider.TreeContentProvider;

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
	
	private void render() {
		FillLayout fillLayout = new FillLayout();
		shell.setLayout(fillLayout);
		var tv=new TreeViewer(shell, SWT.NONE);
		tv.setContentProvider(new TreeContentProvider());
		tv.setLabelProvider(new MyTableLabelProvider());
		UserStructure us = new UserStructure();
		var root=new User("0", "President" );
		us.setPresident(root);
		tv.setInput(us);
		us.add(new int[] {}, new User("1","m1"));
	}
	
	//下面是一个ListContentProvider的演示
	private void render5() {
		var gl=new GridLayout();
		gl.numColumns=3;
		shell.setLayout(gl);
		List list = new List(shell,SWT.BORDER);
		ListViewer listViewer = new ListViewer(list);
		GridData gridData = new GridData(SWT.FILL, SWT.CENTER,true,false,3,1);
		list.setLayoutData(gridData);
		Button btn1 = new Button(shell, SWT.NONE);
		btn1.setText("确定");

		Button btn2 = new Button(shell, SWT.NONE);
		btn2.setText("确定");
		
		Button btn3 = new Button(shell, SWT.NONE);
		btn3.setText("确定");
		
		Button btn4 = new Button(shell, SWT.NONE);
		btn4.setText("确定");
		
		var lc=new ListContentProvider();
		listViewer.setLabelProvider(new ListLabelProvider());
		listViewer.setContentProvider(lc);
		ListModel listModel = new ListModel();
		listViewer.setInput(listModel);
		User2 user = new User2();
		user.setName("JayChou");
		listModel.add(user);
		
	}

	
	//Form layout 
	private void render4() {
		FormLayout formLayout = new FormLayout();
		shell.setLayout(formLayout);

		var btn1 = new Button(shell, SWT.NONE);
		btn1.setText("登录1");
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
		label.setText("登录名:");
		label.setLayoutData(new GridData(SWT.NONE, SWT.NONE, false, false,1,1));

		var text=new Text(shell,SWT.NONE);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label label2 = new Label(shell,SWT.NONE);
		label2.setText("密码:");

		var text2=new Text(shell,SWT.NONE);
		text2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

	}
	private void render2() {
		var fillLayout = new FillLayout(SWT.VERTICAL);

		shell.setLayout(fillLayout);

		var btn1 = new Button(shell, SWT.NONE);
		btn1.setText("登录");
		var btn2 = new Button(shell, SWT.NONE);
		btn2.setText("登录");
		var btn3 = new Button(shell, SWT.NONE);
		btn3.setText("登录");

	}

}
