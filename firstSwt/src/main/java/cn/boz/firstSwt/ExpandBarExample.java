package cn.boz.firstSwt;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class ExpandBarExample {
	/**
	 * 
	 */
	public ExpandBarExample() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setSize(300, 270);
		shell.setText("ExpandBar 实例");
		shell.setLayout(new FillLayout());
// 定义扩展栏对象
		ExpandBar expandbar = new ExpandBar(shell, SWT.V_SCROLL);
// 定义第一个扩展栏项
		{
			Composite comp1 = new Composite(expandbar, SWT.NONE);
			comp1.setLayout(new GridLayout());
			new Slider(comp1, SWT.SMOOTH);
			new Scale(comp1, SWT.HORIZONTAL);
			new ProgressBar(comp1, SWT.INDETERMINATE);
// 定义扩展栏项的对象
			ExpandItem item1 = new ExpandItem(expandbar, SWT.NONE);
			item1.setText("ExpandItem Item1");
			item1.setHeight(100);// 设置Item 的高度
			item1.setControl(comp1);// setControl 方法控制comp1 的显现
		}
		{
			// 必要0
			Composite cmps = new Composite(expandbar, SWT.V_SCROLL);
			cmps.setLayout(new GridLayout());
			new Slider(cmps, SWT.SMOOTH);
			new Scale(cmps, SWT.HORIZONTAL);
			new ProgressBar(cmps, SWT.INDETERMINATE);

			ExpandItem it = new ExpandItem(expandbar, SWT.NONE);
			// 必要1
			it.setHeight(110);
			// 必要2
			it.setControl(cmps);
			/**
			 * ExpandItem 不是容器类，不能把组件定义在expandItem 上，而是Expandbar上 最后再自行进行绑定
			 */

		}
// 定义第二个扩展栏项
		{
			Composite comp2 = new Composite(expandbar, SWT.NONE);
			comp2.setLayout(new GridLayout());
// 设置提示性表情符
			final Label label1 = new Label(comp2, SWT.NONE);
			label1.setImage(display.getSystemImage(SWT.ICON_ERROR));
			final Label label2 = new Label(comp2, SWT.NONE);
			label2.setImage(display.getSystemImage(SWT.ICON_INFORMATION));
			final Label label3 = new Label(comp2, SWT.NONE);
			label3.setImage(display.getSystemImage(SWT.ICON_WARNING));
			final Label label4 = new Label(comp2, SWT.NONE);
			label4.setImage(display.getSystemImage(SWT.ICON_QUESTION));
			ExpandItem item2 = new ExpandItem(expandbar, SWT.NONE);
			item2.setText("ExpandItem Item2");
			item2.setHeight(160);
			item2.setControl(comp2);
		}
		// 定义第三个扩展栏项
		{
			Composite comp3 = new Composite(expandbar, SWT.NONE);
			comp3.setLayout(new GridLayout());
			new Button(comp3, SWT.CHECK).setText("CHECK");
			new Button(comp3, SWT.RADIO).setText("RADIO");
			ExpandItem item3 = new ExpandItem(expandbar, SWT.NONE);
			item3.setText("ExpandItem Item3");
			item3.setHeight(80);
			item3.setControl(comp3);
		}
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public static void main(String[] args) {
		new ExpandBarExample();
	}
}