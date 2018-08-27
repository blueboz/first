package cn.boz.firstSwt;

import java.util.ArrayList;
import java.util.stream.IntStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

public class Demo5 {
	private int dw = 0;
	private int dh = 0;
	private int sw = 0;
	private int sh = 0;
	private double dlgwp = .6;
	private double dlghp = .6;
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
	private java.util.List<Composite> lists=new ArrayList<Composite>();;

	private void render() {
		final var display = Display.getDefault();
		shell.setText("GoogleTalk设置对话框实例 ");
		shell.setLayout(new GridLayout(7, false));
		{
			list = new List(shell, SWT.BORDER);
			list.setItems(new String[] { "常规", "音频", "被拒", "通知", "链接" });
			var gd = new GridData(GridData.FILL_VERTICAL);
			gd.horizontalSpan = 3;
			gd.widthHint = 140;
			gd.horizontalIndent = 5;
			list.setLayoutData(gd);
			list.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent evt) {
					int selectionIndex = list.getSelectionIndex();
					stackLayout.topControl=lists.get(selectionIndex);
					composite.layout();
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {
					
				}
			});
		}
		{
			composite = new Composite(shell, SWT.BORDER);
			GridData gridData = new GridData(GridData.FILL_BOTH);
			gridData.horizontalSpan = 4;
			composite.setLayoutData(gridData);
			stackLayout = new StackLayout();
			composite.setLayout(stackLayout);
			comp1Content();
			comp2Content();
			comp3Content();
			comp4Content();
			comp5Content();
			lists.add(comp1);
			lists.add(comp2);
			lists.add(comp3);
			lists.add(comp4);
			lists.add(comp5);
			stackLayout.topControl = comp5;
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.setText("帮助");
			GridData gridData = new GridData(SWT.LEFT, SWT.CENTER, true, false);
			gridData.horizontalSpan = 5;
			gridData.widthHint = 90;
			gridData.horizontalIndent = 5;
			button.setLayoutData(gridData);

			Button button2 = new Button(shell, SWT.NONE);
			button2.setText("确定");
			GridData gridData2 = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
			gridData2.horizontalIndent = 5;
			gridData2.horizontalSpan = 1;
			gridData2.widthHint = 90;
			button2.setLayoutData(gridData2);
			button2.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					shell.close();
					super.widgetSelected(e);
				}
			});

			Button button3 = new Button(shell, SWT.NONE);
			button3.setText("取消");
			GridData gridData3 = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
			gridData3.horizontalIndent = 5;
			gridData3.horizontalSpan = 1;
			gridData3.widthHint = 90;
			button3.setLayoutData(gridData3);
		}
	}

	private void comp1Content() {
		// 在 composite 面板上定义 comp1 面板
		comp1 = new Composite(composite, SWT.BORDER);
		// 在 comp1 上采用 GridLayout 布局，将 comp1 容器设置 5 列
		comp1.setLayout(new GridLayout(5, false));
		// 定义常规标签，并对其进行布局
		{
			final Label labRoutine = new Label(comp1, SWT.NONE);
			labRoutine.setText(" 常规 ");
			// 用 GridData 对 labRoutine 进行布局
			GridData gridRoutine = new GridData();
			gridRoutine.horizontalSpan = 2;
			// 距离 comp1 顶端 10 个像素
			gridRoutine.verticalIndent = 10;
			labRoutine.setLayoutData(gridRoutine);
		}
		// 定义 labSeparator 分隔符标签，并对其进行布局
		{
			final Label labSeparator = new Label(comp1, SWT.SEPARATOR | SWT.HORIZONTAL);
			GridData gridSeparator = new GridData(GridData.FILL_HORIZONTAL);
			gridSeparator.horizontalSpan = 5;
			// 垂直抢占 5 列
			gridSeparator.verticalSpan = 5;
			labSeparator.setLayoutData(gridSeparator);
		}
		// 定义 button1 、 button2 复选框按钮，并对其进行布局
		{

			GridData gridButton = new GridData(GridData.FILL_HORIZONTAL);
			// 水平抢占 5 列
			gridButton.horizontalSpan = 5;
			// 垂直抢占 5 列
			gridButton.verticalSpan = 5;
			// 距离 comp1 左边框 20 个像素
			gridButton.horizontalIndent = 20;
			final Button button1 = new Button(comp1, SWT.CHECK);
			button1.setText(" 启动 Windows 会自动运行 (&S)");
			// 对 button1 进行布局
			button1.setLayoutData(gridButton);
			// 定义 button2 复选框按钮，并对其进行布局
			final Button button2 = new Button(comp1, SWT.CHECK);
			button2.setText(" 单击电子邮件链接时打开 Gmail(&O)");

			button2.setLayoutData(gridButton);
		}
		// 定义 Group 分组框，并对其进行布局
		{
			final Group group = new Group(comp1, SWT.NONE);
			group.setText(" 好友列表 ");
			GridData gridGroup = new GridData(GridData.FILL_HORIZONTAL);
			gridGroup.horizontalSpan = 3;
			gridGroup.verticalSpan = 5;
			gridGroup.horizontalIndent = 20;
			group.setLayoutData(gridGroup);
			// 设置 group 分组框上组件 , 并对组件进行布局
			{
				group.setLayout(new GridLayout());
				GridData gridDataButton = new GridData(GridData.FILL_HORIZONTAL);
				gridDataButton.verticalSpan = 6;
				gridDataButton.horizontalIndent = 6;
				final Button buttonOne = new Button(group, SWT.CHECK);
				buttonOne.setText(" 按姓名排列 (&N)");
				buttonOne.setLayoutData(gridDataButton);
				final Button buttonTwo = new Button(group, SWT.CHECK);
				buttonTwo.setText(" 隐藏离线好友 (&H)");
				buttonTwo.setLayoutData(gridDataButton);
				final Button buttonThree = new Button(group, SWT.CHECK);
				buttonThree.setText(" 隐藏好友列表以外的 Gmail 联系人 (&C)");
				buttonThree.setLayoutData(gridDataButton);
				final Button buttonFour = new Button(group, SWT.CHECK);
				buttonFour.setText(" 将经常通讯的人加入好友列表 (&A))");
				buttonFour.setLayoutData(gridDataButton);
			}
		}
		{

			GridData gridDataButton = new GridData();
			gridDataButton.horizontalSpan = 5;
			gridDataButton.verticalIndent = 8;
			gridDataButton.horizontalIndent = 20;
			gridDataButton.widthHint = 120;
			final Button buttonModify = new Button(comp1, SWT.NONE);
			buttonModify.setText(" 更改字体 (&F)...");
			buttonModify.setLayoutData(gridDataButton);
			final Button buttonAccount = new Button(comp1, SWT.NONE);
			buttonAccount.setText(" 账户设置 ...");
			buttonAccount.setLayoutData(gridDataButton);
		}
		{ // 在 comp1 上定义 “ 启用诊断记录 ” 按钮，并对其进行布局
			final Button buttonDiagnose = new Button(comp1, SWT.NONE);
			buttonDiagnose.setText(" 启用诊断记录 (&E)");
			GridData gridDiagnose = new GridData();
			gridDiagnose.horizontalSpan = 5;
			gridDiagnose.verticalIndent = 20;
			gridDiagnose.horizontalIndent = 20;
			gridDiagnose.widthHint = 120;
			buttonDiagnose.setLayoutData(gridDiagnose);
		}
	}

	private void comp2Content() {
		comp2 = new Composite(composite, SWT.BORDER);
		comp2.setLayout(new GridLayout());
		// 定义音频标签，并对其进行布局
		{
			final Label labelAudio = new Label(comp2, SWT.NONE);
			labelAudio.setText(" 音频 ");
			GridData gridAudio = new GridData();
			gridAudio.verticalIndent = 10;
			labelAudio.setLayoutData(gridAudio);
		}
		// 设置 comp2 面板上的分隔符标签
		{
			final Label labelSeparator = new Label(comp2, SWT.SEPARATOR | SWT.HORIZONTAL);
			GridData gridSeparator = new GridData(GridData.FILL_HORIZONTAL);
			gridSeparator.verticalSpan = 5;
			labelSeparator.setLayoutData(gridSeparator);
		}
		// 在 comp2 上定义 groupOne 分组框，并对其进行布局
		{
			Group groupOne = new Group(comp2, SWT.NONE);
			groupOne.setText(" 输入―麦克风或耳麦 ");
			GridData gridGroupOne = new GridData(GridData.FILL_HORIZONTAL);
			gridGroupOne.horizontalIndent = 20;
			gridGroupOne.verticalSpan = 20;
			groupOne.setLayoutData(gridGroupOne);
			{ // 设置 groupa 面板上组件的布局
				groupOne.setLayout(new GridLayout());

				GridData grid = new GridData();
				grid.verticalIndent = 5;
				grid.horizontalIndent = 10;
				final Combo combo1 = new Combo(groupOne, SWT.NONE);
				// 在下拉框中设置下拉项
				combo1.setItems(new String[] { " 默认设备 ", "Realtek AC97 Audio" });
				combo1.setLayoutData(grid);
				final Button check1 = new Button(groupOne, SWT.CHECK);
				check1.setText(" 自动调整麦克风灵敏度 (&A)");
				check1.setLayoutData(grid);
			}
		}
		// 在 comp2 上定义 groupTwo 分组框，并对其进行布局
		{
			Group groupTwo = new Group(comp2, SWT.NONE);
			groupTwo.setText(" 输入―扬声器或耳麦 ");
			GridData gridGroupTwo = new GridData(GridData.FILL_HORIZONTAL);
			gridGroupTwo.horizontalIndent = 20;
			gridGroupTwo.verticalSpan = 20;
			groupTwo.setLayoutData(gridGroupTwo);
			{// 设置 groupTwo 面板上组件，并对组件进行布局
				groupTwo.setLayout(new GridLayout());
				GridData gridData = new GridData();
				gridData.horizontalIndent = 10;
				gridData.widthHint = 138;
				gridData.verticalSpan = 5;

				final Label lab1 = new Label(groupTwo, SWT.NONE);
				lab1.setText(" 通知―铃声 (&N)");
				lab1.setLayoutData(gridData);
				final Combo combo2 = new Combo(groupTwo, SWT.NONE);
				combo2.setItems(new String[] { " 所有设备 ", " 默认设备 ", "Realtek AC97 Audio" });
				combo2.setLayoutData(gridData);
				final Label lab2 = new Label(groupTwo, SWT.NONE);
				lab2.setText(" 呼叫 (&C)");
				lab2.setLayoutData(gridData);
				final Combo combo3 = new Combo(groupTwo, SWT.NONE);
				combo3.setItems(new String[] { " 默认设备 ", "Realtek AC97 Audio" });
				combo3.setLayoutData(gridData);
				final Button cancelButton = new Button(groupTwo, SWT.CHECK);
				cancelButton.setText(" 响铃时取消扬声器静音 (&S)");
				GridData gridDataCancel = new GridData();
				gridDataCancel.verticalSpan = 6;
				cancelButton.setLayoutData(gridDataCancel);
			}
		}
		// 在 comp2 上设置 callButton 按钮，并对其进行布局
		{
			final Button callButton = new Button(comp2, SWT.CHECK);
			callButton.setText(" 呼叫时取消扬声器和麦克风静音 (&U)");
			GridData gridDataCall = new GridData();
			gridDataCall.horizontalIndent = 20;
			gridDataCall.verticalSpan = 6;
			callButton.setLayoutData(gridDataCall);
		}
	}

	private void comp3Content() {
		comp3 = new Composite(composite, SWT.BORDER);
		comp3.setLayout(new GridLayout());
		final Label labelRefuse = new Label(comp3, SWT.NONE);
		labelRefuse.setText("被拒 ");
		//new Scale(comp3, SWT.BORDER);
		var scale=new Scale(comp3, SWT.HORIZONTAL);
		//new Scale(comp3, SWT.VERTICAL);
		//new Label(parent, style)
		var label = new Label(comp3, SWT.BORDER);
		GridData gridData = new GridData();
		gridData.widthHint=160;
		label.setLayoutData(gridData);
		label.setBackground(display.getSystemColor(SWT.COLOR_CYAN));
		label.setText("音量");
		scale.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int val = scale.getSelection();
				label.setText("音量"+val+"");
				super.widgetSelected(e);
			}
		});

	}

	private void comp4Content() {
		comp4 = new Composite(composite, SWT.BORDER);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns=3;
		comp4.setLayout(gridLayout);
		final Label labelNotice = new Label(comp4, SWT.NONE);
		labelNotice.setText(" 通知 ");
		ExpandBar expandBar = new ExpandBar(comp4, SWT.NONE);
		ExpandItem expandItem = new ExpandItem(expandBar, SWT.NONE);
		ExpandItem expandItem2 = new ExpandItem(expandBar, SWT.NONE);

		Composite composite2 = new Composite(expandBar, SWT.NONE);
		composite2.setLayout(new FillLayout());
		Label label = new Label(composite2, SWT.NONE);
		label.setText("标签");
		expandItem.setHeight(120);
		expandItem.setControl(composite2);

		GridData gridData = new GridData();
		gridData.widthHint=220;
		gridData.heightHint=500;
		expandBar.setLayoutData(gridData);

	}

	private void comp5Content() {
		comp5 = new Composite(composite, SWT.BORDER);
		comp5.setLayout(new FillLayout());
		TabFolder tabFolder = new TabFolder(comp5, SWT.BOTTOM|SWT.BORDER);
		TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("Item1");
		TabItem tabItem2 = new TabItem(tabFolder, SWT.NONE);
		tabItem2.setText("Item2");
		TabItem tabItem3 = new TabItem(tabFolder, SWT.NONE);
		tabItem3.setText("Item2");
		{
			Composite comp1 = new Composite(tabFolder, SWT.BORDER);
			tabItem.setControl(comp1);
			comp1.setLayout(new RowLayout());
			new ProgressBar(comp1, SWT.INDETERMINATE);
		}
		
		CTabFolder cTabFolder = new CTabFolder(comp5, SWT.None);
		
		IntStream.range(1, 10).forEach(it->{
			CTabItem cTabItem = new CTabItem(cTabFolder, SWT.CLOSE);
			cTabItem.setText("标签"+it);
		});
		
	}
}
