package cn.bz.tickerhacker.view;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import cn.bz.tickerhacker.base.BaseAppWindow;
import cn.bz.tickerhacker.utils.ImageCache;
import cn.bz.tickerhacker.utils.NetworkUtils;
import cn.bz.tickerhacker.widget.ImageViewer;

public class Login extends BaseAppWindow {

	/**
	 * Create the application window.
	 */
	public Login() {
		createActions();
		addToolBar(SWT.FLAT | SWT.WRAP);
		addMenuBar();
		addStatusLine();
	}

	private Map<String, Object> cacheMap = new HashMap<String, Object>();
	private Button refresh;

	private Composite loginComp;

	private Composite infoComp;

	/**
	 * Create contents of the application window.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		StackLayout sl = new StackLayout();
		container.setLayout(sl);
		{
			loginComp = new Composite(container, SWT.NONE);
			loginComp.setLayout(new GridLayout(3, true));

			Label ul = new Label(loginComp, SWT.NONE);
			ul.setText("用户名:");
			GridData ulg = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
			ul.setLayoutData(ulg);
			ulg.verticalIndent = 20;

			Text ut = new Text(loginComp, SWT.BORDER);
			GridData utg = new GridData(SWT.LEFT, SWT.CENTER, true, false, 2, 1);
			utg.widthHint = 150;
			utg.verticalIndent = 20;
			ut.setLayoutData(utg);

			Label pl = new Label(loginComp, SWT.NONE);
			pl.setText("密码:");
			pl.setAlignment(SWT.RIGHT);
			GridData pg = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
			pl.setLayoutData(pg);

			Text pt = new Text(loginComp, SWT.PASSWORD | SWT.BORDER);
			GridData ptg = new GridData(SWT.LEFT, SWT.CENTER, true, false, 2, 1);
			ptg.widthHint = 150;
			pt.setLayoutData(ptg);

			Display display = Display.getCurrent();
			Composite vCode = new Composite(loginComp, SWT.BORDER);
			vCode.addMouseListener(new MouseListener() {

				@Override
				public void mouseUp(MouseEvent evt) {

				}

				@Override
				public void mouseDown(MouseEvent evt) {
					int x = evt.x;
					int y = evt.y;
					Composite cmp = new Composite(vCode, SWT.BORDER);
					cmp.setBackground(display.getSystemColor(SWT.COLOR_CYAN));
					cmp.setBounds(x - 10, y - 10, 20, 20);
					cmp.addMouseListener(new MouseListener() {

						@Override
						public void mouseUp(MouseEvent e) {

						}

						@Override
						public void mouseDown(MouseEvent e) {
							cmp.dispose();
						}

						@Override
						public void mouseDoubleClick(MouseEvent e) {

						}
					});

					vCode.layout();
				}

				@Override
				public void mouseDoubleClick(MouseEvent evt) {

				}
			});
			GridData vcg = new GridData(SWT.CENTER, SWT.CENTER, true, false, 3, 1);

			ImageLoader imageLoader = new ImageLoader();
			ImageData[] dts = imageLoader.load("editors/waiting.gif");

			ImageViewer imageViewer = new ImageViewer(vCode);
			imageViewer.setImages(dts, 0);

			vCode.setBounds(0, 0, dts[0].width, dts[0].height);
			vcg.widthHint = dts[0].width;
			vcg.heightHint = dts[0].height;
			imageViewer.pack();

			vCode.setLayoutData(vcg);

			Runnable refreshCode = () -> {
				display.syncExec(() -> {
					// 清除vCode 中的选择
					Control[] chs = vCode.getChildren();
					for (int i = 0; i < chs.length; i++) {
						if (!(chs[i] instanceof ImageViewer)) {
							chs[i].dispose();
						}
					}
					vCode.setBounds(0, 0, dts[0].width, dts[0].height);
					vcg.widthHint = dts[0].width;
					vcg.heightHint = dts[0].height;
					imageViewer.setVisible(true);
					vCode.layout();
					loginComp.layout();
				});

				InputStream inputStream = NetworkUtils.getInstance().getVCode();
				Image image = ImageCache.getInstance().getImage(inputStream);
				Rectangle bounds = image.getBounds();

				display.syncExec(() -> {
					vCode.setBackgroundImage(image);
					vcg.widthHint = bounds.width;
					vcg.heightHint = bounds.height;
					vCode.layout();
					loginComp.layout();
					imageViewer.setVisible(false);
				});
			};

			new Thread(refreshCode).start();

			Button login = new Button(loginComp, SWT.PUSH);
			login.setText("登录");
			login.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					Control[] cs = vCode.getChildren();
					StringBuilder sb = new StringBuilder();
					for (Control control : cs) {
						if (control instanceof Composite) {
							Rectangle bounds = control.getBounds();
							if (bounds.width == 20 && bounds.height == 20) {
								sb.append((bounds.x + 10) + "," + (bounds.y + 10) + ",");
							}
						}
					}
					if (sb.length() > 0) {
						sb.deleteCharAt(sb.length() - 1);
					}
					var vCM = new HashMap<String, Object>();
					vCM.put("answer", sb.toString());
					System.out.println(sb.toString());
					vCM.put("login_site", "E");
					vCM.put("rand", "sjrand");

					Map rst = NetworkUtils.getInstance().vCodeVerify(vCM);
					String result_code = (String) rst.get("result_code");
					String result_message = (String) rst.get("result_message");
					// 5 错误
					// 4 成功
					// 7 过期
					if ("4".equals(result_code)) {
						String uname = ut.getText();
						String psw = pt.getText();

						var map = new HashMap<String, Object>();
						map.put("appid", "otn");
						map.put("username", uname);
						map.put("password", psw);

						Map maprst = NetworkUtils.getInstance().login(map);

						int rCode =(int) maprst.get("result_code");
						if (0==rCode) {
							MessageDialog.openInformation(loginComp.getShell(), "信息", "登录成功!");
							sl.topControl = infoComp;
							container.layout();

						} else {
							MessageDialog.openInformation(loginComp.getShell(), "返回码",
									maprst.get("result_message") + ":" + rCode);
							new Thread(refreshCode).start();
						}
					} else {
						MessageDialog.openInformation(loginComp.getShell(), "返回码", result_message + ":" + result_code);
						// 刷新验证码
						new Thread(refreshCode).start();
					}
					super.widgetSelected(e);
				}
			});
			GridData logg = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
			login.setLayoutData(logg);

			refresh = new Button(loginComp, SWT.PUSH);
			refresh.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					new Thread(refreshCode).start();
					super.widgetSelected(e);
				}
			});
			refresh.setText("刷新验证码");

			sl.topControl = loginComp;
		}
		{
			infoComp = new Composite(container, SWT.NONE);
			infoComp.setLayout(new GridLayout(3,true));
			Button button = new Button(infoComp, SWT.NONE);
			button.setText("抓取用户信息");
			GridData bg = new GridData(SWT.LEFT, SWT.CENTER, false, false,3,1);
			button.setLayoutData(bg);
			button.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					var map=new HashMap<String,Object>();
					/*
					queryType: 2
					queryStartDate: 2018-09-29
					queryEndDate: 2018-09-30
					come_from_flag: my_order
					pageSize: 8
					pageIndex: 0
					query_where: 
					sequeue_train_name: 
						*/
					map.put("queryType", "2");
					map.put("queryStartDate", "2018-09-29");
					map.put("queryEndDate", "2018-09-30");
					map.put("come_from_flag", "my_order");
					map.put("pageSize", 8);
					map.put("pageIndex", 0);
					map.put("query_where", "G");
					map.put("sequeue_train_name", "");
					Map rst = NetworkUtils.getInstance().queryMyTicket(map);
					System.out.println(rst);
					super.widgetSelected(e);
				}
			});

		}

		return container;
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Create the menu manager.
	 * 
	 * @return the menu manager
	 */
	@Override
	protected MenuManager createMenuManager() {
		MenuManager menuManager = new MenuManager("menu");
		return menuManager;
	}

	/**
	 * Create the toolbar manager.
	 * 
	 * @return the toolbar manager
	 */
	@Override
	protected ToolBarManager createToolBarManager(int style) {
		ToolBarManager toolBarManager = new ToolBarManager(style);
		return toolBarManager;
	}

	/**
	 * Create the status line manager.
	 * 
	 * @return the status line manager
	 */
	@Override
	protected StatusLineManager createStatusLineManager() {
		StatusLineManager statusLineManager = new StatusLineManager();
		return statusLineManager;
	}

	/**
	 * Configure the shell.
	 * 
	 * @param newShell
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("New Application");
	}

	/**
	 * Return the initial size of the window.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}
}
