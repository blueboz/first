package cn.boz.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;

public class MyAction extends Action {
	public static String ID="MyAction";

	public MyAction() {
		super();
		setId(ID);
		setText("MyAction");
		setToolTipText("My Action Tooltip");
		setImageDescriptor(ImageDescriptor.createFromFile(this.getClass(), "../res/Cursor.ico"));
	}
	
	@Override
	public void run() {
		System.out.println("MyAction Run");
		super.run();
	}
}
