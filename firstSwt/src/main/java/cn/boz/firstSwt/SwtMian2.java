package cn.boz.firstSwt;

import java.io.InputStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class SwtMian2 {
	static int sw=0;
	static int sh=0;

	public static void main(String[] args) {
		var display = new Display();
		var shell = new Shell(display);	
		shell.setText("请登录");
		var ca=display.getClientArea();
		var height = ca.height;
		var width = ca.width;
		var r_width=900;
		var r_height=600;
		var x=(width-r_width)/2;
		var y=(height-r_height)/2;


		shell.setBounds(x, y, r_width, r_height);
		sw=shell.getClientArea().width;
		sh=shell.getClientArea().height;

		var com1=new Composite(shell, SWT.NONE);
		com1.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_YELLOW));
		com1.setBounds(getRect(5, 5, .49, .49));

		var label=new Label(com1, SWT.NONE);
		label.setBounds(10, 10, 50, 20);
		label.setText("用户名:");
		var text=new Text(com1, SWT.NONE);
		text.setBounds(60, 10, 180, 20);

		var label2=new Label(com1, SWT.NONE);
		label2.setBounds(10, 40, 50, 20);
		label2.setText("密码:");
		var text2=new Text(com1, SWT.NONE);
		text2.setBounds(60, 40, 180, 20);

		var com2=new Composite(shell, SWT.NONE);
		com2.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_GREEN));
		com2.setBounds(getRect((int)(sw*0.49+10), 5, .49, .49));
		var cursor=new Cursor(display, SWT.CURSOR_CROSS);
		com2.setCursor(cursor);

		var com3=new Composite(shell, SWT.NONE);
		com3.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_BLUE));
		com3.setBounds(getRect(5, (int)(sh*.49+10), .49, .49));
		com3.setCursor(display.getSystemCursor(SWT.CURSOR_HAND));

		var com4=new Composite(shell, SWT.NONE);
		com4.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
		com4.setBounds(getRect((int)(sw*0.49+10), (int)(sh*.49+10), .49, .49));
		var is = SwtMain.class.getResourceAsStream("../res/Cursor.ico");
		var imageData = new ImageData(is);
		var cr = new Cursor(display, imageData,0,0);
		com4.setCursor(cr);

		

		//shell.pack();

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	
	/**
	 * 按照百分比的方式进行划分
	 * @param wp 宽度百分比
	 * @param hp 高度百分比
	 * @return
	 */
	public static Rectangle getRect(int x,int y,double wp,double hp) {
		return new Rectangle(x, y,(int)(sw*wp), (int)(sh*hp));
	}
}
