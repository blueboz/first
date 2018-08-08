package cn.boz.firstSwt;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.IntStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.math3.optim.linear.SolutionCallback;
import org.eclipse.jface.dialogs.ProgressIndicator;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DragDetectEvent;
import org.eclipse.swt.events.DragDetectListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.Widget;

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
	private Display display;
	
	StyledText st;

	public static void main(String[] args) {
		LayoutMain layoutMain = new LayoutMain();
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
	
	private void render() {
		// TODO Auto-generated method stub
		var ly=new FillLayout();
		shell.setLayout(ly);
		shell.addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				Shell se = (Shell) e.widget;
				Rectangle ca = se.getClientArea();
				GC gc = e.gc;
				gc.drawLine(ca.x, ca.y, ca.width, ca.height);
			}
		});

	}
	/**
	 * 
	 */
	private void render8() {
		var fl=new RowLayout();
		shell.setLayout(fl);
		Slider sld = new Slider(shell, SWT.HORIZONTAL);
		ProgressBar progressBar = new ProgressBar(shell, SWT.HORIZONTAL|SWT.SMOOTH);
		ProgressIndicator pi = new ProgressIndicator(shell);
		pi.beginTask(100);
		sld.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent var1) {
					new Thread(()->{

						IntStream.range(1, 100).forEach(it->{
							try {
								Thread.sleep(100);
								System.out.println(it);
								if(!display.isDisposed()) {
									
									display.syncExec(()->{
										if(!pi.isDisposed()) {
											pi.worked(it/10);
										}
									});
								}else {
									return ;
								}
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						});
					}).start();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent var1) {
				// TODO Auto-generated method stub
				
			}
		});
		//pi.done();

	}
	
	private void render7() {
		var layout = new GridLayout();
		layout.numColumns=3;
		shell.setLayout(layout);
		Text text = new Text(shell, SWT.SINGLE);
		GridData gridData = new GridData(SWT.FILL, SWT.CENTER,true,false,2,1);
		var btn=new Button(shell,SWT.PUSH);
		GridData btngd = new GridData(SWT.FILL, SWT.CENTER,false,false,1,1);
		btn.setText("Go!");
		btn.setLayoutData(btngd);
		btn.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent paramSelectionEvent) {
				String text2 = text.getText();
				try {
					var is=new URL(text2).openStream();
					String text = IOUtils.toString(is);
					st.setText(text);
					
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent paramSelectionEvent) {
				
			}
		});
		text.setLayoutData(gridData);

		ScrolledComposite sc = new ScrolledComposite(shell, SWT.VERTICAL);
		GridData gdc = new GridData(SWT.FILL, SWT.CENTER,true,true,3,10);
		sc.setLayoutData(gdc);
		st=new StyledText(sc, SWT.BORDER);
		st.setWordWrap(true);
		try {
			var is=new URL("http://yss.mof.gov.cn/zhuantilanmu/zfzw/201612/t20161206_2475290.html").openStream();
			byte[] bs = is.readAllBytes();
			var str=IOUtils.toString(is);
			st.setText(str);
			//后面这两部是必须的
			st.pack();
			sc.setContent(st);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void render6() {
		FillLayout fillLayout = new FillLayout();
		shell.setLayout(fillLayout);
		Tree tree = new Tree(shell,SWT.BORDER);
		TreeColumn treeColumn = new TreeColumn(tree, SWT.NONE);
		treeColumn.setText("名称");
		treeColumn.setWidth(123);
		TreeColumn id = new TreeColumn(tree, SWT.NONE);
		id.setText("id");
		id.setWidth(123);
		var tv=new TreeViewer(tree);
		tree.setHeaderVisible(true);
		tv.setContentProvider(new TreeContentProvider());
		tv.setLabelProvider(new MyTableLabelProvider());
		UserStructure us = new UserStructure();
		var root=new User("0", "President" );
		us.setPresident(root);
		tv.setInput(us);
		us.add(new int[] {}, new User("1","子1"));
		us.add(new int[] {0}, new User("1","孙1"));
		us.add(new int[] {0}, new User("1","孙2"));
		us.add(new int[] {0}, new User("1","孙3"));
		us.add(new int[] {0,0}, new User("1","曾孙1"));
		us.add(new int[] {0,0}, new User("1","曾孙1"));
		us.add(new int[] {0,0}, new User("1","曾孙1"));
		us.add(new int[] {0,1}, new User("1","曾孙1"));
		us.add(new int[] {0,1}, new User("1","曾孙1"));
		us.add(new int[] {0,1}, new User("1","曾孙1"));
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
