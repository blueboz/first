package com.bstek.utils.main;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bstek.utils.dao.DbDao;

public class DbUtils {
	protected static final Object Text = null;
	private DbDao dbDao = new DbDao();
	private int dw = 0;
	private int dh = 0;
	private int sw = 0;
	private int sh = 0;
	private double dlgwp = .6;
	private double dlghp = .6;
	protected Shell shell;
	private Display display;
	private Logger logger = LoggerFactory.getLogger(DbUtils.class);
	private Composite composite;

	private Map<String, Object> map = new LinkedHashMap<String, Object>();
	private Map<String, Object> mapControl = new HashMap<String, Object>();

	private void start() {
		display = new Display();
		shell = new Shell(display);
		shell.setText("数据库测试");
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

	public static void main(String[] args) {
		DbUtils dbutils = new DbUtils();
		dbutils.start();
	}

	private void render() {
		logger.info("Stating Loggin Using Slf4j");
		shell.setLayout(new GridLayout(7, false));
		{
			List list = new List(shell, SWT.BORDER);
			list.setItems(new String[] { "Druid", "DBCP", "Hikari" });
			list.setSelection(0);
			GridData gridData = new GridData(GridData.FILL_VERTICAL);
			gridData.horizontalSpan = 3;
			gridData.widthHint = 120;
			gridData.horizontalIndent = 5;
			list.setLayoutData(gridData);
		}
		{
			composite = new Composite(shell, SWT.BORDER);
			GridData gridData = new GridData(GridData.FILL_BOTH);
			gridData.horizontalSpan = 3;
			composite.setLayoutData(gridData);
			FillLayout stack = new FillLayout();
			composite.setLayout(stack);

			createContent();
		}
		{
			Button button = new Button(shell, SWT.None);
			button.setText("测试连接");
			GridData gridData = new GridData();
			gridData.horizontalSpan = 3;
			gridData.horizontalIndent = 5;
			button.setLayoutData(gridData);
			gridData.widthHint = 90;
			button.addSelectionListener(new SelectionListener() {

				@Override
				public void widgetSelected(SelectionEvent arg0) {
					Set<String> keys = mapControl.keySet();
					for (String key : keys) {
						Object ctl = mapControl.get(key);
						if (ctl instanceof Text) {
							Text text = (Text) ctl;
							String val = text.getText();
							System.out.println(key + "==>" + val);
						} else if (ctl instanceof Combo) {
							Combo combo = (Combo) ctl;
							String val = combo.getText();
							System.out.println(key + "==>" + val);
						}

					}

				}

				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {

				}
			});
		}
	}

	public void initMap() {
		map.put("URL",
				new String[] { "jdbc:oracle:thin:@192.168.187.130:1521:orcl",
						"jdbc:oracle:thin:@150.40.78.165:1521:dorado",
						"jdbc:mysql://localhost:3306/sakila?useUnicode=true&characterEncoding=UTF-8" });
		map.put("用户名", "sdbf");
		map.put("密码", "sdbf");
		map.put("驱动", new String[] { "oracle.jdbc.driver.OracleDriver", "com.mysql.jdbc.Driver",
				"com.microsoft.sqlserver.jdbc.SQLServerDriver" });
		// map.put("MaxActive", value)
	}

	private void createContent() {
		initMap();
		Composite comp1 = new Composite(composite, SWT.NONE);
		comp1.setLayout(new GridLayout(5, false));

		for (String key : map.keySet()) {
			{
				Label label = new Label(comp1, SWT.NONE);
				label.setText(key + ":");
				GridData gridData = new GridData();
				gridData.widthHint = 100;
				gridData.horizontalSpan = 2;
				label.setLayoutData(gridData);
			}
			{
				GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
				gridData.horizontalSpan = 3;
				if ("URL".equals(key) || "驱动".equals(key)) {
					Combo combo = new Combo(comp1, SWT.NONE);
					Object object = map.get(key);
					if (object instanceof String) {
						combo.setText((String) object);
					} else if (object instanceof String[]) {
						String[] items = (String[]) object;
						combo.setItems(items);
						if (items.length > 0) {
							combo.setText(items[0]);
						}
					}
					combo.setLayoutData(gridData);
					mapControl.put(key, combo);
				} else {
					Text text = new Text(comp1, SWT.BORDER);
					Object object = map.get(key);
					if (object instanceof String) {
						text.setText((String) object);
					}
					text.setLayoutData(gridData);

					mapControl.put(key, text);
				}
			}
		}

	}

}
