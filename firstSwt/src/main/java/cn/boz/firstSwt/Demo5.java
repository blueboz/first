package cn.boz.firstSwt;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

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
		shell.setText("�Ի���");
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
		shell.setText("GoogleTalk���öԻ���ʵ�� ");
		shell.setLayout(new GridLayout(7, false));
		{
			list = new List(shell, SWT.BORDER);
			list.setItems(new String[] { "����", "��Ƶ", "����", "֪ͨ", "����" });
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
			StackLayout stackLayout = new StackLayout();
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
			stackLayout.topControl = comp1;
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.setText("����");
			GridData gridData = new GridData(SWT.LEFT, SWT.CENTER, true, false);
			gridData.horizontalSpan = 5;
			gridData.widthHint = 90;
			gridData.horizontalIndent = 5;
			button.setLayoutData(gridData);

			Button button2 = new Button(shell, SWT.NONE);
			button2.setText("ȷ��");
			GridData gridData2 = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
			gridData2.horizontalIndent = 5;
			gridData2.horizontalSpan = 1;
			gridData2.widthHint = 90;
			button2.setLayoutData(gridData2);

			Button button3 = new Button(shell, SWT.NONE);
			button3.setText("ȡ��");
			GridData gridData3 = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
			gridData3.horizontalIndent = 5;
			gridData3.horizontalSpan = 1;
			gridData3.widthHint = 90;
			button3.setLayoutData(gridData3);
		}
	}

	private void comp1Content() {
		// �� composite ����϶��� comp1 ���
		comp1 = new Composite(composite, SWT.BORDER);
		// �� comp1 �ϲ��� GridLayout ���֣��� comp1 �������� 5 ��
		comp1.setLayout(new GridLayout(5, false));
		// ���峣���ǩ����������в���
		{
			final Label labRoutine = new Label(comp1, SWT.NONE);
			labRoutine.setText(" ���� ");
			// �� GridData �� labRoutine ���в���
			GridData gridRoutine = new GridData();
			gridRoutine.horizontalSpan = 2;
			// ���� comp1 ���� 10 ������
			gridRoutine.verticalIndent = 10;
			labRoutine.setLayoutData(gridRoutine);
		}
		// ���� labSeparator �ָ�����ǩ����������в���
		{
			final Label labSeparator = new Label(comp1, SWT.SEPARATOR | SWT.HORIZONTAL);
			GridData gridSeparator = new GridData(GridData.FILL_HORIZONTAL);
			gridSeparator.horizontalSpan = 5;
			// ��ֱ��ռ 5 ��
			gridSeparator.verticalSpan = 5;
			labSeparator.setLayoutData(gridSeparator);
		}
		// ���� button1 �� button2 ��ѡ��ť����������в���
		{

			GridData gridButton = new GridData(GridData.FILL_HORIZONTAL);
			// ˮƽ��ռ 5 ��
			gridButton.horizontalSpan = 5;
			// ��ֱ��ռ 5 ��
			gridButton.verticalSpan = 5;
			// ���� comp1 ��߿� 20 ������
			gridButton.horizontalIndent = 20;
			final Button button1 = new Button(comp1, SWT.CHECK);
			button1.setText(" ���� Windows ���Զ����� (&S)");
			// �� button1 ���в���
			button1.setLayoutData(gridButton);
			// ���� button2 ��ѡ��ť����������в���
			final Button button2 = new Button(comp1, SWT.CHECK);
			button2.setText(" ���������ʼ�����ʱ�� Gmail(&O)");

			button2.setLayoutData(gridButton);
		}
		// ���� Group ����򣬲�������в���
		{
			final Group group = new Group(comp1, SWT.NONE);
			group.setText(" �����б� ");
			GridData gridGroup = new GridData(GridData.FILL_HORIZONTAL);
			gridGroup.horizontalSpan = 3;
			gridGroup.verticalSpan = 5;
			gridGroup.horizontalIndent = 20;
			group.setLayoutData(gridGroup);
			// ���� group ���������� , ����������в���
			{
				group.setLayout(new GridLayout());
				GridData gridDataButton = new GridData(GridData.FILL_HORIZONTAL);
				gridDataButton.verticalSpan = 6;
				gridDataButton.horizontalIndent = 6;
				final Button buttonOne = new Button(group, SWT.CHECK);
				buttonOne.setText(" ���������� (&N)");
				buttonOne.setLayoutData(gridDataButton);
				final Button buttonTwo = new Button(group, SWT.CHECK);
				buttonTwo.setText(" �������ߺ��� (&H)");
				buttonTwo.setLayoutData(gridDataButton);
				final Button buttonThree = new Button(group, SWT.CHECK);
				buttonThree.setText(" ���غ����б������ Gmail ��ϵ�� (&C)");
				buttonThree.setLayoutData(gridDataButton);
				final Button buttonFour = new Button(group, SWT.CHECK);
				buttonFour.setText(" ������ͨѶ���˼�������б� (&A))");
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
			buttonModify.setText(" �������� (&F)...");
			buttonModify.setLayoutData(gridDataButton);
			final Button buttonAccount = new Button(comp1, SWT.NONE);
			buttonAccount.setText(" �˻����� ...");
			buttonAccount.setLayoutData(gridDataButton);
		}
		{ // �� comp1 �϶��� �� ������ϼ�¼ �� ��ť����������в���
			final Button buttonDiagnose = new Button(comp1, SWT.NONE);
			buttonDiagnose.setText(" ������ϼ�¼ (&E)");
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
		// ������Ƶ��ǩ����������в���
		{
			final Label labelAudio = new Label(comp2, SWT.NONE);
			labelAudio.setText(" ��Ƶ ");
			GridData gridAudio = new GridData();
			gridAudio.verticalIndent = 10;
			labelAudio.setLayoutData(gridAudio);
		}
		// ���� comp2 ����ϵķָ�����ǩ
		{
			final Label labelSeparator = new Label(comp2, SWT.SEPARATOR | SWT.HORIZONTAL);
			GridData gridSeparator = new GridData(GridData.FILL_HORIZONTAL);
			gridSeparator.verticalSpan = 5;
			labelSeparator.setLayoutData(gridSeparator);
		}
		// �� comp2 �϶��� groupOne ����򣬲�������в���
		{
			Group groupOne = new Group(comp2, SWT.NONE);
			groupOne.setText(" ���롪��˷����� ");
			GridData gridGroupOne = new GridData(GridData.FILL_HORIZONTAL);
			gridGroupOne.horizontalIndent = 20;
			gridGroupOne.verticalSpan = 20;
			groupOne.setLayoutData(gridGroupOne);
			{ // ���� groupa ���������Ĳ���
				groupOne.setLayout(new GridLayout());

				GridData grid = new GridData();
				grid.verticalIndent = 5;
				grid.horizontalIndent = 10;
				final Combo combo1 = new Combo(groupOne, SWT.NONE);
				// ��������������������
				combo1.setItems(new String[] { " Ĭ���豸 ", "Realtek AC97 Audio" });
				combo1.setLayoutData(grid);
				final Button check1 = new Button(groupOne, SWT.CHECK);
				check1.setText(" �Զ�������˷������� (&A)");
				check1.setLayoutData(grid);
			}
		}
		// �� comp2 �϶��� groupTwo ����򣬲�������в���
		{
			Group groupTwo = new Group(comp2, SWT.NONE);
			groupTwo.setText(" ���롪����������� ");
			GridData gridGroupTwo = new GridData(GridData.FILL_HORIZONTAL);
			gridGroupTwo.horizontalIndent = 20;
			gridGroupTwo.verticalSpan = 20;
			groupTwo.setLayoutData(gridGroupTwo);
			{// ���� groupTwo ��������������������в���
				groupTwo.setLayout(new GridLayout());
				GridData gridData = new GridData();
				gridData.horizontalIndent = 10;
				gridData.widthHint = 138;
				gridData.verticalSpan = 5;

				final Label lab1 = new Label(groupTwo, SWT.NONE);
				lab1.setText(" ֪ͨ������ (&N)");
				lab1.setLayoutData(gridData);
				final Combo combo2 = new Combo(groupTwo, SWT.NONE);
				combo2.setItems(new String[] { " �����豸 ", " Ĭ���豸 ", "Realtek AC97 Audio" });
				combo2.setLayoutData(gridData);
				final Label lab2 = new Label(groupTwo, SWT.NONE);
				lab2.setText(" ���� (&C)");
				lab2.setLayoutData(gridData);
				final Combo combo3 = new Combo(groupTwo, SWT.NONE);
				combo3.setItems(new String[] { " Ĭ���豸 ", "Realtek AC97 Audio" });
				combo3.setLayoutData(gridData);
				final Button cancelButton = new Button(groupTwo, SWT.CHECK);
				cancelButton.setText(" ����ʱȡ������������ (&S)");
				GridData gridDataCancel = new GridData();
				gridDataCancel.verticalSpan = 6;
				cancelButton.setLayoutData(gridDataCancel);
			}
		}
		// �� comp2 ������ callButton ��ť����������в���
		{
			final Button callButton = new Button(comp2, SWT.CHECK);
			callButton.setText(" ����ʱȡ������������˷羲�� (&U)");
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
		labelRefuse.setText(" ���� ");
	}

	private void comp4Content() {
		comp4 = new Composite(composite, SWT.BORDER);
		comp4.setLayout(new GridLayout());
		final Label labelNotice = new Label(comp4, SWT.NONE);
		labelNotice.setText(" ֪ͨ ");
	}

	private void comp5Content() {
		comp5 = new Composite(composite, SWT.BORDER);
		comp5.setLayout(new GridLayout());
		final Label labelLink = new Label(comp5, SWT.NONE);
		labelLink.setText(" ���� ");
	}
}
