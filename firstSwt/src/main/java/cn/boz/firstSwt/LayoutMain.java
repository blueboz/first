package cn.boz.firstSwt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.IntStream;

import org.apache.commons.io.IOUtils;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.ProgressIndicator;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.custom.StyledText;
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
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;

import cn.boz.action.MyAction;
import cn.boz.domain.User;
import cn.boz.domain.User2;
import cn.boz.listener.MouseTracker;
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
	private double dlgwp = .5;
	private double dlghp = .5;
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
		var layout = new GridLayout();
		
		// TODO Auto-generated method stub

	}
	
	/**
	 * 一个Stack Layout最好的示例
	 */
	private void render14() {
		var layout=new GridLayout(2,false);
		shell.setLayout(layout);
		var slayout=new StackLayout();
		var comp=new Composite(shell, SWT.BORDER);
		var gd=new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan=2;
		comp.setLayout(slayout);
		comp.setLayoutData(gd);
		var text=new Text(comp,SWT.NONE);
		text.setText("文本");
		var btn=new Button(comp, SWT.NONE);
		btn.setText("按钮");
		var btn2=new Button(shell, SWT.NONE);
		btn2.setText("单击显示文本");
		var btn3=new Button(shell, SWT.NONE);
		btn3.setText("单击显示按钮");
		btn2.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				slayout.topControl=text;
				comp.layout();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		
		btn3.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				slayout.topControl=btn;
				comp.layout();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}
	
	private void render13() {
		var layout = new FillLayout();
		shell.setLayout(layout);
		var mm=new MenuManager();
		var bar=mm.createMenuBar(shell);
		shell.setMenuBar(bar);

		var mmc=new MenuManager("ChildMenu 2 ","CMenu");
		mmc.add(new MyAction());
		mmc.add(new MyAction());
		mmc.add(new MyAction());

		var mmc2=new MenuManager("ChildMenu ","CMenu");
		mmc2.add(new MyAction());
		mmc2.add(new MyAction());
		mmc2.add(new MyAction());

		mm.add(mmc2);
		mm.add(mmc);
		mm.update(true);
		
	}
	
	private void render12() {
		var layout = new FillLayout();
		shell.setLayout(layout);
		var tb=new ToolBar(shell,SWT.BAR);
		var tbm=new ToolBarManager(tb);
		tbm.add(new MyAction());
		tbm.update(true);
	}

	private void render11() {
		var layout = new FillLayout();
		shell.setLayout(layout);
		Text text = new Text(shell, SWT.BORDER | SWT.MULTI);
		new Thread(() -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			display.syncExec(() -> {
				text.setFocus();
			});
			try {
				var evt = new Event();
				evt.type = SWT.KeyDown;
				evt.keyCode = SWT.SHIFT;
				display.post(evt);
				evt.type = SWT.KeyUp;
				display.post(evt);

				var is = new FileInputStream(new File(
						"C:\\Users\\Administrator\\git\\firstSwt\\firstSwt\\src\\main\\java\\cn\\boz\\firstSwt\\LayoutMain.java"));
				var string = new String(is.readAllBytes(), "GBK");
				System.out.println(string);
				for (int i = 0; i < string.length(); i++) {
					char ch = string.charAt(i);
					boolean shift = Character.isUpperCase(ch);
					if (shift) {
						evt = new Event();
						evt.type = SWT.KeyDown;
						evt.keyCode = SWT.SHIFT;
						display.post(evt);
					}

					evt = new Event();
					evt.character = ch;
					evt.type = SWT.KeyDown;
					display.post(evt);
					evt.type = SWT.KeyUp;
					display.post(evt);
		
					if (shift) {
						evt = new Event();
						evt.type = SWT.KeyUp;
						evt.keyCode = SWT.SHIFT;
						display.post(evt);
					}
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}).start();

	}

	private void render10() {
		var layout = new FillLayout();
		shell.setLayout(layout);
		var mu = new Menu(shell, SWT.POP_UP);
		MenuItem menuItem = new MenuItem(mu, SWT.None);
		menuItem.setText("清空");
		menuItem.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent var1) {
				shell.redraw();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent var1) {
				// TODO Auto-generated method stub

			}
		});
		// Canvas canvas = new Canvas(shell, SWT.NONE);
		new MouseTracker(shell);
		// shell.setMenuBar(mu);
		shell.setMenu(mu);

	}

	private void render9() {
		// TODO Auto-generated method stub
		var ly = new FillLayout();
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

	private void render8() {
		var fl = new RowLayout();
		shell.setLayout(fl);
		Slider sld = new Slider(shell, SWT.HORIZONTAL);
		ProgressBar progressBar = new ProgressBar(shell, SWT.HORIZONTAL | SWT.SMOOTH);
		ProgressIndicator pi = new ProgressIndicator(shell);
		pi.beginTask(100);
		sld.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent var1) {
				new Thread(() -> {

					IntStream.range(1, 100).forEach(it -> {
						try {
							Thread.sleep(100);
							System.out.println(it);
							if (!display.isDisposed()) {

								display.syncExec(() -> {
									if (!pi.isDisposed()) {
										pi.worked(it / 10);
									}
								});
							} else {
								return;
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
		// pi.done();

	}

	private void render7() {
		var layout = new GridLayout();
		layout.numColumns = 3;
		shell.setLayout(layout);
		Text text = new Text(shell, SWT.SINGLE);
		GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
		var btn = new Button(shell, SWT.PUSH);
		GridData btngd = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		btn.setText("Go!");
		btn.setLayoutData(btngd);
		btn.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent paramSelectionEvent) {
				String text2 = text.getText();
				try {
					var is = new URL(text2).openStream();
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
		GridData gdc = new GridData(SWT.FILL, SWT.CENTER, true, true, 3, 10);
		sc.setLayoutData(gdc);
		st = new StyledText(sc, SWT.BORDER);
		st.setWordWrap(true);
		try {
			var is = new URL("http://yss.mof.gov.cn/zhuantilanmu/zfzw/201612/t20161206_2475290.html").openStream();
			byte[] bs = is.readAllBytes();
			var str = IOUtils.toString(is);
			st.setText(str);
			// 后面这两部是必须的
			st.pack();
			sc.setContent(st);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void render6() {
		FillLayout fillLayout = new FillLayout();
		shell.setLayout(fillLayout);
		Tree tree = new Tree(shell, SWT.BORDER);
		TreeColumn treeColumn = new TreeColumn(tree, SWT.NONE);
		treeColumn.setText("名称");
		treeColumn.setWidth(123);
		TreeColumn id = new TreeColumn(tree, SWT.NONE);
		id.setText("id");
		id.setWidth(123);
		var tv = new TreeViewer(tree);
		tree.setHeaderVisible(true);
		tv.setContentProvider(new TreeContentProvider());
		tv.setLabelProvider(new MyTableLabelProvider());
		UserStructure us = new UserStructure();
		var root = new User("0", "President");
		us.setPresident(root);
		tv.setInput(us);
		us.add(new int[] {}, new User("1", "子1"));
		us.add(new int[] { 0 }, new User("1", "孙1"));
		us.add(new int[] { 0 }, new User("1", "孙2"));
		us.add(new int[] { 0 }, new User("1", "孙3"));
		us.add(new int[] { 0, 0 }, new User("1", "曾孙1"));
		us.add(new int[] { 0, 0 }, new User("1", "曾孙1"));
		us.add(new int[] { 0, 0 }, new User("1", "曾孙1"));
		us.add(new int[] { 0, 1 }, new User("1", "曾孙1"));
		us.add(new int[] { 0, 1 }, new User("1", "曾孙1"));
		us.add(new int[] { 0, 1 }, new User("1", "曾孙1"));
	}

	// 下面是一个ListContentProvider的演示
	private void render5() {
		var gl = new GridLayout();
		gl.numColumns = 3;
		shell.setLayout(gl);
		List list = new List(shell, SWT.BORDER);
		ListViewer listViewer = new ListViewer(list);
		GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1);
		list.setLayoutData(gridData);
		Button btn1 = new Button(shell, SWT.NONE);
		btn1.setText("确定");

		Button btn2 = new Button(shell, SWT.NONE);
		btn2.setText("确定");

		Button btn3 = new Button(shell, SWT.NONE);
		btn3.setText("确定");

		Button btn4 = new Button(shell, SWT.NONE);
		btn4.setText("确定");

		var lc = new ListContentProvider();
		listViewer.setLabelProvider(new ListLabelProvider());
		listViewer.setContentProvider(lc);
		ListModel listModel = new ListModel();
		listViewer.setInput(listModel);
		User2 user = new User2();
		user.setName("JayChou");
		listModel.add(user);

	}

	// Form layout
	private void render4() {
		FormLayout formLayout = new FormLayout();
		shell.setLayout(formLayout);

		var btn1 = new Button(shell, SWT.NONE);
		btn1.setText("登录1");
		FormData formData = new FormData();

		formData.left = new FormAttachment(10);
		formData.right = new FormAttachment(60);
		formData.top = new FormAttachment(30);
		formData.bottom = new FormAttachment(70);
		btn1.setLayoutData(formData);

	}

	private void render3() {
		var gl = new GridLayout();
		gl.numColumns = 2;
		shell.setLayout(gl);

		Label label = new Label(shell, SWT.NONE);
		label.setText("登录名:");
		label.setLayoutData(new GridData(SWT.NONE, SWT.NONE, false, false, 1, 1));

		var text = new Text(shell, SWT.NONE);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label label2 = new Label(shell, SWT.NONE);
		label2.setText("密码:");

		var text2 = new Text(shell, SWT.NONE);
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
